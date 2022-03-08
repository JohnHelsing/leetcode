//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，
// 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 👍 619 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0059_SpiralMatrixIi {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int up = 0, down = n - 1, left = 0, right = n - 1;
            int[][] matrix = new int[n][n];
            int num = 1;
            while (num <= n * n) {
                if (up <= down) {
                    // 在顶部从左向右遍历
                    for (int j = left; j <= right; j++) {
                        matrix[up][j] = num++;
                    }
                    // 上边界下移
                    up++;
                }
                if (left <= right) {
                    // 在右侧从上向下遍历
                    for (int i = up; i <= down; i++) {
                        matrix[i][right] = num++;
                    }
                    // 右边界左移
                    right--;
                }
                if (up <= down) {
                    // 在底部从右向左遍历
                    for (int j = right; j >= left; j--) {
                        matrix[down][j] = num++;
                    }
                    // 下边界上移
                    down--;
                }

                if (left <= right) {
                    // 在左侧从下向上遍历
                    for (int i = down; i >= up; i--) {
                        matrix[i][left] = num++;
                    }
                    // 左边界右移
                    left++;
                }
            }
            return matrix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
