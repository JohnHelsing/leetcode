//给你一个字符串 s 和两个整数 x 和 y 。你可以执行下面两种操作任意次。 
//
// 
// 删除子字符串 "ab" 并得到 x 分。
//
// 
// 比方说，从 "cabxbae" 删除 ab ，得到 "cxbae" 。 
// 
// 
// 删除子字符串"ba" 并得到 y 分。
// 
// 比方说，从 "cabxbae" 删除 ba ，得到 "cabxe" 。 
// 
// 
// 
//
// 请返回对 s 字符串执行上面操作若干次能得到的最大得分。 
//
// 
//
// 示例 1： 
//
// 输入：s = "cdbcbbaaabab", x = 4, y = 5
//输出：19
//解释：
//- 删除 "cdbcbbaaabab" 中加粗的 "ba" ，得到 s = "cdbcbbaaab" ，加 5 分。
//- 删除 "cdbcbbaaab" 中加粗的 "ab" ，得到 s = "cdbcbbaa" ，加 4 分。
//- 删除 "cdbcbbaa" 中加粗的 "ba" ，得到 s = "cdbcba" ，加 5 分。
//- 删除 "cdbcba" 中加粗的 "ba" ，得到 s = "cdbc" ，加 5 分。
//总得分为 5 + 4 + 5 + 5 = 19 。 
//
// 示例 2： 
//
// 输入：s = "aabbaaxybbaabb", x = 5, y = 4
//输出：20
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// 1 <= x, y <= 10⁴ 
// s 只包含小写英文字母。 
// 
// Related Topics 栈 贪心 字符串 👍 16 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q1717_MaximumScoreFromRemovingSubstrings {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumGain(String s, int x, int y) {
            if (x < y) {
                return maximumGain(new StringBuffer(s).reverse().toString(), y, x);
            }
            Deque<Character> stack = new ArrayDeque<>();
            char[] chars = s.toCharArray();
            int ans = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != 'a' && chars[i] != 'b') {
                    int cnta = 0;
                    int cntb = 0;
                    while (stack.size() > 0) {
                        char c = stack.pop();
                        if (c == 'a') {
                            cnta++;
                        } else {
                            cntb++;
                        }
                    }
                    ans += Math.min(cnta, cntb) * y;

                } else if (chars[i] == 'a') {
                    stack.push('a');
                } else if (chars[i] == 'b') {
                    if (!stack.isEmpty() && stack.peek() == 'a') {
                        stack.pop();
                        ans += x;
                    } else {
                        stack.push('b');
                    }
                }
            }
            int cnta = 0, cntb = 0;
            while (stack.size() > 0) {
                char c = stack.pop();
                if (c == 'a') {
                    cnta++;
                } else {
                    cntb++;
                }
            }
            ans += Math.min(cnta, cntb) * y;
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
