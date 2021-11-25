//给你一个整数数组 nums 和一个整数 k ，请你返回 非空 子序列元素和的最大值，
// 子序列需要满足：子序列中每两个 相邻 的整数 nums[i] 和
//nums[j] ，它们在原数组中的下标 i 和 j 满足 i < j 且 j - i <= k 。 
//
// 数组的子序列定义为：将数组中的若干个数字删除（可以删除 0 个数字），剩下的数字按照原本的顺序排布。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [10,2,-10,5,20], k = 2
//输出：37
//解释：子序列为 [10, 2, 5, 20] 。
// 
//
// 示例 2： 
//
// 输入：nums = [-1,-2,-3], k = 1
//输出：-1
//解释：子序列必须是非空的，所以我们选择最大的数字。
// 
//
// 示例 3： 
//
// 输入：nums = [10,-2,-10,-5,20], k = 2
//输出：23
//解释：子序列为 [10, -2, -5, 20] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 
// Related Topics 队列 数组 动态规划 滑动窗口 单调队列 堆（优先队列） 👍 83 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q1425_ConstrainedSubsequenceSum {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int constrainedSubsetSum(int[] nums, int k) {
            // 单调队列
            return queueMonotone(nums, k);
        }


        public int queueMonotone(int[] nums, int k) {
            int n = nums.length;
            int[] f = new int[n];
            f[0] = nums[0];
            Deque<Integer> q = new ArrayDeque<Integer>();
            q.addLast(0);
            int ans = nums[0];
            for (int i = 1; i < n; ++i) {
                // 如果队首的 j 与 i 的差值大于 k，则不满足要求，弹出
                while (!q.isEmpty() && i - q.peekFirst() > k) {
                    q.removeFirst();
                }
                // 此时队首的 j 即为最优的 j 值
                f[i] = Math.max(f[q.peekFirst()], 0) + nums[i];
                ans = Math.max(ans, f[i]);
                // 维护队列的单调性，不断从队尾弹出元素
                while (!q.isEmpty() && f[i] >= f[q.peekLast()]) {
                    q.removeLast();
                }
                // 将 i 作为之后的新 j 值放入队尾
                q.addLast(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
