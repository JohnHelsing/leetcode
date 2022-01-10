//给定两个字符串, A 和 B。 
//
// A 的旋转操作就是将 A 最左边的字符移动到最右边。
// 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后
//，A 能变成B，那么返回True。 
//
// 
//示例 1:
//输入: A = 'abcde', B = 'cdeab'
//输出: true
//
//示例 2:
//输入: A = 'abcde', B = 'abced'
//输出: false 
//
// 注意： 
//
// 
// A 和 B 长度不超过 100。 
// 
// Related Topics 字符串 字符串匹配 👍 158 👎 0

package com.helsing.leetcode.editor.cn;

import java.math.BigInteger;
import java.util.Arrays;

public class Q0796_RotateString {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean rotateString(String s, String goal) {
//            return s.length() == goal.length() && (s + s).contains(goal);

            // KMP算法
//            return kmp(s, goal);

            // Rabin-Karp 字符串哈希
            return rabinKarp(s, goal);
        }

        public boolean rabinKarp(String s, String goal) {
            int MOD = 1_000_000_007;
            int P = 113;
            int Pinv = BigInteger.valueOf(P)
                    .modInverse(BigInteger.valueOf(MOD))
                    .intValue();

            long hb = 0, power = 1;
            for (char x : goal.toCharArray()) {
                hb = (hb + power * x) % MOD;
                power = power * P % MOD;
            }

            long ha = 0;
            power = 1;
            char[] ca = s.toCharArray();
            for (char x : ca) {
                ha = (ha + power * x) % MOD;
                power = power * P % MOD;
            }

            for (int i = 0; i < ca.length; ++i) {
                char x = ca[i];
                ha += power * x - x;
                ha %= MOD;
                ha *= Pinv;
                ha %= MOD;
                if (ha == hb && (s.substring(i + 1) + s.substring(0, i + 1)).equals(goal))
                    return true;

            }
            return false;
        }

        public boolean kmp(String s, String goal) {
            int N = s.length();
            if (N != goal.length()) {
                return false;
            }
            if (N == 0) {
                return true;
            }

            //Compute shift table
            int[] shifts = new int[N + 1];
            Arrays.fill(shifts, 1);
            int left = -1;
            for (int right = 0; right < N; ++right) {
                while (left >= 0 && (goal.charAt(left) != goal.charAt(right))) {
                    left -= shifts[left];
                }
                shifts[right + 1] = right - left++;
            }

            //Find match of B in A+A
            int matchLen = 0;
            for (char c : (s + s).toCharArray()) {
                while (matchLen >= 0 && goal.charAt(matchLen) != c) {
                    matchLen -= shifts[matchLen];
                }
                if (++matchLen == N) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
