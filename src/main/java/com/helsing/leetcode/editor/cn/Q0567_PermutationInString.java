//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
// 如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 104 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 
// 👍 482 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q0567_PermutationInString {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            // 双指针
//            return twoPointers(s1, s2);

            // 滑动窗口
            return slideWindows(s1, s2);
        }

        private boolean slideWindows(String s1, String s2) {
            Map<Character, Integer> window = new HashMap<>();
            Map<Character, Integer> need = new HashMap<>();
            for (char c : s1.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            int left = 0;
            int right = 0;
            int valid = 0;
            while (right < s2.length()) {
                // 窗口左边界扩增
                char c = s2.charAt(right);
                right++;
                if (need.get(c) != null) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (need.get(c).equals(window.get(c))) {
                        valid++;
                    }
                }
                // 判断左侧窗口是否要收缩
                while (right - left >= s1.length()) {
                    // 在这里判断是否找到了合法的子串
                    if (valid == need.size()) {
                        return true;
                    }
                    char d = s2.charAt(left);
                    left++;
                    // 进行窗口内数据的一系列更新
                    if (need.get(d) != null && window.get(d) != null) {
                        if (need.get(d).equals(window.get(d))) {
                            valid--;
                        }
                        window.put(d, window.get(d) - 1);
                    }
                }
            }
            return false;
        }

        public boolean twoPointers(String s1, String s2) {
            int n = s1.length(), m = s2.length();
            if (n > m) {
                return false;
            }
            int[] cnt = new int[26];
            for (int i = 0; i < n; ++i) {
                cnt[s1.charAt(i) - 'a']--;
            }
            int left = 0;
            for (int right = 0; right < m; ++right) {
                int x = s2.charAt(right) - 'a';
                cnt[x]++;
                while (cnt[x] > 0) {
                    cnt[s2.charAt(left) - 'a']--;
                    left++;
                }
                if (right - left + 1 == n) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}