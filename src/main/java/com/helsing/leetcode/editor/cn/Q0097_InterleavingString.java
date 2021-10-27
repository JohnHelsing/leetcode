//给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。 
//
// 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
// 
//
// 提示：a + b 意味着字符串 a 和 b 连接。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1、s2、和 s3 都由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 567 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0097_InterleavingString {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int n = s1.length(), m = s2.length(), t = s3.length();
            // 条件优化
            if (t != m + n) {
                return false;
            }
            if (m == n && n == t && t == 0) {
                return true;
            }

            // 动态规划
            boolean[] f = new boolean[m + 1];

            f[0] = true;
            for (int i = 0; i <= n; ++i) {
                for (int j = 0; j <= m; ++j) {
                    int p = i + j - 1;
                    if (i > 0) {
                        f[j] = f[j] && s1.charAt(i - 1) == s3.charAt(p);
                    }
                    if (j > 0) {
                        f[j] = f[j] || (f[j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                    }
                }
            }

            return f[m];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}