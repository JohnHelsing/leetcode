//给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答
//案。
// 
//
// 示例 1： 
//
// 
//输入：words = ["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] 由小写英文字母组成 
// 
// Related Topics 数组 哈希表 字符串 
// 👍 243 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.*;

public class Q1002_FindCommonCharacters {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> commonChars(String[] words) {
            // 计数法
            return count(words);

            // 哈希表
//            return hash(words);
        }

        public List<String> count(String[] words) {
            int[] minfreq = new int[26];
            Arrays.fill(minfreq, Integer.MAX_VALUE);
            for (String word : words) {
                int[] freq = new int[26];
                int length = word.length();
                for (int i = 0; i < length; ++i) {
                    char ch = word.charAt(i);
                    freq[ch - 'a']++;
                }
                for (int i = 0; i < 26; ++i) {
                    minfreq[i] = Math.min(minfreq[i], freq[i]);
                }
            }

            List<String> ans = new ArrayList<>();
            for (int i = 0; i < 26; ++i) {
                for (int j = 0; j < minfreq[i]; ++j) {
                    ans.add(String.valueOf((char) (i + 'a')));
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}