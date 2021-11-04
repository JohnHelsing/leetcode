//给你一个字符串 S，请你删去其中的所有元音字母（ 'a'，'e'，'i'，'o'，'u'），并返回这个新字符串。 
//
// 
//
// 示例 1： 
//
// 输入："leetcodeisacommunityforcoders"
//输出："ltcdscmmntyfrcdrs"
// 
//
// 示例 2： 
//
// 输入："aeiou"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// S 仅由小写英文字母组成。 
// 1 <= S.length <= 1000 
// 
// Related Topics 字符串 
// 👍 15 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Q1119_RemoveVowelsFromAString {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeVowels(String s) {
            Set<Character> aeiou = new HashSet<>();
            aeiou.add('a');
            aeiou.add('e');
            aeiou.add('i');
            aeiou.add('o');
            aeiou.add('u');
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (!aeiou.contains(c)) {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}