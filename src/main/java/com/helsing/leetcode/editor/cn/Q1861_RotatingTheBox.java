//给你一个 m x n 的字符矩阵 box ，它表示一个箱子的侧视图。箱子的每一个格子可能为： 
//
// 
// '#' 表示石头 
// '*' 表示固定的障碍物 
// '.' 表示空位置 
// 
//
// 这个箱子被 顺时针旋转 90 度 ，由于重力原因，部分石头的位置会发生改变。每个石头会垂直掉落，直到它遇到障碍物，另一个石头或者箱子的底部。重力 不会 影
//响障碍物的位置，同时箱子旋转不会产生惯性 ，也就是说石头的水平位置不会发生改变。 
//
// 题目保证初始时 box 中的石头要么在一个障碍物上，要么在另一个石头上，要么在箱子的底部。 
//
// 请你返回一个 n x m的矩阵，表示按照上述旋转后，箱子内的结果。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：box = [["#",".","#"]]
//输出：[["."],
//      ["#"],
//      ["#"]]
// 
//
// 示例 2： 
//
// 
//
// 输入：box = [["#",".","*","."],
//            ["#","#","*","."]]
//输出：[["#","."],
//      ["#","#"],
//      ["*","*"],
//      [".","."]]
// 
//
// 示例 3： 
//
// 
//
// 输入：box = [["#","#","*",".","*","."],
//            ["#","#","#","*",".","."],
//            ["#","#","#",".","#","."]]
//输出：[[".","#","#"],
//      [".","#","#"],
//      ["#","#","*"],
//      ["#","*","."],
//      ["#",".","*"],
//      ["#",".","."]]
// 
//
// 
//
// 提示： 
//
// 
// m == box.length 
// n == box[i].length 
// 1 <= m, n <= 500 
// box[i][j] 只可能是 '#' ，'*' 或者 '.' 。 
// 
// Related Topics 数组 双指针 矩阵 
// 👍 6 👎 0

package com.helsing.leetcode.editor.cn;

public class Q1861_RotatingTheBox {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char[][] rotateTheBox(char[][] box) {
            return twoPointers(box);
        }

        public char[][] twoPointers(char[][] box) {
            int m = box.length, n = box[0].length;
            char[][] ans = new char[n][m];  // 用来构建返回值的二维数组
            // 首先逐行处理，把石头挪到该放的地方去
            for (int i = 0; i < m; ++i) {
                // 首先假设当前 i 行可放的位置是 pos
                int pos = n - 1;
                // 然后从右往左遍历，逐个更新石头的位置
                for (int j = n - 1; j >= 0; --j) {
                    if (box[i][j] == '#') {
                        // 遇到了石头，先把它放到该放的位置去
                        box[i][pos--] = '#';
                        // 确保没有覆盖掉起始位置的石头，然后把挪动前的位置置为 空（.）
                        if (pos != j - 1) {
                            box[i][j] = '.';
                        }
                    } else if (box[i][j] == '*') {
                        // 如果遇到了障碍物，那么就更新可放的位置为障碍物的下一个位置（左边）
                        pos = j - 1;
                    }
                }
            }
            // 然后把更新后的位置映射到返回值中
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    ans[j][m - 1 - i] = box[i][j];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}