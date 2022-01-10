//给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。 
//
// 有效的表达式需遵循以下约定： 
//
// 
// "t"，运算结果为 True 
// "f"，运算结果为 False 
// "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT） 
// "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND） 
// "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR） 
// 
//
// 
//
// 示例 1： 
//
// 输入：expression = "!(f)"
//输出：true
// 
//
// 示例 2： 
//
// 输入：expression = "|(f,t)"
//输出：true
// 
//
// 示例 3： 
//
// 输入：expression = "&(t,f)"
//输出：false
// 
//
// 示例 4： 
//
// 输入：expression = "|(&(t,f,t),!(t))"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= expression.length <= 20000 
// expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。 
// expression 是以上述形式给出的有效表达式，表示一个布尔值。 
// 
// Related Topics 栈 递归 字符串 👍 58 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q1106_ParsingABooleanExpression {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean parseBoolExpr(String expression) {
            return stack(expression);
        }

        public boolean stack(String expression) {
            Deque<Character> stack = new ArrayDeque<>();
            for (char c : expression.toCharArray()) {
                if (c == ',') {
                    continue;
                } else if (c != ')') {
                    stack.addLast(c);
                } else {
                    // 创建一个新栈
                    Deque<Character> buffer = new ArrayDeque<>();
                    // 把括号中间的字符都放到新栈中去
                    while (stack.peekLast() != '(') {
                        buffer.push(stack.pollLast());
                    }
                    // 去掉 ( 字符
                    stack.pollLast();
                    // 再处理新栈中的表达式，获取处理结果 ret
                    char ret = 't';
                    char operator = stack.pollLast();
                    // 如果 `operator == !` 那么说明新栈里面只会有一个字符，反转就好了
                    if (operator == '!') {
                        ret = buffer.pollLast() == 't' ? 'f' : 't';
                    } else if (operator == '&') {
                        ret = 't';
                        // 如果是 & 那么就需要 buffer 里面全是 t 时，才返回 t，只要有一个 f 就返回 f
                        while (!buffer.isEmpty()) {
                            if (buffer.pollLast() == 'f') {
                                ret = 'f';
                                break;
                            }
                        }
                    } else {
                        ret = 'f';
                        // 如果是 | 那么就需要 buffer 里面全是 f 时，才返回 f，
                        // 只要有一个 t，就返回 t
                        while (!buffer.isEmpty()) {
                            if (buffer.pollLast() == 't') {
                                ret = 't';
                            }
                        }
                    }
                    // 再把处理结果放到栈中
                    stack.offerLast(ret);
                }
            }
            return stack.peek() == 't';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
