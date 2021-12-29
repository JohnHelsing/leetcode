//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧
// 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 
// 👍 1248 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class Q0239_SlidingWindowMaximum {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            // 优先队列
//            return queue(nums, k);

            // 单调队列
            return queMonotone(nums, k);
        }


        public int[] queMonotone(int[] nums, int k) {
            int n = nums.length;
            if (n < 1) {
                return nums;
            }
            Deque<Integer> q = new ArrayDeque<>();
            int[] ans = new int[n - k + 1];
            for (int i = 0; i < k; ++i) {
                while (!q.isEmpty() && nums[i] > nums[q.getLast()]) {
                    q.removeLast();
                }
                q.addLast(i);
            }
            ans[0] = nums[q.getFirst()];
            for (int i = k; i < n; ++i) {
                while (!q.isEmpty() && nums[i] > nums[q.getLast()]) {
                    q.removeLast();
                }
                q.addLast(i);
                while (q.getFirst() <= i - k) {
                    q.removeFirst();
                }
                ans[i - k + 1] = nums[q.getFirst()];
            }
            return ans;

        }

        public int[] queue(int[] nums, int k) {
            int n = nums.length;
            // 1. 优先队列存放的是二元组(num,index) :
            // 大顶堆（元素大小不同按元素大小排列，元素大小相同按下标进行排列）
            // num :   是为了比较元素大小
            // index : 是为了判断窗口的大小是否超出范围
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
                public int compare(int[] pair1, int[] pair2) {
                    return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
                }
            });

            // 2. 优选队列初始化 : k个元素的堆
            for (int i = 0; i < k; i++) {
                pq.offer(new int[]{nums[i], i});
            }

            // 3. 处理堆逻辑
            int[] res = new int[n - k + 1];         // 初始化结果数组长度 ：一共有 n - k + 1个窗口
            res[0] = pq.peek()[0];                  // 初始化res[0] ： 拿出目前堆顶的元素
            for (int i = k; i < n; i++) {               // 向右移动滑动窗口
                pq.offer(new int[]{nums[i], i});     // 加入大顶堆中
                while (pq.peek()[1] <= i - k) {       // 将下标不在滑动窗口中的元素都干掉
                    pq.poll();                      // 维护：堆的大小就是滑动窗口的大小
                }
                res[i - k + 1] = pq.peek()[0];      // 此时堆顶元素就是滑动窗口的最大值
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}