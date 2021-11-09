//给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到
//合并后字符串的末尾。 
//
// 返回 合并后的字符串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "abc", word2 = "pqr"
//输出："apbqcr"
//解释：字符串合并情况如下所示：
//word1：  a   b   c
//word2：    p   q   r
//合并后：  a p b q c r
// 
//
// 示例 2： 
//
// 
//输入：word1 = "ab", word2 = "pqrs"
//输出："apbqrs"
//解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
//word1：  a   b 
//word2：    p   q   r   s
//合并后：  a p b q   r   s
// 
//
// 示例 3： 
//
// 
//输入：word1 = "abcd", word2 = "pq"
//输出："apbqcd"
//解释：注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
//word1：  a   b   c   d
//word2：    p   q 
//合并后：  a p b q c   d
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word1.length, word2.length <= 100 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 双指针 字符串 
// 👍 10 👎 0

package com.helsing.leetcode.editor.cn;

public class Q1768_MergeStringsAlternately {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String mergeAlternately(String word1, String word2) {
            // 双指针
            return twoPointers(word1, word2);
        }

        public String twoPointers(String word1, String word2) {
            int len1 = word1.length(), len2 = word2.length(), idx = 0;
            char[] res = new char[len1 + len2];
            for (int i = 0; i < len1 || i < len2; ++i) {
                if (i < len1) {
                    res[idx++] = word1.charAt(i);
                }
                if (i < len2) {
                    res[idx++] = word2.charAt(i);
                }
            }
            return new String(res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}