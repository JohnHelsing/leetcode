//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。 
//
// 示例 1: 
//
// 
//输入: "abab"
//
//输出: True
//
//解释: 可由子字符串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: "aba"
//
//输出: False
// 
//
// 示例 3: 
//
// 
//输入: "abcabcabcabc"
//
//输出: True
//
//解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
// 
// Related Topics 字符串 字符串匹配 
// 👍 555 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Arrays;

public class Q0459_RepeatedSubstringPattern {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            return (s + s).contains(s);
        }

        public boolean kmpOpt(String query, String pattern) {
            int n = pattern.length();
            int[] fail = new int[n];
            Arrays.fill(fail, -1);
            for (int i = 1; i < n; ++i) {
                int j = fail[i - 1];
                while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                    j = fail[j];
                }
                if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                    fail[i] = j + 1;
                }
            }
            return fail[n - 1] != -1 && n % (n - fail[n - 1] - 1) == 0;
        }

        public boolean kmp(String query, String pattern) {
            int n = query.length();
            int m = pattern.length();
            int[] fail = new int[m];
            Arrays.fill(fail, -1);
            for (int i = 1; i < m; ++i) {
                int j = fail[i - 1];
                while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                    j = fail[j];
                }
                if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                    fail[i] = j + 1;
                }
            }
            int match = -1;
            for (int i = 1; i < n - 1; ++i) {
                while (match != -1 && pattern.charAt(match + 1) != query.charAt(i)) {
                    match = fail[match];
                }
                if (pattern.charAt(match + 1) == query.charAt(i)) {
                    ++match;
                    if (match == m - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}