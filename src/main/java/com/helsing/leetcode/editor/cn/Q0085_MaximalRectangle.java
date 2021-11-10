//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 动态规划 矩阵 单调栈 
// 👍 1080 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0085_MaximalRectangle {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = {{1}};
        solution.maximalRectangle(matrix);
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            // 单调栈
            return stackWithMonotone(matrix);
        }

        public int stackWithMonotone(char[][] matrix) {
            int m = matrix.length;
            if (m == 0) {
                return 0;
            }
            int n = matrix[0].length;
            int[][] left = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                    }
                }
            }

            int ret = 0;
            for (int j = 0; j < n; j++) { // 对于每一列，使用基于柱状图的方法
                int[] up = new int[m];
                int[] down = new int[m];

                Deque<Integer> stack = new ArrayDeque<>();
                for (int i = 0; i < m; i++) {
                    while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                        stack.pop();
                    }
                    up[i] = stack.isEmpty() ? -1 : stack.peek();
                    stack.push(i);
                }
                stack.clear();
                for (int i = m - 1; i >= 0; i--) {
                    while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                        stack.pop();
                    }
                    down[i] = stack.isEmpty() ? m : stack.peek();
                    stack.push(i);
                }

                for (int i = 0; i < m; i++) {
                    int height = down[i] - up[i] - 1;
                    int area = height * left[i][j];
                    ret = Math.max(ret, area);
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}