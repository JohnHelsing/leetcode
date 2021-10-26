//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 1958 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0070_ClimbingStairs {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(4));
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            if (n < 3) {
                return n;
            }
            // 普通动态规划
//            return dp(n);

            // 滚动数组
            return rollArray(n);
        }

        public int dp(int n) {
            int[] dp = new int[n];
            dp[0] = 1;
            dp[1] = 2;
            dp[2] = 3;
            for (int i = 3; i < n; i++) {
                dp[i] = dp[i - 2] + dp[i - 1];
            }
            return dp[n - 1];
        }

        public int rollArray(int n) {
            int p = 0, q = 0, r = 1;
            for (int i = 1; i <= n; ++i) {
                p = q;
                q = r;
                r = p + q;
            }
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}