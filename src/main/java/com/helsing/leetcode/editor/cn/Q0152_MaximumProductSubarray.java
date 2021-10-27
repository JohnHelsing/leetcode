//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 1336 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0152_MaximumProductSubarray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] caseTest = {-3, 2, 0, -1};
        System.out.println(solution.maxProduct(caseTest));
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            // 性能优化
            if (nums.length < 1) {
                return 0;
            } else if (nums.length == 1) {
                return nums[0];
            }

            // 暴力模拟
//            return sim(nums);

            // 动态规划
            return dp(nums);
        }

        public int sim(int[] nums) {
            int max = nums[0];
            for (int i = 0; i < nums.length; i++) {
                int mul = nums[i];
                max = Math.max(max, mul);
                for (int j = i + 1; j < nums.length; j++) {
                    mul *= nums[j];
                    max = Math.max(max, mul);
                }
            }
            return max;
        }

        public int dp(int[] nums) {
            int maxF = nums[0], minF = nums[0], res = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int mx = maxF, mn = minF;
                maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
                minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
                res = Math.max(maxF, res);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}