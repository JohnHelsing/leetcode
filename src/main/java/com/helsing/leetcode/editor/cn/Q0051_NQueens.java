//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
// 
// 
// Related Topics 数组 回溯 👍 1200 👎 0

package com.helsing.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q0051_NQueens {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            // 路径 选择列表 结束条件
            List<List<String>> ans = new ArrayList<>();
            // "." 表示空，"Q"表示皇后，初始化棋盘
            char[][] board = new char[n][n];
            for (char[] c : board) {
                Arrays.fill(c, '.');
            }
            backtracking(ans, board, 0);
            return ans;
        }

        // 路径：board 中小于 row 的那些行都已经成功放置了皇后
        // 选择列表：第 row 行的所有列都是放置皇后的选择
        // 结束条件：row 超过 board 的最后一行
        public void backtracking(List<List<String>> ans,
                                 char[][] board, int row) {
            // 触发结束条件
            if (row == board.length) {
                ans.add(charToList(board));
                return;
            }
            int n = board[row].length;
            // 在当前行的每一列都可能放置皇后
            for (int col = 0; col < n; col++) {
                // 排除可以相互攻击的格子
                if (!isValid(board, row, col)) {
                    continue;
                }
                // 做选择
                board[row][col] = 'Q';
                // 进入下一行放皇后
                backtracking(ans, board, row + 1);
                // 撤销选择
                board[row][col] = '.';
            }
        }

        /* 判断是否可以在 board[row][col] 放置皇后 */
        public boolean isValid(char[][] board, int row, int col) {
            int n = board.length;
            // 检查列是否有皇后冲突
            for (int i = 0; i < n; i++) {
                if (board[i][col] == 'Q') {
                    return false;
                }
            }
            // 检查右上方是否有皇后冲突
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }

            // 检查左上方是否有皇后冲突
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }

        public List<String> charToList(char[][] in) {
            List<String> out = new ArrayList<>();
            for (char[] chars : in) {
                out.add(new String(chars));
            }
            return out;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
