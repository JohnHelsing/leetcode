//给定一个以字符串表示的任意嵌套的三元表达式，计算表达式的值。
//你可以假定给定的表达式始终都是有效的并且只包含数字 0-9, ?, :, T 和 F (T 和F 分别表示真和假）。
//
// 注意： 
//
// 
// 给定的字符串长度 ≤ 10000。 
// 所包含的数字都只有一位数。 
// 条件表达式从右至左结合（和大多数程序设计语言类似）。 
// 条件是 T 和 F其一，即条件永远不会是数字。 
// 表达式的结果是数字 0-9, T 或者 F。 
// 
//
// 
//
// 示例 1： 
//
// 输入： "T?2:3"
//
//输出： "2"
//
//解释： 如果条件为真，结果为 2；否则，结果为 3。
// 
//
// 
//
// 示例 2： 
//
// 输入： "F?1:T?4:5"
//
//输出： "4"
//
//解释： 条件表达式自右向左结合。使用括号的话，相当于：
//
//             "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
//
//          -> "(F ? 1 : 4)"                 或者     -> "(T ? 4 : 5)"
//          -> "4"                                    -> "4"
// 
//
// 
//
// 示例 3： 
//
// 输入： "T?T?F:5:3"
//
//输出： "F"
//
//解释： 条件表达式自右向左结合。使用括号的话，相当于：
//
//             "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
//
//          -> "(T ? F : 3)"                 或者       -> "(T ? F : 5)"
//          -> "F"                                     -> "F"
// 
//
// 
// Related Topics 栈 递归 字符串 
// 👍 53 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0439_TernaryExpressionParser {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String parseTernary(String expression) {
            // 标准的栈
            // 输入： "F?1:T?4:5"
            // 输出： "4"
            return stack(expression);
        }

        public String stack(String expression) {
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = expression.length() - 1; i >= 0; i--) {
                if (expression.charAt(i) != '?') {
                    stack.push(expression.charAt(i));
                    continue;
                }
                char resTrue = stack.peek(); //保存true的结果，用于后面判断
                char condition = expression.charAt(i - 1); //保存condition，是T还是F

                // 找到匹配的:号
                while (!stack.isEmpty() && stack.peek() != ':') {
                    stack.pop();
                }
                stack.pop(); //弹出:号
                char resFalse = stack.peek(); // 获取false的结果
                stack.pop(); //弹出condition

                // 按条件计算出对应的值，并压栈以便后续循环计算
                if (condition == 'T') {
                    stack.push(resTrue);
                } else {
                    stack.push(resFalse);
                }
                i--; //condition已经取出计算了，跳过condition
            }

            return String.valueOf(stack.peek());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}