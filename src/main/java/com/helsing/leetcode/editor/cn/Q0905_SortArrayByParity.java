//给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。 
//
// 你可以返回满足此条件的任何数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[3,1,2,4]
//输出：[2,4,3,1]
//输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
// 
//
// 
//
// 提示： 
//
//
// 1 <= A.length <= 5000 
// 0 <= A[i] <= 5000 
// 
// Related Topics 数组 双指针 排序 
// 👍 220 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0905_SortArrayByParity {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParity(int[] nums) {
            // 双指针
            return doublePoint(nums);

        }

        public int[] doublePoint(int[] nums) {
            int[] ans = new int[nums.length];
            int left = 0, right = nums.length - 1;
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & 1) == 0) {
                    ans[left++] = nums[i];
                } else {
                    ans[right--] = nums[i];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}