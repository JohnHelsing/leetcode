//给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。 
//
// 示例: 
//假设 words = ["practice", "makes", "perfect", "coding", "makes"] 
//
// 输入: word1 = “coding”, word2 = “practice”
//输出: 3
// 
//
// 输入: word1 = "makes", word2 = "coding"
//输出: 1
// 
//
// 注意: 
//你可以假设 word1 不等于 word2, 并且 word1 和 word2 都在列表里。 
// Related Topics 数组 字符串 👍 84 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0243_ShortestWordDistance {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestDistance(String[] wordsDict, String word1, String word2) {
            int p1 = -1;
            int p2 = -1;
            int len = wordsDict.length;
            int ans = len;
            for (int i = 0; i < len; i++) {
                if (wordsDict[i].equals(word1)) {
                    p1 = i;
                    if (p2 != -1) {
                        ans = Math.min(ans, p1 - p2);
                    }
                } else if (wordsDict[i].equals(word2)) {
                    p2 = i;
                    if (p1 != -1) {
                        ans = Math.min(ans, p2 - p1);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
