//给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。 
//
// 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。 
//
// 输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。 
//
// 
//
// 示例： 
//
// 输入: "aba", "cdc", "eae"
//输出: 3
// 
//
// 
//
// 提示： 
//
// 
// 所有给定的字符串长度不会超过 10 。 
// 给定字符串列表的长度将在 [2, 50 ] 之间。 
// 
//
// 
// Related Topics 数组 哈希表 双指针 字符串 排序 
// 👍 71 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class Q0522_LongestUncommonSubsequenceIi {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLUSlength(String[] strs) {
            Arrays.sort(strs, (s1, s2) -> s2.length() - s1.length());
            for (int i = 0, j; i < strs.length; i++) {
                boolean flag = true;
                for (j = 0; j < strs.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (isSubsequence(strs[i], strs[j])) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return strs[i].length();
                }
            }
            return -1;
        }


        public boolean isSubsequence(String x, String y) {
            int j = 0;
            for (int i = 0; i < y.length() && j < x.length(); i++)
                if (x.charAt(j) == y.charAt(i)) {
                    j++;
                }
            return j == x.length();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}