//给定一个正整数 N，试求有多少组连续正整数满足所有数字之和为 N? 
//
// 示例 1: 
//
// 
//输入: 5
//输出: 2
//解释: 5 = 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。 
//
// 示例 2: 
//
// 
//输入: 9
//输出: 3
//解释: 9 = 9 = 4 + 5 = 2 + 3 + 4 
//
// 示例 3: 
//
// 
//输入: 15
//输出: 4
//解释: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5 
//
// 说明: 1 <= N <= 10 ^ 9 
// Related Topics 数学 枚举 
// 👍 120 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0829_ConsecutiveNumbersSum {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int consecutiveNumbersSum(int n) {
            int res = 1;
            for (int i = 2; i < Math.sqrt(2 * n); ++i) {
                if ((n - i * (i - 1) / 2) % i == 0) {
                    res++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}