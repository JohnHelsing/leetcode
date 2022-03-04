//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 6282 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q0003_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(res);
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            // 条件优化
            if (s == null || s.equals("")) {
                return 0;
            }
            if (s.length() == 1) {
                return 1;
            }

            // 滑动窗口法
            return slideWindows(s);
//            return windows(s);

            // 动态规划
//            return dp(s);
        }

        private int slideWindows(String s) {
            Map<Character, Integer> window = new HashMap<>();
            int left = 0;
            int right = 0;
            int ans = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                window.put(c, window.getOrDefault(c, 0) + 1);
                right++;
                while (window.getOrDefault(c, 0) > 1) {
                    char d = s.charAt(left);
                    left++;
                    // 进行窗口内数据的一系列更新
                    window.put(d, window.get(d) - 1);
                }
                // 在这里更新答案
                ans = Math.max(ans, right - left);
            }
            return ans;
        }

        public int windows(String s) {
            int ans = 0;
            // 存放重复字符判断器
            Set<Character> characters = new HashSet<>();
            // 定义左右指针
            int lk = 0, rk = 0;
            int size = s.length();
            for (; lk < size; lk++) {
                // 移除左指针走过的字符
                if (lk != 0) {
                    characters.remove(s.charAt(lk - 1));
                }
                // 窗口开始滑动
                while (rk < size
                        && !characters.contains(s.charAt(rk))) {
                    // 不断地移动右指针
                    characters.add(s.charAt(rk));
                    rk++;
                }
                ans = Math.max(ans, rk - lk);
                //当ans大于等于剩下字符串的长度时，不再遍历
                if (ans >= size - lk - 1) {
                    break;
                }
            }
            return ans;
        }


        public int dp(String s) {
            // 初始
            char[] tar = s.toCharArray();
            int[] dp = new int[tar.length];
            dp[0] = 1;
            int max = 1;
            int begin = 0;
            for (int i = 1; i < dp.length; i++) {
                int pos = -1;

                // 判断cur字符在tar字符数组中的[begin,end)范围内从右到左第一个出现的位置，如果未出现则返回-1
                for (int j = i - 1; j >= begin; j--) {
                    if (tar[j] == tar[i]) {
                        pos = j;
                    }
                }

                if (pos == -1) {
                    // 当前字符与前面求得的最大无重复子串可以合成一个新的最大无重复子串
                    dp[i] = dp[i - 1] + 1;
                    max = Math.max(dp[i], max);
                } else {
                    // 当前字符与前面求得的最大无重复子串中的某个字符重复，找到最后一个重复的为位置pos
                    // 此时最大无重复子串长度dp[i]即为 i - pos，更新前一个最大无重复子串的起始索引
                    dp[i] = i - pos;
                    begin = pos + 1;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
