//给你一个长度为 n 的整数数组 nums ，你需要处理 n 个查询。 
//
// 对于第 i （0 <= i < n）个查询： 
//
// 
// 你需要先找出 nums 的所有长度为 i + 1 的子数组中的 最小值 。 
// 在这些最小值中找出 最大值 作为答案。 
// 
//
// 返回一个 下标从 0 开始 的长度为 n 的整数数组 ans ，ans[i] 代表第 i 个查询的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入: nums = [0,1,2,4]
//输出: [4,2,1,0]
//解释:
//i = 0:
//- 大小为 1 的子数组为 [0], [1], [2], [4]
//- 有最大的最小值的子数组是 [4], 它的最小值是 4
//i = 1:
//- 大小为 2 的子数组为 [0,1], [1,2], [2,4]
//- 有最大的最小值的子数组是 [2,4], 它的最小值是 2
//i = 2:
//- 大小为 3 的子数组为 [0,1,2], [1,2,4]
//- 有最大的最小值的子数组是 [1,2,4], 它的最小值是 1
//i = 3:
//- 大小为 4 的子数组为 [0,1,2,4]
//- 有最大的最小值的子数组是 [0,1,2,4], 它的最小值是 0 
//
// 示例 2： 
//
// 
//输入: nums = [10,20,50,10]
//输出: [50,20,10,10]
//解释:
//i = 0: 
//- 大小为 1 的子数组为 [10], [20], [50], [10]
//- 有最大的最小值的子数组是 [50], 它的最小值是 50
//i = 1: 
//- 大小为 2 的子数组为 [10,20], [20,50], [50,10]
//- 有最大的最小值的子数组是 [20,50], 它的最小值是 20
//i = 2: 
//- 大小为 3 的子数组为 [10,20,50], [20,50,10]
//- 有最大的最小值的子数组是 [10,20,50], 它的最小值是 10
//i = 3: 
//- 大小为 4 的子数组为 [10,20,50,10]
//- 有最大的最小值的子数组是 [10,20,50,10], 它的最小值是 10 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 
// Related Topics 栈 数组 单调栈 👍 8 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Q1950_MaximumOfMinimumValuesInAllSubarrays {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findMaximums(int[] nums) {
            // 单调栈
            return stackMonotone(nums);
        }

        public int[] stackMonotone(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            Deque<Integer> stack = new ArrayDeque<>();
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                    int tmp = stack.pop();
                    int left = stack.isEmpty() ? 0 : (stack.peek() + 1);
                    int right = i - 1;
                    pq.offer(new int[]{right - left + 1, nums[tmp]});
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                int tmp = stack.pop();
                int left = stack.isEmpty() ? 0 : (stack.peek() + 1);
                int right = n - 1;
                pq.offer(new int[]{right - left + 1, nums[tmp]});
            }
            int max = 0;
            for (int i = n - 1; i >= 0; i--) {
                while (!pq.isEmpty() && pq.peek()[0] >= i + 1) {
                    max = Math.max(pq.poll()[1], max);
                }
                ans[i] = max;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
