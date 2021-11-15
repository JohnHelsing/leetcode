//返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。 
//
// 如果没有和至少为 K 的非空子数组，返回 -1 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = [1], K = 1
//输出：1
// 
//
// 示例 2： 
//
// 输入：A = [1,2], K = 4
//输出：-1
// 
//
// 示例 3： 
//
// 输入：A = [2,-1,2], K = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 50000 
// -10 ^ 5 <= A[i] <= 10 ^ 5 
// 1 <= K <= 10 ^ 9 
// 
// Related Topics 队列 数组 二分查找 前缀和 滑动窗口 单调队列 堆（优先队列） 
// 👍 322 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0862_ShortestSubarrayWithSumAtLeastK {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            // 滑动窗口
            return slideWindow(nums, k);
        }

        public int slideWindow(int[] nums, int k) {
            long[] arr = new long[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                arr[i + 1] = arr[i] + nums[i];
                if (nums[i] >= k) {
                    return 1;
                }
            }
            //得到前缀和数组
            int res = Integer.MAX_VALUE;
            Deque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < arr.length; i++) {
                while (!queue.isEmpty() && arr[i] <= arr[queue.getLast()]) {
                    queue.removeLast();
                }
                while (!queue.isEmpty() && arr[i] - arr[queue.peek()] >= k) {
                    res = Math.min(res, i - queue.poll());
                }
                queue.add(i);
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}