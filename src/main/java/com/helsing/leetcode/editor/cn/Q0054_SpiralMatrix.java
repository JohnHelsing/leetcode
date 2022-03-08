//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 👍 1005 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q0054_SpiralMatrix {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            int m = matrix.length, n = matrix[0].length;
            int upperBound = 0, lowerBound = m - 1;
            int leftBound = 0, rightBound = n - 1;
            while (ans.size() < m * n) {
                if (upperBound <= lowerBound) {
                    // 在顶部从左向右遍历
                    for (int j = leftBound; j <= rightBound; j++) {
                        ans.add(matrix[upperBound][j]);
                    }
                    // 上边界下移
                    upperBound++;
                }

                if (leftBound <= rightBound) {
                    // 在右侧从上向下遍历
                    for (int i = upperBound; i <= lowerBound; i++) {
                        ans.add(matrix[i][rightBound]);
                    }
                    // 右边界左移
                    rightBound--;
                }

                if (upperBound <= lowerBound) {
                    // 在底部从右向左遍历
                    for (int j = rightBound; j >= leftBound; j--) {
                        ans.add(matrix[lowerBound][j]);
                    }
                    // 下边界上移
                    lowerBound--;
                }

                if (leftBound <= rightBound) {
                    // 在左侧从下向上遍历
                    for (int i = lowerBound; i >= upperBound; i--) {
                        ans.add(matrix[i][leftBound]);
                    }
                    // 左边界右移
                    leftBound++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
