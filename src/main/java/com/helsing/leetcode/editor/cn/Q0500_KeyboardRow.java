//给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。 
//
// 美式键盘 中： 
//
// 
// 第一行由字符 "qwertyuiop" 组成。 
// 第二行由字符 "asdfghjkl" 组成。 
// 第三行由字符 "zxcvbnm" 组成。 
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["Hello","Alaska","Dad","Peace"]
//输出：["Alaska","Dad"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["omk"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：words = ["adsdf","sfd"]
//输出：["adsdf","sfd"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 100 
// words[i] 由英文字母（小写和大写字母）组成 
// 
// Related Topics 数组 哈希表 字符串 👍 196 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.*;

public class Q0500_KeyboardRow {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findWords(String[] words) {
            List<String> list = new ArrayList<String>();
            String rowIdx = "12210111011122000010020202";
            for (String word : words) {
                boolean isValid = true;
                char idx = rowIdx.charAt(Character.toLowerCase(word.charAt(0)) - 'a');
                for (int i = 1; i < word.length(); ++i) {
                    if (rowIdx.charAt(Character.toLowerCase(word.charAt(i)) - 'a') != idx) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    list.add(word);
                }
            }
            String[] ans = new String[list.size()];
            for (int i = 0; i < list.size(); ++i) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
