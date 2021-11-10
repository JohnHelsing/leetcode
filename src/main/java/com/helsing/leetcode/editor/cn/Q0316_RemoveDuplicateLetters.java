//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心 字符串 单调栈 
// 👍 611 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0316_RemoveDuplicateLetters {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
            // 贪心+单调栈
            return stackMonotone(s);
        }

        public String stackMonotone(String s) {
            char[] chars = s.toCharArray();
            int[] lastInx = new int[26];
            for (int i = 0; i < chars.length; i++) {
                lastInx[chars[i] - 'a'] = i; //记录每个元素最后一次出现的位置
            }
            Deque<Character> stack = new ArrayDeque<>();
            boolean[] visited = new boolean[26]; //某一个字符是否在栈中出现
            for (int i = 0; i < chars.length; i++) {
                if (visited[chars[i] - 'a']) { //如果出现舍弃当前字符
                    continue;
                }
                //当前字符在栈顶元素之前，且栈顶元素在后面还有
                while (!stack.isEmpty() && stack.peekLast() > chars[i] && lastInx[stack.peekLast() - 'a'] > i) {
                    Character c = stack.removeLast();  //移除栈顶元素
                    visited[c - 'a'] = false; //表示该字符没有在栈中出现
                }
                stack.addLast(chars[i]);
                visited[chars[i] - 'a'] = true;
            }
            StringBuilder sb = new StringBuilder();
            for (Character c : stack) {
                sb.append(c);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}