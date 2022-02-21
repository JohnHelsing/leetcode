//给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间
// 存在着双向连接的对应规律。
//
// 
//
// 示例1: 
//
// 
//输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 
//输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 
//输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= pattern.length <= 300 
// pattern 只包含小写英文字母 
// 1 <= s.length <= 3000 
// s 只包含小写英文字母和 ' ' 
// s 不包含 任何前导或尾随对空格 
// s 中每个单词都被 单个空格 分隔 
// 
// Related Topics 哈希表 字符串 👍 432 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q0290_WordPattern {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            Map<String, Character> str2ch = new HashMap<>();
            Map<Character, String> ch2str = new HashMap<>();
            int m = s.length();
            int i = 0;
            for (int p = 0; p < pattern.length(); ++p) {
                char ch = pattern.charAt(p);
                if (i >= m) {
                    return false;
                }
                int j = i;
                while (j < m && s.charAt(j) != ' ') {
                    j++;
                }
                String tmp = s.substring(i, j);
                if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                    return false;
                }
                if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
                    return false;
                }
                str2ch.put(tmp, ch);
                ch2str.put(ch, tmp);
                i = j + 1;
            }
            return i >= m;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
