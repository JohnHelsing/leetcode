//现在给定一个只由字符 'D' 和 'I' 组成的 秘密签名。'D' 表示两个数字间的递减关系，'I' 表示两个数字间的递增关系。并且 秘密签名 是由一个特定
//的整数数组生成的，该数组唯一地包含 1 到 n 中所有不同的数字（秘密签名的长度加 1 等于 n）。例如，秘密签名 "DI" 可以由数组 [2,1,3] 或 [
//3,1,2] 生成，但是不能由数组 [3,2,4] 或 [2,1,3,4] 生成，因为它们都不是合法的能代表 "DI" 秘密签名 的特定串。 
//
// 现在你的任务是找到具有最小字典序的 [1, 2, ... n] 的排列，使其能代表输入的 秘密签名。 
//
// 示例 1： 
//
// 输入： "I"
//输出： [1,2]
//解释： [1,2] 是唯一合法的可以生成秘密签名 "I" 的特定串，数字 1 和 2 构成递增关系。
// 
//
// 
//
// 示例 2： 
//
// 输入： "DI"
//输出： [2,1,3]
//解释： [2,1,3] 和 [3,1,2] 可以生成秘密签名 "DI"，
//但是由于我们要找字典序最小的排列，因此你需要输出 [2,1,3]。
// 
//
// 
//
// 注： 
//
// 
// 输出字符串只会包含字符 'D' 和 'I'。 
// 输入字符串的长度是一个正整数且不会超过 10,000。 
// 
//
// 
// Related Topics 栈 贪心 数组 
// 👍 46 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0484_FindPermutation {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findPermutation(String s) {
            // array
            return array(s);

            // stack
//            return stack(s);
        }

        public int[] array(String s) {
            int[] res = new int[s.length() + 1];
            for (int i = 0; i < res.length; i++)
                res[i] = i + 1;
            int i = 1;
            while (i <= s.length()) {
                int j = i;
                while (i <= s.length() && s.charAt(i - 1) == 'D') {
                    i++;
                }
                reverse(res, j - 1, i);
                i++;
            }
            return res;
        }

        public void reverse(int[] a, int start, int end) {
            for (int i = 0; i < (end - start) / 2; i++) {
                int temp = a[i + start];
                a[i + start] = a[end - i - 1];
                a[end - i - 1] = temp;
            }
        }


        public int[] stack(String s) {
            int len = s.length();
            int[] res = new int[len + 1];
            int index = 0;
            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = 1; i <= len; i++) {
                if (s.charAt(i - 1) == 'I') {
                    stack.push(i);
                    while (!stack.isEmpty()) {
                        res[index++] = stack.pop();
                    }
                } else {
                    stack.push(i);
                }
            }
            stack.push(len + 1);
            while (!stack.isEmpty()) {
                res[index++] = stack.pop();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}