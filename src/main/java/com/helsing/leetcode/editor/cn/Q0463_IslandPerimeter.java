//给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地，
// grid[i][j] = 0 表示水域。
//
// 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。
// 整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
//
// 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
// 格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
//输出：16
//解释：它的周长是上面图片中的 16 个黄色的边 
//
// 示例 2： 
//
// 
//输入：grid = [[1]]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,0]]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// row == grid.length 
// col == grid[i].length 
// 1 <= row, col <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 513 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0463_IslandPerimeter {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int[] dx = {0, 1, 0, -1};
        static int[] dy = {1, 0, -1, 0};

        public int islandPerimeter(int[][] grid) {
            // 迭代，计算四周都是海水的边的贡献度
//            return recur(grid);

            // dfs
            int n = grid.length, m = grid[0].length;
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (grid[i][j] == 1) {
                        ans += dfs(i, j, grid, n, m);
                    }
                }
            }
            return ans;
        }

        public int dfs(int x, int y, int[][] grid, int n, int m) {
            if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) {
                return 1;
            }
            if (grid[x][y] == 2) {
                return 0;
            }
            grid[x][y] = 2;
            int res = 0;
            for (int i = 0; i < 4; ++i) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                res += dfs(tx, ty, grid, n, m);
            }
            return res;
        }

        public int recur(int[][] grid) {
            int n = grid.length, m = grid[0].length;
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (grid[i][j] == 1) {
                        int cnt = 0;
                        for (int k = 0; k < 4; ++k) {
                            int tx = i + dx[k];
                            int ty = j + dy[k];
                            if (tx < 0 || tx >= n || ty < 0 || ty >= m || grid[tx][ty] == 0) {
                                cnt += 1;
                            }
                        }
                        ans += cnt;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
