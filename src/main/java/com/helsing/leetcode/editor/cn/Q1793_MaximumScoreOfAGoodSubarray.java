//给你一个整数数组 nums （下标从 0 开始）和一个整数 k 。 
//
// 一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。一个
// 好 子数组的两个端点下标需要满足 i <= k <= j 。 
//
// 请你返回 好 子数组的最大可能 分数 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,4,3,7,4,5], k = 3
//输出：15
//解释：最优子数组的左右端点下标是 (1, 5) ，分数为 min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15 。
// 
//
// 示例 2： 
//
// 输入：nums = [5,5,4,5,4,1,1,1], k = 0
//输出：20
//解释：最优子数组的左右端点下标是 (0, 4) ，分数为 min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 2 * 104 
// 0 <= k < nums.length 
// 
// Related Topics 栈 数组 双指针 二分查找 单调栈 
// 👍 43 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class Q1793_MaximumScoreOfAGoodSubarray {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumScore(int[] nums, int k) {
            // 单调栈
            return stack(nums, k);

            // 双指针
//            return twoPointers(nums, k);
        }

        public int stack(int[] nums, int k) {
            int ans = 0;
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                    int h = nums[stack.pop()];
                    int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                    int right = i - 1;
                    int w = right - left + 1;
                    if (left <= k && k <= right) {
                        ans = Math.max(ans, w * h);
                    }
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                int h = nums[stack.pop()];
                int right = nums.length - 1;
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                int w = right - left + 1;
                if (left <= k && k <= right) {
                    ans = Math.max(ans, w * h);
                }
            }

            return ans;
        }

        public int twoPointers(int[] nums, int k) {
            int left = k, right = k, n = nums.length;
            int ans = nums[k], min = nums[k];
            while (left > 0 || right < n - 1) {
                if (left == 0) {
                    right++;
                    min = Math.min(min, nums[right]);
                } else if (right == n - 1) {
                    left--;
                    min = Math.min(min, nums[left]);
                } else {
                    if (nums[left - 1] > nums[right + 1]) {
                        left--;
                        min = Math.min(min, nums[left]);
                    } else {
                        right++;
                        min = Math.min(min, nums[right]);
                    }
                }
                ans = Math.max(ans, min * (right - left + 1));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}