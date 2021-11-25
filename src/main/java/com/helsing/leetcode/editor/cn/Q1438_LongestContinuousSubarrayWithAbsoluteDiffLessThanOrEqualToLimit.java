//给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，
//该子数组中的任意两个元素之间的绝对差必须小于或者等于limit 。
//
// 如果不存在满足条件的子数组，则返回 0 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [8,2,4,7], limit = 4
//输出：2 
//解释：所有子数组如下：
//[8] 最大绝对差 |8-8| = 0 <= 4.
//[8,2] 最大绝对差 |8-2| = 6 > 4. 
//[8,2,4] 最大绝对差 |8-2| = 6 > 4.
//[8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
//[2] 最大绝对差 |2-2| = 0 <= 4.
//[2,4] 最大绝对差 |2-4| = 2 <= 4.
//[2,4,7] 最大绝对差 |2-7| = 5 > 4.
//[4] 最大绝对差 |4-4| = 0 <= 4.
//[4,7] 最大绝对差 |4-7| = 3 <= 4.
//[7] 最大绝对差 |7-7| = 0 <= 4. 
//因此，满足题意的最长子数组的长度为 2 。
// 
//
// 示例 2： 
//
// 输入：nums = [10,1,2,4,7,2], limit = 5
//输出：4 
//解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
// 
//
// 示例 3： 
//
// 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^9 
// 0 <= limit <= 10^9 
// 
// Related Topics 队列 数组 有序集合 滑动窗口 单调队列 堆（优先队列） 👍 215 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class Q1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            // 滑动窗口 + 单调队列
            return queueMonotoneWithSlideWindow(nums, limit);
        }


        public int queueMonotoneWithSlideWindow(int[] nums, int limit) {
            // 统计当前窗口的最大值最小值队列
            Deque<Integer> queMax = new LinkedList<>();
            Deque<Integer> queMin = new LinkedList<>();
            int n = nums.length;
            int left = 0, right = 0;
            int ret = 0;
            while (right < n) {
                while (!queMax.isEmpty() && queMax.peekLast() < nums[right]) {
                    queMax.pollLast();
                }
                while (!queMin.isEmpty() && queMin.peekLast() > nums[right]) {
                    queMin.pollLast();
                }
                queMax.offerLast(nums[right]);
                queMin.offerLast(nums[right]);
                while (!queMax.isEmpty() && !queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit) {
                    if (nums[left] == queMin.peekFirst()) {
                        queMin.pollFirst();
                    }
                    if (nums[left] == queMax.peekFirst()) {
                        queMax.pollFirst();
                    }
                    left++;
                }
                ret = Math.max(ret, right - left + 1);
                right++;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
