//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 有效括号组合需满足：左括号必须以正确的顺序闭合。 
//
// 
//
// 示例 1： 
//
//
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
//输入：n = 2
//输出：["()()","(())"]
//
//
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 2113 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q0022_GenerateParentheses {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            // 动态规划
            return dp(n);
        }

        public List<String> dp(int n) {
            List<List<String>> res = new LinkedList<>();
            res.add(new LinkedList<>(Arrays.asList("")));
            res.add(new LinkedList<>(Arrays.asList("()")));
            for (int i = 2; i <= n; i++) {
                List<String> tmp = new LinkedList<>();
                for (int j = 0; j < i; j++) {
                    List<String> str1 = res.get(j);
                    List<String> str2 = res.get(i - 1 - j);
                    for (String s1 : str1) {
                        for (String s2 : str2) {
                            String str = "(" + s1 + ")" + s2;
                            tmp.add(str);
                        }
                    }
                }
                res.add(tmp);
            }
            return res.get(n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}