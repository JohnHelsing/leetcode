//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 105 
// 字符串 s 由 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 428 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class Q0125_ValidPalindrome {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isPalindrome("A man, a plan, a canal: Panama");
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            // 双指针
//            return towPointers(s);

            // 字符串反转
//            return reverse(s);

            // 栈
            return stack(s);
        }

        public boolean stack(String s) {
            Deque<Character> stack = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                if (Character.isLetterOrDigit(s.charAt(i))) {
                    stack.push(toLower(s.charAt(i)));
                }
            }
            int len = stack.size(), k = 0;
            if (len == 0) {
                return true;
            }
            while (k < s.length() && !stack.isEmpty()) {
                char c = s.charAt(k);
                if (Character.isLetterOrDigit(c)) {
                    if (stack.pop() != toLower(c)) {
                        return false;
                    }
                }
                k++;
            }
            return true;
        }

        public boolean reverse(String a) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < a.length(); i++) {
                if (Character.isLetterOrDigit(a.charAt(i))) {
                    sb.append(Character.toLowerCase(a.charAt(i)));
                }
            }
            return sb.toString().equals(sb.reverse().toString());
        }

        public boolean towPointers(String s) {
            char[] array = s.toCharArray();
            int left = 0, right = array.length - 1;
            while (left < right) {
                while (left < right && !isRightChar(array[left])) {
                    left++;
                }
                while (left < right && !isRightChar(array[right])) {
                    right--;
                }
                if (toLower(array[left]) != toLower(array[right])) {
                    return false;
                } else {
                    left++;
                    right--;
                }
            }
            return true;
        }

        public boolean isRightChar(char a) {
            return (a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z') || (a >= '0' && a <= '9');
        }

        public char toLower(char a) {
            if (a >= 'A' && a <= 'Z') {
                return (char) ('a' + (a - 'A'));
            } else {
                return a;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}