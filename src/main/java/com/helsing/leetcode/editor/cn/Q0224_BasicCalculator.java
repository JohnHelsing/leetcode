//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 递归 数学 字符串 
// 👍 667 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0224_BasicCalculator {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.calculate("1-(3+2)");
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            // 括号展开+栈
            return stack(s);
        }

        public int stack(String s) {
            int ans = 0;
            int n = s.length(), sign = 1, i = 0;
            Deque<Integer> signStack = new ArrayDeque<>();
            signStack.push(1);
            while (i < n) {
                if (s.charAt(i) == ' ') {
                    i++;
                } else if (s.charAt(i) == '+') {
                    sign = signStack.peek();
                    i++;
                } else if (s.charAt(i) == '-') {
                    sign = -signStack.peek();
                    i++;
                } else if (s.charAt(i) == '(') {
                    signStack.push(sign);
                    i++;
                } else if (s.charAt(i) == ')') {
                    signStack.pop();
                    i++;
                } else {
                    long num = 0;
                    while (i < n && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + s.charAt(i) - '0';
                        i++;
                    }
                    ans += sign * num;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}