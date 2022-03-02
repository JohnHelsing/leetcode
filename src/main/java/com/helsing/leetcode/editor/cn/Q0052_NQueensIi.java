//n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，
// 并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
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
// Related Topics 回溯 👍 337 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Q0052_NQueensIi {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.totalNQueens(4);
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalNQueens(int n) {
            AtomicInteger ans = new AtomicInteger(0);
            char[][] board = new char[n][n];
            for (char[] chars : board) {
                Arrays.fill(chars, '.');
            }
            backtracking(ans, board, 0);
            return ans.get();
        }

        public void backtracking(AtomicInteger ans, char[][] board, int row) {
            // 结束条件
            if (row == board.length) {
                ans.getAndIncrement();
                return;
            }
            int n = board[row].length;
            for (int col = 0; col < n; col++) {
                if (!valid(board, row, col)) {
                    continue;
                }
                board[row][col] = 'Q';
                backtracking(ans, board, row + 1);
                board[row][col] = '.';
            }
        }

        public boolean valid(char[][] board, int row, int col) {
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
    }
//leetcode submit region end(Prohibit modification and deletion)

}
