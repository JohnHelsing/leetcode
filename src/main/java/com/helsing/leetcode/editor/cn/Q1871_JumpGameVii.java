//给你一个下标从 0 开始的二进制字符串 s 和两个整数 minJump 和 maxJump 。一开始，你在下标 0 处，且该位置的值一定为 '0' 。当同时
//满足如下条件时，你可以从下标 i 移动到下标 j 处： 
//
// 
// i + minJump <= j <= min(i + maxJump, s.length - 1) 且 
// s[j] == '0'. 
// 
//
// 如果你可以到达 s 的下标 s.length - 1 处，请你返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "011010", minJump = 2, maxJump = 3
//输出：true
//解释：
//第一步，从下标 0 移动到下标 3 。
//第二步，从下标 3 移动到下标 5 。
// 
//
// 示例 2： 
//
// 
//输入：s = "01101110", minJump = 2, maxJump = 3
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 105 
// s[i] 要么是 '0' ，要么是 '1' 
// s[0] == '0' 
// 1 <= minJump <= maxJump < s.length 
// 
// Related Topics 双指针 字符串 前缀和 
// 👍 40 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q1871_JumpGameVii {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canReach(String s, int minJump, int maxJump) {
            // 双指针 bfs算法优化
//            return doublePointWithBFS(s, minJump, maxJump);

            // 动态规划
            return dp(s, minJump, maxJump);
        }

        public boolean dp(String s, int minJump, int maxJump) {
            //长度
            int len = s.length();
            char[] chars = s.toCharArray();
            //记录某个点是否能达到 如果能到就是0 ,不能达到就是1
            int[] dp = new int[len + 1];
            //首先设置所有的点都不能达到
            Arrays.fill(dp, 1);
            //但是chars[0] = '0' 那么第一个点一定是能达到的 那么设置为 0
            dp[1] = 0;
            //这个是前缀和的数组，记录的是dp这个数组的前缀和
            int[] bdp = new int[len + 1];
            //第一个一定是0
            bdp[1] = 0;
            //遍历数组
            for (int i = 2; i < len + 1; i++) {
                //选择chars[i - 1]为 0  通过判断这个点的 i - maxJump 到 i - minJump 点的和 是否比 这两个点的距离之和近
                //如果近就说明这里面至少存在一个0 那么就可以通过这个0 来到达chars[i - 1]这个点
                if (chars[i - 1] == '0') {
                    if (i - minJump >= 1) {
                        int r = i - minJump;
                        int l = Math.max(i - maxJump, 1);
                        dp[i] = bdp[r] - bdp[l - 1] < r - l + 1 ? 0 : 1;
                    }
                }
                //每次都维护前缀和数组,加入 0 或者 1
                bdp[i] += bdp[i - 1] + dp[i];
            }
            return dp[len] == 0;
        }

        public boolean doublePointWithBFS(String s, int minJump, int maxJump) {
            if (s.charAt(s.length() - 1) != '0') {
                return false;
            }
            //存index
            Queue<Integer> que = new LinkedList<>();
            que.add(0);
            int last = 0; //尾指针
            int len = s.length();

            while (!que.isEmpty()) {
                int index = que.poll();
                for (int i = Math.max(last + 1, index + minJump); i <= Math.min(index + maxJump, len - 1); i++) {
                    last = i;//这一步很重要！！保证了O(n)的时间复杂度，且只遍历一遍
                    if (s.charAt(i) != '0') {
                        continue;
                    }
                    que.add(i);
                    if (i == len - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}