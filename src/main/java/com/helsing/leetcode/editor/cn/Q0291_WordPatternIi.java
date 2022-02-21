//给你一种规律 pattern 和一个字符串 s，请你判断 s 是否和 pattern 的规律相匹配。 
//
// 如果存在单个字符到字符串的 双射映射 ，那么字符串 s 匹配 pattern ，
// 即：如果 pattern 中的每个字符都被它映射到的字符串替换，那么最终的
//字符串则为 s 。双射 意味着映射双方一一对应，不会存在两个字符映射到同一个字符串，
// 也不会存在一个字符分别映射到两个不同的字符串。
//
// 
//
// 示例 1： 
//
// 
//输入：pattern = "abab", s = "redblueredblue"
//输出：true
//解释：一种可能的映射如下：
//'a' -> "red"
//'b' -> "blue" 
//
// 示例 2： 
//
// 
//输入：pattern = "aaaa", s = "asdasdasdasd"
//输出：true
//解释：一种可能的映射如下：
//'a' -> "asd"
// 
//
// 示例 3： 
//
// 
//输入：pattern = "aabb", s = "xyzabcxzyabc"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pattern.length, s.length <= 20 
// pattern 和 s 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 回溯 👍 71 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q0291_WordPatternIi {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        public boolean wordPatternMatch(String pattern, String s) {
            char[] cs = pattern.toCharArray();
            return dfs(cs, 0, s, 0);
        }

        public boolean dfs(char[] cs, int idx, String s, int k) {
            if (idx == cs.length && k == s.length()) {
                return true;
            }
            if (idx == cs.length || k == s.length()) {
                return false;
            }
            // 至少要对应一个字符，否则不符合
            if (cs.length - idx > s.length() - k) {
                return false;
            }

            if (map.containsKey(cs[idx])) {
                String str = map.get(cs[idx]);
                if (k + str.length() <= s.length() && str.equals(s.substring(k, k + str.length()))) {
                    return dfs(cs, idx + 1, s, k + str.length());
                } else {
                    return false;
                }
            }
            // 当前字符最大匹配的字符串长度
            int len = s.length() - k - cs.length + idx + 1;
            for (int i = 1; i <= len; i++) {
                String str = s.substring(k, k + i);
                if (set.contains(str)) {
                    continue;
                }
                set.add(str);
                map.put(cs[idx], str);
                if (dfs(cs, idx + 1, s, k + i)) return true;
                map.remove(cs[idx]);
                set.remove(str);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
