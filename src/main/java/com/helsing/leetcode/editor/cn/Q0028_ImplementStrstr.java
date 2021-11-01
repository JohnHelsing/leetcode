//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 104 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 
// 👍 1087 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0028_ImplementStrstr {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            int n = haystack.length(), m = needle.length();
            if (m == 0) {
                return 0;
            }
            if (n == 0) {
                return -1;
            }
            // 暴力法

            // KMP算法
//            return KMP(haystack, needle,m,n);

            // JDK自带算法
            return jdk(haystack, needle);
        }

        public int KMP(String haystack, String needle, int m, int n) {
            int[] pi = new int[m];
            for (int i = 1, j = 0; i < m; i++) {
                while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                    j = pi[j - 1];
                }
                if (needle.charAt(i) == needle.charAt(j)) {
                    j++;
                }
                pi[i] = j;
            }
            for (int i = 0, j = 0; i < n; i++) {
                while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                    j = pi[j - 1];
                }
                if (haystack.charAt(i) == needle.charAt(j)) {
                    j++;
                }
                if (j == m) {
                    return i - m + 1;
                }
            }
            return -1;
        }

        public int jdk(String haystack, String needle) {
            char[] str = needle.toCharArray();
            char[] value = haystack.toCharArray();
            char first = str[0];
            int max = (value.length - str.length);
            for (int i = 0; i <= max; i++) {
                // Look for first character.
                if (value[i] != first) {
                    while (++i <= max && value[i] != first) ;
                }
                // Found first character, now look at the rest of value
                if (i <= max) {
                    int j = i + 1;
                    int end = j + str.length - 1;
                    for (int k = 1; j < end && value[j] == str[k]; j++, k++) ;
                    if (j == end) {
                        // Found whole string.
                        return i;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}