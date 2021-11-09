//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
// Related Topics 数组 双指针 排序 
// 👍 333 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0977_SquaresOfASortedArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {-4, -1, 0, 4, 10};
        solution.sortedSquares(test);
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            // 双指针
            return twoPointers(nums);
        }

        public int[] twoPointers(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            int left = 0, right = n - 1, cur = n - 1;
            while (left <= right) {
                int leftNum = nums[left] * nums[left];
                int rightNum = nums[right] * nums[right];
                if (leftNum > rightNum) {
                    ans[cur] = leftNum;
                    left++;
                } else {
                    ans[cur] = rightNum;
                    right--;
                }
                cur--;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}