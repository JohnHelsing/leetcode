//给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal",
// "Silver Medal", "Bronze Medal"）。 
//
// (注：分数越高的选手，排名越靠前。) 
//
// 示例 1: 
//
// 
//输入: [5, 4, 3, 2, 1]
//输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
//解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and 
//"Bronze Medal").
//余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。 
//
// 提示: 
//
// 
// N 是一个正整数并且不会超过 10000。 
// 所有运动员的成绩都不相同。 
// 
// Related Topics 数组 排序 堆（优先队列） 
// 👍 93 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q0506_RelativeRanks {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findRelativeRanks(int[] score) {
            String[] result = new String[score.length];

            //定义堆比较器
            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer x, Integer y) {
                    return score[y] - score[x];
                }
            });

            for (int i = 0; i < score.length; i++) {
                queue.offer(i);
            }
            for (int i = 0; i < 3 && queue.size() > 0; i++) {
                if (i == 0) {
                    result[queue.poll()] = "Gold Medal";
                } else if (i == 1) {
                    result[queue.poll()] = "Silver Medal";
                } else if (i == 2) {
                    result[queue.poll()] = "Bronze Medal";
                }
            }

            for (int i = 3; i < score.length; i++) {
                result[queue.poll()] = String.valueOf(i + 1);
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}