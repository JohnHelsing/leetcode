//给定一个非空 01 二维数组表示的网格，一个岛屿由四连通（上、下、左、右四个方向）的 1 组成，
// 你可以认为网格的四周被海水包围。
//
// 请你计算这个网格中共有多少个形状不同的岛屿。两个岛屿被认为是相同的，
// 当且仅当一个岛屿可以通过平移变换（不可以旋转、翻转）和另一个岛屿重合。
//
// 
//
// 示例 1： 
//
// 11000
//11000
//00011
//00011
// 
//
// 给定上图，返回结果 1 。 
//
// 示例 2： 
//
// 11011
//10000
//00001
//11011 
//
// 给定上图，返回结果 3 。 
// 
//注意： 
//
// 11
//1
// 
//
// 和 
//
//  1
//11
// 
//
// 是不同的岛屿，因为我们不考虑旋转、翻转操作。 
//
// 
//
// 提示：二维数组每维的大小都不会超过 50 。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 哈希表 哈希函数 👍 114 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Q0694_NumberOfDistinctIslands {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDistinctIslands(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            // 记录所有岛屿的序列化结果
            HashSet<String> islands = new HashSet<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        // 淹掉这个岛屿，同时存储岛屿的序列化结果
                        StringBuilder sb = new StringBuilder();
                        // 初始的方向可以随便写，不影响正确性
                        dfs(grid, i, j, sb, 0);
                        islands.add(sb.toString());
                    }
                }
            }
            // 不相同的岛屿数量
            return islands.size();
        }

        public void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir) {
            int m = grid.length, n = grid[0].length;
            if (i < 0 || j < 0 || i >= m || j >= n
                    || grid[i][j] == 0) {
                return;
            }
            // 前序遍历位置：进入 (i, j)
            grid[i][j] = 0;
            sb.append(dir).append(',');

            dfs(grid, i - 1, j, sb, 1); // 上
            dfs(grid, i + 1, j, sb, 2); // 下
            dfs(grid, i, j - 1, sb, 3); // 左
            dfs(grid, i, j + 1, sb, 4); // 右

            // 后序遍历位置：离开 (i, j)
            sb.append(-dir).append(',');
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
