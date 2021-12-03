//给你一个只包含 0 和 1 的 rows * columns 矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,0,1],
//            [1,1,0],
//            [1,1,0]]
//输出：13
//解释：
//有 6 个 1x1 的矩形。
//有 2 个 1x2 的矩形。
//有 3 个 2x1 的矩形。
//有 1 个 2x2 的矩形。
//有 1 个 3x1 的矩形。
//矩形数目总共 = 6 + 2 + 3 + 1 + 1 = 13 。
// 
//
// 示例 2： 
//
// 
//输入：mat = [[0,1,1,0],
//            [0,1,1,1],
//            [1,1,1,0]]
//输出：24
//解释：
//有 8 个 1x1 的子矩形。
//有 5 个 1x2 的子矩形。
//有 2 个 1x3 的子矩形。
//有 4 个 2x1 的子矩形。
//有 2 个 2x2 的子矩形。
//有 2 个 3x1 的子矩形。
//有 1 个 3x2 的子矩形。
//矩形数目总共 = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24 。
// 
//
// 示例 3： 
//
// 
//输入：mat = [[1,1,1,1,1,1]]
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：mat = [[1,0,1],[0,1,0],[1,0,1]]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= rows <= 150 
// 1 <= columns <= 150 
// 0 <= mat[i][j] <= 1 
// 
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 119 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class Q1504_CountSubmatricesWithAllOnes {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubmat(int[][] mat) {
            // 单调栈
            return stackMonotone(mat);
        }

        public int stackMonotone(int[][] mat) {
            int n = mat.length;
            int m = mat[0].length;
            int[][] row = new int[n][m];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (j == 0) {
                        row[i][j] = mat[i][j];
                    } else if (mat[i][j] != 0) {
                        row[i][j] = row[i][j - 1] + 1;
                    } else {
                        row[i][j] = 0;
                    }
                }
            }
            int ans = 0;
            for (int j = 0; j < m; ++j) {
                int i = 0;
                Deque<int[]> stack = new LinkedList<>();
                int sum = 0;
                while (i <= n - 1) {
                    int height = 1;
                    while (!stack.isEmpty() && stack.peek()[0] > row[i][j]) {
                        // 弹出的时候要减去多于的答案
                        sum -= stack.peek()[1] * (stack.peek()[0] - row[i][j]);
                        height += stack.peek()[1];
                        stack.poll();
                    }
                    sum += row[i][j];
                    ans += sum;
                    stack.push(new int[]{row[i][j], height});
                    i++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
