//给定两个句子 words1, words2 （每个用字符串数组表示），和一个相似单词对的列表 pairs
// ，判断是否两个句子是相似的。
//
// 例如，当相似单词对是 pairs = [["great", "fine"], ["acting","drama"], ["skills",
//"talent"]]的时候，"great acting skills" 和 "fine drama talent" 是相似的。 
//
// 注意相似关系是不具有传递性的。例如，如果 "great" 和 "fine" 是相似的，
// "fine" 和 "good" 是相似的，但是 "great" 和
//"good" 未必是相似的。 
//
// 但是，相似关系是具有对称性的。例如，"great" 和 "fine" 是相似的相当于 "fine" 和 "great" 是相似的。 
//
// 而且，一个单词总是与其自身相似。例如，句子 words1 = ["great"], words2 = ["great"], pairs = [] 是相似的
//，尽管没有输入特定的相似单词对。 
//
// 最后，句子只会在具有相同单词个数的前提下才会相似。所以一个句子 words1 = ["great"] 永远不可能和句子 words2 = [
//"doubleplus","good"] 相似。 
//
// 
//
// 注： 
//
// 
// words1 and words2 的长度不会超过 1000。 
// pairs 的长度不会超过 2000。 
// 每个pairs[i] 的长度为 2。 
// 每个 words[i] 和 pairs[i][j] 的长度范围为 [1, 20]。 
// 
//
// 
// Related Topics 数组 哈希表 字符串 👍 28 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.*;

public class Q0734_SentenceSimilarity {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] sentence1 = {"great", "acting", "skills"};
        String[] sentence2 = {"fine", "painting", "talent"};
        List<List<String>> similarPairs = new ArrayList<>();
        List<String> a = new ArrayList<>();
        a.add("great");
        a.add("fine");
        similarPairs.add(a);
        List<String> b = new ArrayList<>();
        b.add("drama");
        b.add("acting");
        similarPairs.add(b);
        List<String> c = new ArrayList<>();
        c.add("skills");
        c.add("talent");
        similarPairs.add(c);
        solution.areSentencesSimilar(sentence1, sentence2, similarPairs);
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean areSentencesSimilar(String[] sentence1, String[] sentence2,
                                           List<List<String>> similarPairs) {
            if (sentence1.length != sentence2.length) {
                return false;
            }
            Map<String, Set<String>> similarMap = null;
            int length = sentence1.length;
            for (int i = 0; i < length; i++) {
                String word1 = sentence1[i];
                String word2 = sentence2[i];
                if (word1.equals(word2)) {
                    continue;
                }
                // 懒初始化
                if (similarMap == null) {
                    similarMap = new HashMap<>();
                    for (List<String> similarPair : similarPairs) {
                        for (int j = 0; j < 2; j++) {
                            int index = j ^ 1;
                            similarMap.compute(similarPair.get(j), (k, v) -> {
                                if (v == null) {
                                    v = new HashSet<>();
                                }
                                v.add(similarPair.get(index));
                                return v;
                            });
                        }
                    }
                }
                if (!similarMap.isEmpty()) {
                    if (similarMap.get(word1) == null ||
                            !similarMap.get(word1).contains(word2)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
