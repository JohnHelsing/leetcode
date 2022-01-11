//给出 字符串 text 和 字符串列表 words,
// 返回所有的索引对 [i, j] 使得在索引对范围内的子字符串 text[i]...text[j]（包括
// i 和 j）属于字符串列表 words。 
//
// 
//
// 示例 1: 
//
// 输入: text = "thestoryofleetcodeandme", words = ["story","fleet","leetcode"]
//输出: [[3,7],[9,13],[10,17]]
// 
//
// 示例 2: 
//
// 输入: text = "ababa", words = ["aba","ab"]
//输出: [[0,1],[0,2],[2,3],[2,4]]
//解释: 
//注意，返回的配对可以有交叉，比如，"aba" 既在 [0,2] 中也在 [2,4] 中
// 
//
// 
//
// 提示: 
//
// 
// 所有字符串都只包含小写字母。 
// 保证 words 中的字符串无重复。 
// 1 <= text.length <= 100 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 50 
// 按序返回索引对 [i,j]（即，按照索引对的第一个索引进行排序，当第一个索引对相同时按照第二个索引对排序）。 
// 
// Related Topics 字典树 数组 字符串 排序 👍 26 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q1065_IndexPairsOfAString {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] indexPairs(String text, String[] words) {
            List<int[]> list = new ArrayList<>();
            for (String word : words) {
                int len = word.length();
                int start = text.indexOf(word);
                while (start != -1) {
                    list.add(new int[]{start, start + len - 1});
                    start = text.indexOf(word, start + 1);
                }
            }
            int[][] ans = list.toArray(new int[list.size()][2]);
            Arrays.sort(ans, (arr1, arr2) ->
                    arr1[0] == arr2[0] ?
                            arr1[1] - arr2[1] : arr1[0] - arr2[0]);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
