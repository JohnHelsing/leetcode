//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
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
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
// Related Topics 数组 动态规划 
// 👍 328 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q0119_PascalsTriangleIi {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> res = solution.getRow(3);
        for (Integer re : res) {
            System.out.print(re + " ");
        }
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            // 动态规划
            return dp(rowIndex);
        }

        public List<Integer> dp(int rowIndex) {
            rowIndex = rowIndex + 1;
            List<Integer> ret = new ArrayList<>(rowIndex);
            ret.add(1);
            for (int i = 1; i < rowIndex; i++) {
                List<Integer> row = new ArrayList<>();
                row.add(1);
                for (int j = 1; j < i; j++) {
                    row.add(ret.get(j) + ret.get(j - 1));
                }
                row.add(1);
                ret.clear();
                ret.addAll(row);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}