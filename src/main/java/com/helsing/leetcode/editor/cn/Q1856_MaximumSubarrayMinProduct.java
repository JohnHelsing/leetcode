//一个数组的 最小乘积 定义为这个数组中 最小值 乘以 数组的 和 。 
//
// 
// 比方说，数组 [3,2,5] （最小值是 2）的最小乘积为 2 * (3+2+5) = 2 * 10 = 20 。 
// 
//
// 给你一个正整数数组 nums ，请你返回 nums 任意 非空子数组 的最小乘积 的 最大值 。由于答案可能很大，请你返回答案对 10⁹ + 7 取余 的
//结果。 
//
// 请注意，最小乘积的最大值考虑的是取余操作 之前 的结果。题目保证最小乘积的最大值在 不取余 的情况下可以用 64 位有符号整数 保存。 
//
// 子数组 定义为一个数组的 连续 部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,2]
//输出：14
//解释：最小乘积的最大值由子数组 [2,3,2] （最小值是 2）得到。
//2 * (2+3+2) = 2 * 7 = 14 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,3,3,1,2]
//输出：18
//解释：最小乘积的最大值由子数组 [3,3] （最小值是 3）得到。
//3 * (3+3) = 3 * 6 = 18 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,1,5,6,4,2]
//输出：60
//解释：最小乘积的最大值由子数组 [5,6,4] （最小值是 4）得到。
//4 * (5+6+4) = 4 * 15 = 60 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁷ 
// 
// Related Topics 栈 数组 前缀和 单调栈 👍 59 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class Q1856_MaximumSubarrayMinProduct {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumMinProduct(int[] nums) {
            //单调栈
            return stackMonotone(nums);
        }

        public int stackMonotone(int[] nums) {
            int len = nums.length;
            int[] left = new int[len];
            int[] right = new int[len];
            Deque<Integer> stack = new LinkedList<>();
            // 对于每一个i 找到右侧连续的不小于它的元素，记录最后一个连续的，不小于它的元素对应下标
            for (int i = 0; i < len; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                    right[stack.pop()] = i - 1;
                }
                stack.push(i);//存放的是下标
            }
            while (!stack.isEmpty()) {
                right[stack.pop()] = len - 1;
            }

            // 对于每一个i 找到左侧连续的不小于它的元素，记录最后一个连续的，不小于它的元素对应下标
            for (int i = len - 1; i >= 0; i--) {
                while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                    left[stack.pop()] = i + 1;
                }
                stack.push(i);//存放的是下标
            }
            while (!stack.isEmpty()) {
                left[stack.pop()] = 0;
            }

            //前缀和,用long来存放，防止相加时溢出
            long[] dp = new long[len];
            dp[0] = nums[0];
            for (int i = 1; i < len; i++) {
                dp[i] = dp[i - 1] + nums[i];
            }

            long result = 0;
            for (int i = 0; i < len; i++) {
                result = Math.max(result, nums[i] * (dp[right[i]] - dp[left[i]] + nums[left[i]]));
            }//right[i]为右坐标 left[i]为左坐标，从left[i]到right[i]所有元素的和应该是dp[right[i]]-dp[left[i]]+nums[left[i]]
            return (int) (result % 1000000007);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
