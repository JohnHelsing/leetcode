//字符串可以用 缩写 进行表示，缩写 的方法是将任意数量的 不相邻 的子字符串替换为相应子串的长度。例如，字符串 "substitution" 可以缩写为（不
//止这几种方法）： 
//
// 
// "s10n" ("s ubstitutio n") 
// "sub4u4" ("sub stit u tion") 
// "12" ("substitution") 
// "su3i1u2on" ("su bst i t u ti on") 
// "substitution" (没有替换子字符串) 
// 
//
// 下列是不合法的缩写： 
//
// 
// "s55n" ("s ubsti tutio n"，两处缩写相邻) 
// "s010n" (缩写存在前导零) 
// "s0ubstitution" (缩写是一个空字符串) 
// 
//
// 给你一个字符串单词 word 和一个缩写 abbr ，判断这个缩写是否可以是给定单词的缩写。 
//
// 子字符串是字符串中连续的非空字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "internationalization", abbr = "i12iz4n"
//输出：true
//解释：单词 "internationalization" 可以缩写为 "i12iz4n" ("i nternational iz atio n") 。
// 
//
// 示例 2： 
//
// 
//输入：word = "apple", abbr = "a2e"
//输出：false
//解释：单词 "apple" 无法缩写为 "a2e" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 20 
// word 仅由小写英文字母组成 
// 1 <= abbr.length <= 10 
// abbr 由小写英文字母和数字组成 
// abbr 中的所有数字均符合 32-bit 整数范围 
// 
// Related Topics 双指针 字符串 
// 👍 33 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0408_ValidWordAbbreviation {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validWordAbbreviation(String word, String abbr) {
            char[] chars = abbr.toCharArray();
            int num = 0;    // 缩写中的数字，不能出现前导0
            int next = 0;   // 遍历 chars 的指针
            for (char c : chars) {
                // 如果是数字，则拼接成最后的样子
                if (c >= '0' && c <= '9') {
                    // 前导0数字不合法
                    if (num == 0 && c == '0') {
                        return false;
                    }
                    num = num * 10 + (c - '0');
                    continue;
                }
                next = next + num;  // 更新指针
                // 如果 next 超出了 word 的长度，说明不是 word 的缩写
                // 或者，如果 word 和 abbr 在 next 位置的字符不一致，则说明不是 word 的缩写
                if (next >= word.length() || (word.charAt(next) != c)) {
                    return false;
                }
                next++;
                num = 0;
            }
            return next + num == word.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}