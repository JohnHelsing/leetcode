//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 3916 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0015_ThreeSum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] zero = {0, 0, 0, 0};
        solution.threeSum(zero);
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            return array(nums);
        }

        public List<List<Integer>> array(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums == null || nums.length < 3) {
                return ans;
            }

            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
                if (nums[i] > 0) {
                    // 第一个数大于 0，后面的数都比它大，肯定不成立了
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    // 去掉重复情况
                    continue;
                }
                int target = -nums[i];
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                        // 现在要增加 left，减小 right
                        // 但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                        left++;
                        right--; // 首先无论如何先要进行加减操作
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}