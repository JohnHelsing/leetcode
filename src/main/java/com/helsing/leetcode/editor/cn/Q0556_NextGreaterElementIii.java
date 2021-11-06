//给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。 
//
// 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：21
// 
//
// 示例 2： 
//
// 
//输入：n = 21
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 数学 双指针 字符串 
// 👍 171 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0556_NextGreaterElementIii {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nextGreaterElement(int n) {
            char[] a = ("" + n).toCharArray();
            int i = a.length - 2;
            while (i >= 0 && a[i + 1] <= a[i]) {
                i--;
            }
            if (i < 0)
                return -1;
            int j = a.length - 1;
            while (j >= 0 && a[j] <= a[i]) {
                j--;
            }
            swap(a, i, j);
            reverse(a, i + 1);
            try {
                return Integer.parseInt(new String(a));
            } catch (Exception e) {
                return -1;
            }
        }

        private void reverse(char[] a, int start) {
            int i = start, j = a.length - 1;
            while (i < j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }

        private void swap(char[] a, int i, int j) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}