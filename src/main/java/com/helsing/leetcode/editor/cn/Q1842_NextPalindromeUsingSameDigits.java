//给你一个很长的数字回文串 num ，返回 大于 num、由相同数字重新组合而成的最小 回文串。 
//
// 如果不存在这样的回文串，则返回空串 ""。 
//
// 回文串 是正读和反读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = "1221"
//输出："2112"
//解释：下个比 "1221" 大的回文串是 "2112"。
// 
//
// 示例 2： 
//
// 
//输入：num = "32123"
//输出：""
//解释：不存在通过重组 "32123" 的数字可得、比 "32123" 还大的回文串。
// 
//
// 示例 3： 
//
// 
//输入：num = "45544554"
//输出："54455445"
//解释：下个比 "45544554" 还要大的回文串是 "54455445"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 105 
// num 是回文串。 
// 
// Related Topics 双指针 字符串 
// 👍 5 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Arrays;

public class Q1842_NextPalindromeUsingSameDigits {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String nextPalindrome(String num) {
            int n = num.length();
            if (n < 3) {
                return "";
            }
            char[] chars = num.toCharArray();
            int mid = n / 2 - 1;// 找到中间的位置往前进行搜索
            int l = mid;
            while (l - 1 >= 0 && chars[l - 1] >= chars[l]) {
                l--;
            }
            if (l == 0) {
                return "";// 此时的 num 已经是最大的了
            }
            // 否则 num[l - 1] < num[l] 那么从 l 往后找到第一个 大于 num[l - 1] 的和他交换即可
            while (mid > l && chars[mid] <= chars[l - 1]) {
                mid--;
            }
            // 交换 num[mid] 和 mid[l - 1]
            // 对称的位置同理进行交换
            // x = n - 1 - mid
            swap(chars, mid, l - 1);
            swap(chars, n - 1 - mid, n - l);
            mid = n / 2;
            // 然后 num[l : mid] 进行降序排列
            Arrays.sort(chars, l, mid);
            for (int i = l; i < mid; i++) {
                chars[n - 1 - i] = chars[i];
            }
            return new String(chars);
        }

        public void swap(char[] chars, int i, int j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}