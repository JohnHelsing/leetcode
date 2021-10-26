//泰波那契序列 Tn 定义如下： 
//
// T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2 
//
// 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。 
//
// 
//
// 示例 1： 
//
// 输入：n = 4
//输出：4
//解释：
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4
// 
//
// 示例 2： 
//
// 输入：n = 25
//输出：1389537
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 37 
// 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。 
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 142 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Arrays;

public class Q1137_NThTribonacciNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.tribonacci(0);
        System.out.println(i);
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tribonacci(int n) {
            int[] CONST = {0, 1, 1, 2};
            if (n < 3) {
                return CONST[n];
            } else {
                int[] dp = Arrays.copyOf(CONST, n + 1);
                for (int i = 3; i < n + 1; i++) {
                    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
                }
                return dp[n];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}