//给你一个字符串 s，找出它的所有子串并按字典序排列，返回排在最后的那个子串。 
//
// 
//
// 示例 1： 
//
// 输入："abab"
//输出："bab"
//解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 "bab
//"。
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："tcode"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 4 * 10^5 
// s 仅含有小写英文字符。 
// 
// Related Topics 双指针 字符串 
// 👍 54 👎 0

package com.helsing.leetcode.editor.cn;

public class Q1163_LastSubstringInLexicographicalOrder {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String lastSubstring(String s) {
            // 双指针
            return twoPointers(s);
        }

        public String twoPointers(String s) {
            int left = 0, right = 1, k = 0;
            while (right + k < s.length()) {
                char leftChar = s.charAt(left);
                char leftKChar = s.charAt(left + k);
                char rightKChar = s.charAt(right + k);
                if (leftKChar == rightKChar) {
                    k++;
                } else if (rightKChar > leftChar) {
                    left = right + k;
                    right = left + 1;
                    k = 0;
                } else if (leftKChar < rightKChar) {
                    left = right;
                    right++;
                    k = 0;
                } else {
                    right++;
                    k = 0;
                }
            }
            return s.substring(left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}