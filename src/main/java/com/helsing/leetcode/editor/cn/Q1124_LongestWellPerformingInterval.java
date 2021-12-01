//给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。 
//
// 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。 
//
// 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。 
//
// 请你返回「表现良好时间段」的最大长度。 
//
// 
//
// 示例 1： 
//
// 输入：hours = [9,9,6,0,6,6,9]
//输出：3
//解释：最长的表现良好时间段是 [9,9,6]。 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 10000 
// 0 <= hours[i] <= 16 
// 
// Related Topics 栈 数组 哈希表 前缀和 单调栈 👍 158 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q1124_LongestWellPerformingInterval {

    public static void main(String[] args) {
        Solution solÏution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestWPI(int[] hours) {
            // 单调栈
            return stackMonotone(hours);
        }

        public int stackMonotone(int[] hours) {
            for (int i = 0; i < hours.length; i++) {
                hours[i] = hours[i] > 8 ? 1 : -1;
            }

            // 前缀和
            int[] score = new int[hours.length + 1];
            score[0] = 0;
            for (int i = 1; i < score.length; i++) {
                score[i] = score[i - 1] + hours[i - 1];
            }
            // 递减栈
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < score.length; i++) {
                if (stack.isEmpty() || score[stack.peek()] > score[i]) {
                    stack.push(i);
                }
            }
            int ans = 0;
            for (int i = score.length - 1; i >= 0; i--) {
                if (!stack.isEmpty() && score[i] > score[stack.peek()]) {
                    ans = Math.max(ans, i - stack.peek());
                    stack.pop();
                    i++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
