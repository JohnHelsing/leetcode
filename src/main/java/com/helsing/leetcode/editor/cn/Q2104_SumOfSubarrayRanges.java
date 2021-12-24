//给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。 
//
// 返回 nums 中 所有 子数组范围的 和 。 
//
// 子数组是数组中一个连续 非空 的元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：4
//解释：nums 的 6 个子数组如下所示：
//[1]，范围 = 最大 - 最小 = 1 - 1 = 0 
//[2]，范围 = 2 - 2 = 0
//[3]，范围 = 3 - 3 = 0
//[1,2]，范围 = 2 - 1 = 1
//[2,3]，范围 = 3 - 2 = 1
//[1,2,3]，范围 = 3 - 1 = 2
//所有范围的和是 0 + 0 + 0 + 1 + 1 + 2 = 4 
//
// 示例 2： 
//
// 
//输入：nums = [1,3,3]
//输出：4
//解释：nums 的 6 个子数组如下所示：
//[1]，范围 = 最大 - 最小 = 1 - 1 = 0
//[3]，范围 = 3 - 3 = 0
//[3]，范围 = 3 - 3 = 0
//[1,3]，范围 = 3 - 1 = 2
//[3,3]，范围 = 3 - 3 = 0
//[1,3,3]，范围 = 3 - 1 = 2
//所有范围的和是 0 + 0 + 0 + 2 + 0 + 2 = 4
// 
//
// 示例 3： 
//
// 
//输入：nums = [4,-2,-3,4,1]
//输出：59
//解释：nums 中所有子数组范围的和是 59
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：你可以设计一种时间复杂度为 O(n) 的解决方案吗？ 
// Related Topics 栈 数组 单调栈 👍 11 👎 0

package com.helsing.leetcode.editor.cn;

public class Q2104_SumOfSubarrayRanges {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long subArrayRanges(int[] nums) {
            // 单调栈
            return stackMonotone(nums);
        }


        public long stackMonotone(int[] nums) {
            int n = nums.length;
            int left = 0, right = 0;
            long ans = 0;
            for (int i = 0; i < n; i++) {
                left = right = i;
                // 找到左右以 nums[i] 为最大值的最远左右点
                while (left - 1 >= 0 && nums[left - 1] < nums[i]) {
                    left--;
                }
                while (right + 1 < n && nums[right + 1] <= nums[i]) {
                    right++;
                }
                ans += (right - i + 1) * (i - left + 1) * (long) nums[i];

                left = right = i;
                // 找到左右以 nums[i] 为最小值的最远左右点
                while (left - 1 >= 0 && nums[left - 1] > nums[i]) {
                    left--;
                }
                while (right + 1 < n && nums[right + 1] >= nums[i]) {
                    right++;
                }
                ans -= (right - i + 1) * (i - left + 1) * (long) nums[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
