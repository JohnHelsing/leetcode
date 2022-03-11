//给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence
// 的一个子字符串，那么单词 word 的 重复值为 k 。
// 单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。
// 如果 word 不是 sequence 的子串，那么重复值 k 为 0 。
//
// 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。 
//
// 
//
// 示例 1： 
//
// 
//输入：sequence = "ababc", word = "ab"
//输出：2
//解释："abab" 是 "ababc" 的子字符串。
// 
//
// 示例 2： 
//
// 
//输入：sequence = "ababc", word = "ba"
//输出：1
//解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
// 
//
// 示例 3： 
//
// 
//输入：sequence = "ababc", word = "ac"
//输出：0
//解释："ac" 不是 "ababc" 的子字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= sequence.length <= 100 
// 1 <= word.length <= 100 
// sequence 和 word 都只包含小写英文字母。 
// 
// Related Topics 字符串 字符串匹配 👍 20 👎 0

package com.helsing.leetcode.editor.cn;

public class Q1668_MaximumRepeatingSubstring {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxRepeating(String sequence, String word) {
            int ans = 0, n = word.length();
            for (int k = 0; k + n - 1 < sequence.length(); k++) { //枚举sequence中以k为起点的子串
                int index = 0; //比较word的下标
                int cnt = 0; //该子串与word连续相同的字符个数
                for (int i = k; i < sequence.length(); i++) { //遍历该子串与word进行比较
                    if (sequence.charAt(i) == word.charAt(index++ % n)) {
                        cnt++;
                    } else {
                        break;
                    }
                }
                ans = Math.max(ans, cnt / n); // cnt/n 就是该子串包含的word个数
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
