//给定字符串 S，找出最长重复子串的长度。如果不存在重复子串就返回 0。 
//
// 
//
// 示例 1： 
//
// 输入："abcd"
//输出：0
//解释：没有重复子串。
// 
//
// 示例 2： 
//
// 输入："abbaba"
//输出：2
//解释：最长的重复子串为 "ab" 和 "ba"，每个出现 2 次。
// 
//
// 示例 3： 
//
// 输入："aabcaabdaab"
//输出：3
//解释：最长的重复子串为 "aab"，出现 3 次。
// 
//
// 示例 4： 
//
// 输入："aaaaa"
//输出：4
//解释：最长的重复子串为 "aaaa"，出现 2 次。 
//
// 
//
// 提示： 
//
// 
// 字符串 S 仅包含从 'a' 到 'z' 的小写英文字母。 
// 1 <= S.length <= 1500 
// 
// Related Topics 字符串 二分查找 动态规划 后缀数组 哈希函数 滚动哈希 👍 67 👎 0

package com.helsing.leetcode.editor.cn;

public class Q1062_LongestRepeatingSubstring {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestRepeatingSubstring(String s) {
            int begIdx = 0;
            int endIdx = 1;
            int len = s.length();
            int ans = 0;
            while (endIdx < len) {
                String subStr = s.substring(begIdx, endIdx);
                if (s.indexOf(subStr, begIdx + 1) != -1) {
                    ans = Math.max(ans, endIdx - begIdx);
                } else {
                    // 原来这里, begIdx++ 之后，如果endIdx不+1,
                    // 则一定有 endIdx - begIdx 小于原来的 endIdx - begIdx
                    // 所以可以不用考虑 begIdx 自增, 而 endIdx不自增
                    begIdx++;
                }
                endIdx++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
