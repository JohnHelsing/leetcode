//给你一个数组 points 和一个整数 k 。数组中每个元素都表示二维平面上的点的坐标，
// 并按照横坐标 x 的值从小到大排序。也就是说 points[i] =
// [xi, yi] ，并且在 1 <= i < j <= points.length 的前提下， xi < xj 总成立。 
//
// 请你找出 yi + yj + |xi - xj| 的 最大值，其中 |xi - xj| <= k 且 1 <= i < j <= points.
//length。 
//
// 题目测试数据保证至少存在一对能够满足 |xi - xj| <= k 的点。 
//
// 
//
// 示例 1： 
//
// 输入：points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
//输出：4
//解释：前两个点满足 |xi - xj| <= 1 ，代入方程计算，则得到值 3 + 0 + |1 - 2| = 4 。
// 第三个和第四个点也满足条件，得到值 1
//0 + -10 + |5 - 6| = 1 。
//没有其他满足条件的点，所以返回 4 和 1 中最大的那个。 
//
// 示例 2： 
//
// 输入：points = [[0,0],[3,0],[9,2]], k = 3
//输出：3
//解释：只有前两个点满足 |xi - xj| <= 3 ，代入方程后得到值 0 + 0 + |0 - 3| = 3 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= points.length <= 10^5 
// points[i].length == 2 
// -10^8 <= points[i][0], points[i][1] <= 10^8 
// 0 <= k <= 2 * 10^8 
// 对于所有的1 <= i < j <= points.length ，points[i][0] < points[j][0] 都成立。也就是说，xi 是严格
//递增的。 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 49 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class Q1499_MaxValueOfEquation {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxValueOfEquation(int[][] points, int k) {
            // TODO 求一个区间的最大值，最直接的想法是使用线段树（虽然编码最麻烦）

            // 单调队列
            return queMonotone(points, k);
        }

        public int queMonotone(int[][] points, int k) {
            Deque<int[][]> deque = new LinkedList<>();
            // 初始放入第一个点的信息
            // 放入 {y-x,x}
            deque.offer(new int[][]{{points[0][1] - points[0][0], points[0][0]}});
            int ans = Integer.MIN_VALUE;
            for (int i = 1; i < points.length; i++) {
                // 对队列首不符合约束的点删除
                while (!deque.isEmpty() && points[i][0] - deque.peek()[0][1] > k) {
                    deque.pollFirst();
                }
                // 根据队首最大元素信息更新解
                if (!deque.isEmpty()) {
                    ans = Math.max(ans, points[i][1] + points[i][0] + deque.peekFirst()[0][0]);
                }
                // 把队列尾的比当前 y - x 还小的元素删除
                while (!deque.isEmpty() && deque.peekLast()[0][0] <= points[i][1] - points[i][0]) {
                    deque.pollLast();
                }
                // 将当前点的信息加入队列
                deque.offerLast(new int[][]{{points[i][1] - points[i][0], points[i][0]}});
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
