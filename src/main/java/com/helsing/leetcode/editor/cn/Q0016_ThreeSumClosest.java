//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 排序 
// 👍 926 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Arrays;

public class Q0016_ThreeSumClosest {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            return array(nums, target);
        }

        public int array(int[] nums, int target) {
            Arrays.sort(nums);
            int n = nums.length;
            int best = 10000000;

            // 枚举 a
            for (int i = 0; i < n; ++i) {
                // 保证和上一次枚举的元素不相等
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 使用双指针枚举 b 和 c
                int left = i + 1, right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    // 如果和为 target 直接返回答案
                    if (sum == target) {
                        return target;
                    }
                    // 根据差值的绝对值来更新答案
                    if (Math.abs(sum - target) < Math.abs(best - target)) {
                        best = sum;
                    }
                    if (sum > target) {
                        // 如果和大于 target，移动 c 对应的指针
                        int rightNew = right - 1;
                        // 移动到下一个不相等的元素
                        while (left < rightNew && nums[rightNew] == nums[right]) {
                            rightNew--;
                        }
                        right = rightNew;
                    } else {
                        // 如果和小于 target，移动 b 对应的指针
                        int leftNew = left + 1;
                        // 移动到下一个不相等的元素
                        while (leftNew < right && nums[leftNew] == nums[left]) {
                            leftNew++;
                        }
                        left = leftNew;
                    }
                }
            }
            return best;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}