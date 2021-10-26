//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 
// 👍 616 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q0118_PascalsTriangle {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> ret = solution.generate(5);
        for (List<Integer> res : ret) {
            for (Integer re : res) {
                System.out.print(re + " ");
            }
            System.out.println("");
        }
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            // 数学方法:
//            return math(numRows);

            // 动态规划解法
            return dp(numRows);
        }

        public List<List<Integer>> math(int numRows) {
            List<List<Integer>> ret = new ArrayList<List<Integer>>();
            for (int i = 0; i < numRows; ++i) {
                List<Integer> row = new ArrayList<Integer>();
                for (int j = 0; j <= i; ++j) {
                    if (j == 0 || j == i) {
                        row.add(1);
                    } else {
                        row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                    }
                }
                ret.add(row);
            }
            return ret;
        }

        public List<List<Integer>> dp(int numRows) {
            List<List<Integer>> ret = new ArrayList<>(numRows);
            List<Integer> rowOne = new ArrayList<>(1);
            rowOne.add(1);
            ret.add(rowOne);
            for (int i = 1; i < numRows; i++) {
                List<Integer> row = new ArrayList<>();
                row.add(1);
                for (int j = 1; j < i; j++) {
                    row.add(ret.get(i - 1).get(j) + ret.get(i - 1).get(j - 1));
                }
                row.add(1);
                ret.add(row);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}