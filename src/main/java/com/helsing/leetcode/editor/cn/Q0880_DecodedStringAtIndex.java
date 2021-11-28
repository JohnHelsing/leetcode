//给定一个编码字符串 S。请你找出 解码字符串 并将其写入磁带。
// 解码时，从编码字符串中 每次读取一个字符 ，并采取以下步骤：
//
// 
// 如果所读的字符是字母，则将该字母写在磁带上。 
// 如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。 
// 
//
// 现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。 
//
// 
//
// 示例 1： 
//
// 输入：S = "leet2code3", K = 10
//输出："o"
//解释：
//解码后的字符串为 "leetleetcodeleetleetcodeleetleetcode"。
//字符串中的第 10 个字母是 "o"。
// 
//
// 示例 2： 
//
// 输入：S = "ha22", K = 5
//输出："h"
//解释：
//解码后的字符串为 "hahahaha"。第 5 个字母是 "h"。
// 
//
// 示例 3： 
//
// 输入：S = "a2345678999999999999999", K = 1
//输出："a"
//解释：
//解码后的字符串为 "a" 重复 8301530446056247680 次。第 1 个字母是 "a"。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= S.length <= 100 
// S 只包含小写字母与数字 2 到 9 。 
// S 以字母开头。 
// 1 <= K <= 10^9 
// 题目保证 K 小于或等于解码字符串的长度。 
// 解码后的字符串保证少于 2^63 个字母。 
// 
// Related Topics 栈 字符串 👍 151 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0880_DecodedStringAtIndex {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeAtIndex(String s, int k) {
            // 栈
            return stack(s,k);
        }

        public String stack(String s, int k){
            Deque<long[]> stack = new ArrayDeque<>(); // 存储以每个字符结束的解码后字符串的长度
            stack.push(new long[]{-1, 0});

            for (char c : s.toCharArray()) {
                // 如果是数字，那么当前压栈的是 [前面位置的字母，前面位置的字母所在长度位置 * 当前的数字]
                if (Character.isDigit(c)) {
                    stack.push(new long[]{stack.peek()[0], stack.peek()[1] * (c - '0')});
                } else {
                    stack.push(new long[]{c - 'a', stack.peek()[1] + 1});
                }

                // 如果目标位置 k <= 当前已经解码的字符串长度，那么就开始往回找答案，一定可以找到
                if (k <= stack.peek()[1]) {
                    while (true) {
                        if (k == stack.peek()[1]) {
                            return String.valueOf((char) (stack.peek()[0] + 'a'));
                        } else if (k < stack.peek()[1]) {
                            stack.pop();
                        } else {
                            k--; // 之所以先 -- 再 ++，是因为比如 k=4，len=4，直接取模得到的是 0，而不是 4
                            k %= stack.peek()[1];
                            k++;
                        }
                    }
                }
            }
            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
