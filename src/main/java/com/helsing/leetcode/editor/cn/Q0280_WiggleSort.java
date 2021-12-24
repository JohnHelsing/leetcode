//给你一个无序的数组 nums, 将该数字 原地 重排后
// 使得 nums[0] <= nums[1] >= nums[2] <= nums[3]...。
//
// 示例: 
//
// 输入: nums = [3,5,2,1,6,4]
//输出: 一个可能的解答是 [3,5,1,6,2,4] 
// Related Topics 贪心 数组 排序 👍 82 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0280_WiggleSort {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void wiggleSort(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++) {
                if ((i % 2 == 0) == (nums[i] > nums[i + 1])) {
                    swap(nums, i, i + 1);
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
