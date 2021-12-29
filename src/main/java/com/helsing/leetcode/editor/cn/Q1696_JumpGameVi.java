//给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。 
//
// 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。
// 也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, i + k)] 包含 两个端点的任意位置。
//
// 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。 
//
// 请你返回你能得到的 最大得分 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-1,-2,4,-7,3], k = 2
//输出：7
//解释：你可以选择子序列 [1,-1,4,3] （上面加粗的数字），和为 7 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [10,-5,-2,4,0,3], k = 3
//输出：17
//解释：你可以选择子序列 [10,4,3] （上面加粗数字），和为 17 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length, k <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 队列 数组 动态规划 滑动窗口 单调队列 堆（优先队列） 👍 65 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q1696_JumpGameVi {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxResult(int[] nums, int k) {
            // 单调队列
            return queMonotone(nums, k);
            // 优先队列

        }

        public int queMonotone(int[] nums, int k) {
            int n = nums.length;
            int[] f = new int[n];
            for (int i = 0; i < n; ++i) {
                // 因为队列只保存下标，所以f[i]初始化为nums[i]的值，方便取元素计算
                f[i] = nums[i];
            }
            Deque<Integer> q = new ArrayDeque<>();
            q.addLast(0);
            for (int i = 1; i < n; ++i) {
                while (!q.isEmpty() && i - q.getFirst() > k) { // 取出队头合法元素
                    q.removeFirst();
                }
                f[i] = f[q.getFirst()] + nums[i]; // 计算答案
                while (!q.isEmpty() && f[i] > f[q.getLast()]) { // 找到插入位置
                    q.removeLast();
                }
                q.addLast(i); // 插入
            }
            return f[n - 1];
        }

        public int priorityQue(int[] nums, int k) {
            int n = nums.length;
            Queue<int[]> queue = new PriorityQueue<>(
                    (o1, o2) -> o2[0] - o1[0]);
            queue.offer(new int[]{nums[0], 0});
            int res = nums[0];
            for (int i = 1; i < n; i++) {
                while (i - queue.peek()[1] > k)
                    queue.poll();

                res = queue.peek()[0] + nums[i];
                queue.offer(new int[]{res, i});
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
