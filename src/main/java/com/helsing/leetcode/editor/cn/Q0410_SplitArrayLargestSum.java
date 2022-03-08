//给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。 
//
// 设计一个算法使得这 m 个子数组各自和的最大值最小。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [7,2,5,10,8], m = 2
//输出：18
//解释：
//一共有四种方法将 nums 分割为 2 个子数组。 
//其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4,5], m = 2
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,4,4], m = 3
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 10⁶ 
// 1 <= m <= min(50, nums.length) 
// 
// Related Topics 贪心 数组 二分查找 动态规划 👍 634 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Arrays;

public class Q0410_SplitArrayLargestSum {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int splitArray(int[] nums, int m) {
            // 动态规划
//            return dp(nums, m);
            // 二分查找
            return binaryFind(nums, m);
        }

        private int binaryFind(int[] nums, int m) {
            int left = 0, right = 0;
            for (int num : nums) {
                right += num;
                if (left < num) {
                    left = num;
                }
            }
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (check(nums, mid, m)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        public boolean check(int[] nums, int x, int m) {
            int sum = 0;
            int cnt = 1;
            for (int num : nums) {
                if (sum + num > x) {
                    cnt++;
                    sum = num;
                } else {
                    sum += num;
                }
            }
            return cnt <= m;
        }

        private int dp(int[] nums, int m) {
            int n = nums.length;
            int[][] f = new int[n + 1][m + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(f[i], Integer.MAX_VALUE);
            }
            int[] sub = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sub[i + 1] = sub[i] + nums[i];
            }
            f[0][0] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= Math.min(i, m); j++) {
                    for (int k = 0; k < i; k++) {
                        f[i][j] = Math.min(f[i][j],
                                Math.max(f[k][j - 1], sub[i] - sub[k]));
                    }
                }
            }
            return f[n][m];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
