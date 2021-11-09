//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b
//], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 双指针 排序 
// 👍 987 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0018_FourSum {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            // 特判
            if (nums == null || nums.length < 4) {
                return new ArrayList<>();
            }
            return twoPointersWithSort(nums, target);
        }

        public List<List<Integer>> twoPointersWithSort(int[] nums, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            // 排序
            Arrays.sort(nums);
            for (int i1 = 0; i1 < nums.length - 3; i1++) {
                if (i1 > 0 && nums[i1 - 1] == nums[i1]) {
                    continue;
                }
                long total = (long) nums[i1] + nums[i1 + 1] + nums[i1 + 2] + nums[i1 + 3];
                if (total > (long) target) {
                    break;
                }
                total = (long) nums[i1] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1];
                if (total < (long) target) {
                    continue;
                }
                for (int i2 = i1 + 1; i2 < nums.length - 2; i2++) {
                    if (i2 > i1 + 1 && nums[i2 - 1] == nums[i2]) {
                        continue;
                    }
                    int left = i2 + 1, right = nums.length - 1;
                    while (left < right) {
                        long sum = (long) nums[i1] + nums[i2] + nums[left] + nums[right];
                        if (sum == (long) target) {
                            ans.add(Arrays.asList(nums[i1], nums[i2], nums[left], nums[right]));
                            while (left < right && nums[left + 1] == nums[left]) {
                                left++;
                            }
                            while (left < right && nums[right - 1] == nums[right]) {
                                right--;
                            }
                            left++;
                            right--;
                        } else if (sum > (long) target) {
                            right--;
                        } else {
                            left++;
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}