//给定一个长度为 n 的整数数组和一个目标值 target，寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的三
//元组 i, j, k 个数（0 <= i < j < k < n）。 
//
// 示例： 
//
// 输入: nums = [-2,0,1,3], target = 2
//输出: 2 
//解释: 因为一共有两个三元组满足累加和小于 2:
//     [-2,0,1]
//     [-2,0,3]
// 
//
// 进阶：是否能在 O(n2) 的时间复杂度内解决？ 
// Related Topics 数组 双指针 二分查找 排序 
// 👍 93 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Arrays;

public class Q0259_ThreeSumSmaller {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                sum += twoSumSmaller(nums, i + 1, target - nums[i]);
            }
            return sum;
        }

        private int twoSumSmaller(int[] nums, int startIndex, int target) {
            int sum = 0;
            int left = startIndex;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    sum += right - left;
                    left++;
                } else {
                    right--;
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}