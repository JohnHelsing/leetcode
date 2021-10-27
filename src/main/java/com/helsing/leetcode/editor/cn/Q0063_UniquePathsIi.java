//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
//
// 
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 654 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0063_UniquePathsIi {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test = {{0, 1, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        System.out.println(solution.uniquePathsWithObstacles(test));
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int steps[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
            //初始化第一列，只要碰到一个1，那么后边都无法走到
            for (int i = 0; i < obstacleGrid.length; i++) {
                if (obstacleGrid[i][0] == 1) {
                    break;
                }
                steps[i][0] = 1;
            }
            //初始化第一行，只要碰到一个1，那么后边都无法走到
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[0][j] == 1) {
                    break;
                }
                steps[0][j] = 1;

            }
            //在没有障碍物的情况下，到达某一点只能从左边或者上边
            for (int i = 1; i < obstacleGrid.length; i++) {
                for (int j = 1; j < obstacleGrid[0].length; j++) {
                    steps[i][j] = obstacleGrid[i][j] == 1 ? 0 : steps[i - 1][j] + steps[i][j - 1];
                }
            }
            return steps[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}