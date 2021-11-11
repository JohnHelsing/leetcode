//如果一个正整数自身是回文数，而且它也是一个回文数的平方，那么我们称这个数为超级回文数。 
//
// 现在，给定两个正整数 L 和 R （以字符串形式表示），返回包含在范围 [L, R] 中的超级回文数的数目。 
//
// 
//
// 示例： 
//
// 输入：L = "4", R = "1000"
//输出：4
//解释：
//4，9，121，以及 484 是超级回文数。
//注意 676 不是一个超级回文数： 26 * 26 = 676，但是 26 不是回文数。 
//
// 
//
// 提示： 
//
// 
// 1 <= len(L) <= 18 
// 1 <= len(R) <= 18 
// L 和 R 是表示 [1, 10^18) 范围的整数的字符串。 
// int(L) <= int(R) 
// 
//
// 
// Related Topics 数学 枚举 
// 👍 33 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0906_SuperPalindromes {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int superpalindromesInRange(String left, String right) {
            long L = Long.valueOf(left);
            long R = Long.valueOf(right);
            int MAGIC = 100000;
            int ans = 0;

            // count odd length;
            for (int k = 1; k < MAGIC; ++k) {
                StringBuilder sb = new StringBuilder(Integer.toString(k));
                for (int i = sb.length() - 2; i >= 0; --i)
                    sb.append(sb.charAt(i));
                long v = Long.valueOf(sb.toString());
                v *= v;
                if (v > R) break;
                if (v >= L && isPalindrome(v)) ans++;
            }

            // count even length;
            for (int k = 1; k < MAGIC; ++k) {
                StringBuilder sb = new StringBuilder(Integer.toString(k));
                for (int i = sb.length() - 1; i >= 0; --i)
                    sb.append(sb.charAt(i));
                long v = Long.valueOf(sb.toString());
                v *= v;
                if (v > R) break;
                if (v >= L && isPalindrome(v)) ans++;
            }

            return ans;
        }

        public boolean isPalindrome(long x) {
            return x == reverse(x);
        }

        public long reverse(long x) {
            long ans = 0;
            while (x > 0) {
                ans = 10 * ans + x % 10;
                x /= 10;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}