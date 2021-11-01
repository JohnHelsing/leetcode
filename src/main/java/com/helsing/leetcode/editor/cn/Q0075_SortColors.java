//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
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
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 数组 双指针 排序 
// 👍 1055 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0075_SortColors {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            // 使用快速排序
            quickSort(nums, 0, nums.length - 1);
        }

        public void quickSort(int[] nums, int start, int end) {
            // 递归结束条件
            if (start >= end) {
                return;
            }
            // 获取pivot
            // 双边循环
//            int pivot = getPivotDoublePoint(nums, start, end);
            // 单边循环
            int pivot = getPivotSinglePoint(nums, start, end);

            // 分治递归
            quickSort(nums, start, pivot - 1);
            quickSort(nums, pivot + 1, end);
        }

        public int getPivotDoublePoint(int[] nums, int start, int end) {
            // 选取第一个
            int pivot = nums[start];
            int left = start, right = end;

            // 双指针
            while (left < right) {
                while (left < right && nums[right] > pivot) {
                    right--;
                }
                while (left < right && nums[left] <= pivot) {
                    left++;
                }
                if (left < right) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
            }

            // pivot交换
            nums[start] = nums[left];
            nums[left] = pivot;
            return left;
        }


        public int getPivotSinglePoint(int[] nums, int start, int end) {
            // 选取第一个
            int pivot = nums[start];
            int mark = start;

            // 单边循环
            for (int i = start + 1; i <= end; i++) {
                if (nums[i] < pivot) {
                    mark++;
                    int p = nums[mark];
                    nums[mark] = nums[i];
                    nums[i] = p;
                }
            }
            nums[start] = nums[mark];
            nums[mark] = pivot;
            return mark;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}