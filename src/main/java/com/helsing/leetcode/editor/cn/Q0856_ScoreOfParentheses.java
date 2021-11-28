//给定一个平衡括号字符串 S，按下述规则计算该字符串的分数： 
//
// 
// () 得 1 分。 
// AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。 
// (A) 得 2 * A 分，其中 A 是平衡括号字符串。 
// 
//
// 
//
// 示例 1： 
//
// 输入： "()"
//输出： 1
// 
//
// 示例 2： 
//
// 输入： "(())"
//输出： 2
// 
//
// 示例 3： 
//
// 输入： "()()"
//输出： 2
// 
//
// 示例 4： 
//
// 输入： "(()(()))"
//输出： 6
// 
//
// 
//
// 提示： 
//
// 
// S 是平衡括号字符串，且只含有 ( 和 ) 。 
// 2 <= S.length <= 50 
// 
// Related Topics 栈 字符串 👍 251 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0856_ScoreOfParentheses {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int scoreOfParentheses(String s) {
            // 栈
            return stack(s);
        }

        public int stack(String s){
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(0); // The score of the current frame

            for (char c: s.toCharArray()) {
                if (c == '('){
                    stack.push(0);
                } else {
                    int v = stack.pop();
                    int w = stack.pop();
                    stack.push(w + Math.max(2 * v, 1));
                }
            }

            return stack.pop();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
