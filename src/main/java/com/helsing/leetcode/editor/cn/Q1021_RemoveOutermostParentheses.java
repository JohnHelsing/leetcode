//有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。 
//
// 
// 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。 
// 
//
// 如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
// 
//
// 给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。 
//
// 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "(()())(())"
//输出："()()()"
//解释：
//输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
//删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。 
//
// 示例 2： 
//
// 
//输入：s = "(()())(())(()(()))"
//输出："()()()()(())"
//解释：
//输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
//删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
// 
//
// 示例 3： 
//
// 
//输入：s = "()()"
//输出：""
//解释：
//输入字符串为 "()()"，原语化分解得到 "()" + "()"，
//删除每个部分中的最外层括号后得到 "" + "" = ""。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 105 
// s[i] 为 '(' 或 ')' 
// s 是一个有效括号字符串 
// 
// Related Topics 栈 字符串 
// 👍 183 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class Q1021_RemoveOutermostParentheses {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeOuterParentheses(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }
            // 双指针
//            return doublePoint(s);

            // 栈
            return stack(s);
        }

        public String stack(String s) {
            Deque<Character> stack = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (stack.isEmpty() && c == '(') {
                    stack.push('(');
                } else if (!stack.isEmpty() && c == '(') {
                    stack.push('(');
                    sb.append(c);
                }
                if (c == ')') {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        sb.append(c);
                    }
                }
            }
            return sb.toString();
        }

        public String doublePoint(String s) {
            StringBuilder sb = new StringBuilder();
            char[] arr = s.toCharArray();
            int leftNum = 1;
            int rightNum = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == '(') {
                    leftNum++;
                } else {
                    rightNum++;
                }
                if (leftNum == rightNum) {
                    i++;
                    leftNum = 1;
                    rightNum = 0;
                } else {
                    sb.append(arr[i]);
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}