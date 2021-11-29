//给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。 
//
// 从形式上讲，只有满足下面几点之一，括号字符串才是有效的： 
//
// 
// 它是一个空字符串，或者 
// 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者 
// 它可以被写作 (A)，其中 A 是有效字符串。 
// 
//
// 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。 
//
// 
//
// 示例 1： 
//
// 输入："())"
//输出：1
// 
//
// 示例 2： 
//
// 输入："((("
//输出：3
// 
//
// 示例 3： 
//
// 输入："()"
//输出：0
// 
//
// 示例 4： 
//
// 输入："()))(("
//输出：4 
//
// 
//
// 提示： 
//
// 
// S.length <= 1000 
// S 只包含 '(' 和 ')' 字符。 
// 
//
// 
// Related Topics 栈 贪心 字符串 👍 106 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0921_MinimumAddToMakeParenthesesValid {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.stack("()))((");
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minAddToMakeValid(String s) {
            // 平衡法
//            return balance(s);
            // 栈
            return stack(s);
        }

        public int stack(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            int ans = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                }
                if (c == ')') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        ans++;
                    }
                }
            }
            return stack.size() + ans;
        }

        public int balance(String s) {
            int ans = 0, bal = 0;
            for (int i = 0; i < s.length(); ++i) {
                bal += s.charAt(i) == '(' ? 1 : -1;
                // It is guaranteed bal >= -1
                if (bal == -1) {
                    ans++;
                    bal++;
                }
            }
            return ans + bal;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
