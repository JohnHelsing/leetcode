//句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。 
//
// 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。 
//
// 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：s1 = "this apple is sweet", s2 = "this apple is sour"
//输出：["sweet","sour"]
// 
//
// 示例 2： 
//
// 
//输入：s1 = "apple apple", s2 = "banana"
//输出：["banana"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 200 
// s1 和 s2 由小写英文字母和空格组成 
// s1 和 s2 都不含前导或尾随空格 
// s1 和 s2 中的所有单词间均由单个空格分隔 
// 
// Related Topics 哈希表 字符串 👍 102 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.*;

public class Q0884_UncommonWordsFromTwoSentences {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] uncommonFromSentences(String s1, String s2) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String s : (s1 + " " + s2).split(" ")) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            List<String> list = new LinkedList<>();
            for (String s : map.keySet()) {
                if (map.get(s) == 1) {
                    list.add(s);
                }
            }
            return list.toArray(new String[list.size()]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
