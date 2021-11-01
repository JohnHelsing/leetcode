//给定两个字符串 s 和 t，判断他们的编辑距离是否为 1。 
//
// 注意： 
//
// 满足编辑距离等于 1 有三种可能的情形： 
//
// 
// 往 s 中插入一个字符得到 t 
// 从 s 中删除一个字符得到 t 
// 在 s 中替换一个字符得到 t 
// 
//
// 示例 1： 
//
// 输入: s = "ab", t = "acb"
//输出: true
//解释: 可以将 'c' 插入字符串 s 来得到 t。
// 
//
// 示例 2: 
//
// 输入: s = "cab", t = "ad"
//输出: false
//解释: 无法通过 1 步操作使 s 变为 t。 
//
// 示例 3: 
//
// 输入: s = "1203", t = "1213"
//输出: true
//解释: 可以将字符串 s 中的 '0' 替换为 '1' 来得到 t。 
// Related Topics 双指针 字符串 
// 👍 82 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0161_OneEditDistance {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isOneEditDistance(String s, String t) {
            // 特判
            if (Math.abs(s.length() - t.length()) > 1) {
                return false;
            }

            // 双指针
            return doublePoint(s, t);
        }

        public boolean doublePoint(String s, String t) {
            if (s.length() > t.length()) {
                return doublePoint(t, s);
            }
            int left = 0, rightS = s.length() - 1, rightL = t.length() - 1;
            while (left <= rightS) {
                if (s.charAt(left) != t.charAt(left)
                        && s.charAt(rightS) != t.charAt(rightL)) {
                    break;
                }
                if (s.charAt(left) == t.charAt(left)) {
                    left++;
                }
                if (s.charAt(rightS) == t.charAt(rightL)) {
                    rightS--;
                    rightL--;
                }
            }
            return s.length() == t.length() ? left == rightS : left > rightS;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}