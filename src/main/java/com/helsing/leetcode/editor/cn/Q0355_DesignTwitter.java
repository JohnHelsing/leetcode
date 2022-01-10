//设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，
// 能够看见关注人（包括自己）的最近 10 条推文。
//
// 实现 Twitter 类： 
//
// 
// Twitter() 初始化简易版推特对象 
// void postTweet(int userId, int tweetId) 根据给定的 tweetId 和 userId 创建一条新推文。每次调用此函
//数都会使用一个不同的 tweetId 。 
// List<Integer> getNewsFeed(int userId) 检索当前用户新闻推送中最近 10 条推文的 ID 。新闻推送中的每一项都必须是
//由用户关注的人或者是用户自己发布的推文。推文必须 按照时间顺序由最近到最远排序 。 
// void follow(int followerId, int followeeId) ID 为 followerId 的用户开始关注 ID 为 
//followeeId 的用户。 
// void unfollow(int followerId, int followeeId) ID 为 followerId 的用户不再关注 ID 为 
//followeeId 的用户。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", 
//"unfollow", "getNewsFeed"]
//[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
//输出
//[null, null, [5], null, null, [6, 5], null, [5]]
//
//解释
//Twitter twitter = new Twitter();
//twitter.postTweet(1, 5); // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 5)
//twitter.getNewsFeed(1);  // 用户 1 的获取推文应当返回一个列表，其中包含一个 id 为 5 的推文
//twitter.follow(1, 2);    // 用户 1 关注了用户 2
//twitter.postTweet(2, 6); // 用户 2 发送了一个新推文 (推文 id = 6)
//twitter.getNewsFeed(1);  // 用户 1 的获取推文应当返回一个列表，其中包含两个推文，id 分别为 -> [6, 5] 。推文 
//id 6 应当在推文 id 5 之前，因为它是在 5 之后发送的
//twitter.unfollow(1, 2);  // 用户 1 取消关注了用户 2
//twitter.getNewsFeed(1);  // 用户 1 获取推文应当返回一个列表，其中包含一个 id 为 5 的推文。因为用户 1 已经不再关注用
//户 2 
//
// 
//
// 提示： 
//
// 
// 1 <= userId, followerId, followeeId <= 500 
// 0 <= tweetId <= 10⁴ 
// 所有推特的 ID 都互不相同 
// postTweet、getNewsFeed、follow 和 unfollow 方法最多调用 3 * 10⁴ 次 
// 
// Related Topics 设计 哈希表 链表 堆（优先队列） 👍 272 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.*;

public class Q0355_DesignTwitter {

    public static void main(String[] args) {
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Twitter {
        /**
         * 用户 id 和推文（单链表）的对应关系
         */
        private Map<Integer, Tweet> twitter;

        /**
         * 用户 id 和他关注的用户列表的对应关系
         */
        private Map<Integer, Set<Integer>> followings;

        /**
         * 全局使用的时间戳字段，用户每发布一条推文之前 + 1
         */
        private static int timestamp = 0;

        /**
         * 合并 k 组推文使用的数据结构（可以在方法里创建使用），声明成全局变量非必需，视个人情况使用
         */
        private static PriorityQueue<Tweet> maxHeap;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            followings = new HashMap<>();
            twitter = new HashMap<>();
            maxHeap = new PriorityQueue<>((o1, o2) -> -o1.timestamp + o2.timestamp);
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            timestamp++;
            if (twitter.containsKey(userId)) {
                Tweet oldHead = twitter.get(userId);
                Tweet newHead = new Tweet(tweetId, timestamp);
                newHead.next = oldHead;
                twitter.put(userId, newHead);
            } else {
                twitter.put(userId, new Tweet(tweetId, timestamp));
            }
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            // 由于是全局使用的，使用之前需要清空
            maxHeap.clear();

            // 如果自己发了推文也要算上
            if (twitter.containsKey(userId)) {
                maxHeap.offer(twitter.get(userId));
            }

            Set<Integer> followingList = followings.get(userId);
            if (followingList != null && followingList.size() > 0) {
                for (Integer followingId : followingList) {
                    Tweet tweet = twitter.get(followingId);
                    if (tweet != null) {
                        maxHeap.offer(tweet);
                    }
                }
            }

            List<Integer> res = new ArrayList<>(10);
            int count = 0;
            while (!maxHeap.isEmpty() && count < 10) {
                Tweet head = maxHeap.poll();
                res.add(head.id);

                // 这里最好的操作应该是 replace，但是 Java 没有提供
                if (head.next != null) {
                    maxHeap.offer(head.next);
                }
                count++;
            }
            return res;
        }


        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         *
         * @param followerId 发起关注者 id
         * @param followeeId 被关注者 id
         */
        public void follow(int followerId, int followeeId) {
            // 被关注人不能是自己
            if (followeeId == followerId) {
                return;
            }

            // 获取我自己的关注列表
            Set<Integer> followingList = followings.get(followerId);
            if (followingList == null) {
                Set<Integer> init = new HashSet<>();
                init.add(followeeId);
                followings.put(followerId, init);
            } else {
                if (followingList.contains(followeeId)) {
                    return;
                }
                followingList.add(followeeId);
            }
        }


        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         *
         * @param followerId 发起取消关注的人的 id
         * @param followeeId 被取消关注的人的 id
         */
        public void unfollow(int followerId, int followeeId) {
            if (followeeId == followerId) {
                return;
            }

            // 获取我自己的关注列表
            Set<Integer> followingList = followings.get(followerId);

            if (followingList == null) {
                return;
            }
            // 这里删除之前无需做判断，因为查找是否存在以后，就可以删除，反正删除之前都要查找
            followingList.remove(followeeId);
        }

        /**
         * 推文类，是一个单链表（结点视角）
         */
        private class Tweet {
            /**
             * 推文 id
             */
            private int id;

            /**
             * 发推文的时间戳
             */
            private int timestamp;
            private Tweet next;

            public Tweet(int id, int timestamp) {
                this.id = id;
                this.timestamp = timestamp;
            }
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
