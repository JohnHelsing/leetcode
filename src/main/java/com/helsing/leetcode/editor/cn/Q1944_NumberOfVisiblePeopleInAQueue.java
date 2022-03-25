//有 n 个人排成一个队列，从左到右 编号为 0 到 n - 1 。
// 给你以一个整数数组 heights ，每个整数 互不相同，heights[i] 表示第 i 个人的高度。
//
// 一个人能 看到 他右边另一个人的条件是这两人之间的所有人都比他们两人矮 。
// 更正式的，第 i 个人能看到第 j 个人的条件是 i < j
// 且 min(heights[i], heights[j]) > max(heights[i+1], heights[i+2], ..., heights[j-1]) 。
//
// 请你返回一个长度为 n 的数组 answer ，其中 answer[i] 是第 i 个人在他右侧队列中能 看到 的 人数 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：heights = [10,6,8,5,11,9]
//输出：[3,1,2,1,1,0]
//解释：
//第 0 个人能看到编号为 1 ，2 和 4 的人。
//第 1 个人能看到编号为 2 的人。
//第 2 个人能看到编号为 3 和 4 的人。
//第 3 个人能看到编号为 4 的人。
//第 4 个人能看到编号为 5 的人。
//第 5 个人谁也看不到因为他右边没人。
// 
//
// 示例 2： 
//
// 
//输入：heights = [5,1,2,3,10]
//输出：[4,1,1,1,0]
// 
//
// 
//
// 提示： 
//
// 
// n == heights.length 
// 1 <= n <= 10⁵ 
// 1 <= heights[i] <= 10⁵ 
// heights 中所有数 互不相同 。 
// 
// Related Topics 栈 数组 单调栈 👍 25 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Q1944_NumberOfVisiblePeopleInAQueue {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] canSeePersonsCount(int[] heights) {
            int n = heights.length;
            int[] ans = new int[n];
            // 单调递减栈，保存右边的可能看到的人的下标值
            Deque<Integer> monotoneStack = new ArrayDeque<>();
            // 倒序遍历 能看到多少只与右边的数值有关系
            for (int i = n - 1; i >= 0; i--) {
                while (!monotoneStack.isEmpty()) {
                    ans[i]++;
                    // 比单调栈中当前值小，证明看不到这个值右边的了，结束比较
                    if (heights[i] <= heights[monotoneStack.peek()]) {
                        break;
                    }
                    // 比单调栈中的当前值大，左边的人肯定都看不到这个值之后的人了
                    // 出栈，接着循环
                    monotoneStack.pop();
                }
                // 单调栈中放入下标，保证单调递减（栈为空或者h[i]<h[j]）
                monotoneStack.push(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
