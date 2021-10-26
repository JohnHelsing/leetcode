//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。 
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = ["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
// 
//
// 示例 2： 
//
// 
//输入：s = ["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"] 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 105 
// s[i] 都是 ASCII 码表中的可打印字符 
// 
// Related Topics 递归 双指针 字符串 
// 👍 476 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0344_ReverseString {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            // 双指针
//            towPointer(s);

            // 递归
            rec(s, 0, s.length - 1);
        }

        public void towPointer(char[] s) {
            for (int i = 0, j = s.length - 1; i < j; i++, j--) {
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
            }
        }

        public void rec(char[] s, int start, int end) {
            if (start < end) {
                char temp = s[start];
                s[start] = s[end];
                s[end] = temp;
                rec(s, ++start, --end);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}