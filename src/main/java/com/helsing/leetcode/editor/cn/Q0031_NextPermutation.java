//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 
// 👍 1388 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0031_NextPermutation {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            //从后向前，找到第一个由大变小的
            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {
                    //从后向前，找到第一个比nums[i - 1]大的数，两个进行交换
                    for (int j = nums.length - 1; j >= i; j--) {
                        if (nums[j] > nums[i - 1]) {
                            int tmp = nums[j];
                            nums[j] = nums[i - 1];
                            nums[i - 1] = tmp;
                            //快速排序，这里也可以调用Arrays.sort()
                            quickSort(nums, i, nums.length - 1);
                            return;
                        }
                    }
                }
            }
            //如果不存在，就是最大数，重新排列一下
            quickSort(nums, 0, nums.length - 1);
            return;

        }

        //快速排序，这里也可以调用Arrays.sort()
        public void quickSort(int[] nums, int left, int right) {
            if (left >= right) return;
            int l = left, r = right;
            int tmp = nums[l];
            while (l < r) {
                while (l < r && nums[r] >= tmp) r--;
                while (l < r && nums[l] <= tmp) l++;
                if (l < r) {
                    int x = nums[l];
                    nums[l] = nums[r];
                    nums[r] = x;
                }
            }
            nums[left] = nums[l];
            nums[l] = tmp;
            quickSort(nums, left, l - 1);
            quickSort(nums, l + 1, right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}