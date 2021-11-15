//一个 平方和三元组 (a,b,c) 指的是满足 a2 + b2 = c2 的 整数 三元组 a，b 和 c 。 
//
// 给你一个整数 n ，请你返回满足 1 <= a, b, c <= n 的 平方和三元组 的数目。 
//
// 
//
// 示例 1： 
//
// 输入：n = 5
//输出：2
//解释：平方和三元组为 (3,4,5) 和 (4,3,5) 。
// 
//
// 示例 2： 
//
// 输入：n = 10
//输出：4
//解释：平方和三元组为 (3,4,5)，(4,3,5)，(6,8,10) 和 (8,6,10) 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 250 
// 
// Related Topics 数学 枚举 
// 👍 7 👎 0

package com.helsing.leetcode.editor.cn;

public class Q1925_CountSquareSumTriples {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countTriples(int n) {
            int res = 0;
            for (int c = 5; c <= n; c++) {
                int cSquare = c * c;
                for (int a = 3; a < Math.sqrt(cSquare / 2); a++) {
                    int temp = cSquare - a * a;
                    if (Math.sqrt(temp) == (int) (Math.sqrt(temp))) {
                        res++;
                    }
                }
            }
            return res * 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}