//给出一个字符串数组words组成的一本英语词典。
// 从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返
//回答案中字典序最小的单词。 
//
// 若无答案，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 输入：
//words = ["w","wo","wor","worl", "world"]
//输出："world"
//解释： 
//单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
// 
//
// 示例 2： 
//
// 输入：
//words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出："apple"
//解释：
//"apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
// 
//
// 
//
// 提示： 
//
// 
// 所有输入的字符串都只包含小写字母。 
// words数组长度范围为[1,1000]。 
// words[i]的长度范围为[1,30]。 
// 
// Related Topics 字典树 数组 哈希表 字符串 排序 👍 176 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.*;

public class Q0720_LongestWordInDictionary {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestWord(String[] words) {
            TireTree tree = new TireTree();
            for (int i = 0; i < words.length; i++) {
                tree.addWorld(words[i]);
            }
            String r = "";
            for (int i = 0; i < words.length; i++) {
                if (tree.isValid(words[i])) {
                    if (r.length() < words[i].length()) {
                        r = words[i];
                    } else if (r.length() == words[i].length()) {
                        if (r.compareTo(words[i]) > 0) {
                            r = words[i];
                        }
                    }
                }
            }
            return r;
        }


        class TireTree {
            private TireNode root = new TireNode();

            class TireNode {
                private boolean isEnd;
                TireNode[] links = new TireNode[26];

                public boolean isEnd() {
                    return isEnd;
                }
            }

            public void addWorld(String word) {
                TireNode cur = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (cur.links[c - 'a'] == null) {
                        cur.links[c - 'a'] = new TireNode();
                    }
                    cur = cur.links[c - 'a'];
                    if (i == word.length() - 1) cur.isEnd = true;
                }
            }

            public boolean isValid(String word) {
                TireNode cur = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (cur.links[c - 'a'] == null) {
                        return false;
                    } else if (!cur.links[c - 'a'].isEnd) {
                        return false;
                    }
                    cur = cur.links[c - 'a'];
                }
                return true;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
