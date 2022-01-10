//超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。 
//
// 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。 
//
// 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12, primes = [2,7,13,19]
//输出：32 
//解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,
//28,32] 。 
//
// 示例 2： 
//
// 
//输入：n = 1, primes = [2,3,5]
//输出：1
//解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
// 
// 
//
// 
// 
// 
// 提示： 
//
// 
// 1 <= n <= 10⁶ 
// 1 <= primes.length <= 100 
// 2 <= primes[i] <= 1000 
// 题目数据 保证 primes[i] 是一个质数 
// primes 中的所有值都 互不相同 ，且按 递增顺序 排列 
// 
// 
// 
// 
// Related Topics 数组 哈希表 数学 动态规划 堆（优先队列） 👍 291 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Q0313_SuperUglyNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            // 动态规划
//            return dp(n, primes);

            // 优先队列
            return priorityQue(n, primes);
        }

        public int priorityQue(int n, int[] primes) {
            int m = primes.length;
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            for (int i = 0; i < m; i++) {
                q.add(new int[]{primes[i], i, 0});
            }
            int[] ans = new int[n];
            ans[0] = 1;
            for (int j = 1; j < n; ) {
                int[] poll = q.poll();
                int val = poll[0], i = poll[1], idx = poll[2];
                if (val != ans[j - 1]) {
                    ans[j++] = val;
                }
                q.add(new int[]{ans[idx + 1] * primes[i], i, idx + 1});
            }
            return ans[n - 1];
        }

        public int dp(int n, int[] primes) {
            int[] dp = new int[n + 1];
            int m = primes.length;
            int[] pointers = new int[m];
            int[] nums = new int[m];
            Arrays.fill(nums, 1);
            for (int i = 1; i <= n; i++) {
                int minNum = Arrays.stream(nums).min().getAsInt();
                dp[i] = minNum;
                for (int j = 0; j < m; j++) {
                    if (nums[j] == minNum) {
                        pointers[j]++;
                        nums[j] = dp[pointers[j]] * primes[j];
                    }
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
