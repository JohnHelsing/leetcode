// 给出一个字符串 s（仅含有小写英文字母和括号）。
//
// 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。 
//
// 注意，您的结果中 不应 包含任何括号。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "(abcd)"
//输出："dcba"
// 
//
// 示例 2： 
//
// 
//输入：s = "(u(love)i)"
//输出："iloveu"
//解释：先反转子字符串 "love" ，然后反转整个字符串。 
//
// 示例 3： 
//
// 
//输入：s = "(ed(et(oc))el)"
//输出："leetcode"
//解释：先反转子字符串 "oc" ，接着反转 "etco" ，然后反转整个字符串。 
//
// 示例 4： 
//
// 
//输入：s = "a(bcdefghijkl(mno)p)q"
//输出："apmnolkjihgfedcbq"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 2000 
// s 中只有小写英文字母和括号 
// 题目测试用例确保所有括号都是成对出现的 
// 
// Related Topics 栈 字符串 👍 210 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q1190_ReverseSubstringsBetweenEachPairOfParentheses {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseParentheses(String s) {
            // 标注的栈解法
            return stack(s);
        }


        public String stack(String s) {
            // a(bc) = acb
            // (a(bc)d) = dbca
            StringBuilder sb = new StringBuilder();
            Deque<String> stack = new ArrayDeque<>();
            char[] array = s.toCharArray();
            for (int i = 0; i < array.length; i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    stack.push(sb.toString());
                    sb.setLength(0);
                } else if (ch == ')') {
                    sb.reverse();
                    sb.insert(0, stack.pop());
                } else {
                    sb.append(ch);
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
