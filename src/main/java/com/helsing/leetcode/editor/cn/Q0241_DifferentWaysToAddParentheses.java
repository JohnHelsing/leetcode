//给你一个由数字和运算符组成的字符串 expression ，
// 按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。
// 你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：expression = "2-1-1"
//输出：[0,2]
//解释：
//((2-1)-1) = 0 
//(2-(1-1)) = 2
// 
//
// 示例 2： 
//
// 
//输入：expression = "2*3-4*5"
//输出：[-34,-14,-10,-10,10]
//解释：
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= expression.length <= 20 
// expression 由数字和算符 '+'、'-' 和 '*' 组成。 
// 输入表达式中的所有整数值在范围 [0, 99] 
// 
// Related Topics 递归 记忆化搜索 数学 字符串 动态规划 👍 520 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q0241_DifferentWaysToAddParentheses {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 备忘录
         */
        Map<String, List<Integer>> memo = new HashMap<>();

        public List<Integer> diffWaysToCompute(String expression) {
            // 分治算法 递归的进行先分再治

            // 避免重复计算(备忘录模式)
            if (memo.containsKey(expression)) {
                return memo.get(expression);
            }

            List<Integer> ans = new ArrayList<>();
            int len = expression.length();

            // 递归停止条件是当前字符是一个数字
            if (isNumber(expression)) {
                int num = 0;
                //将该数字从char数组转换为一个int型数值
                for (int i = 0; i < len; i++) {
                    num = num * 10 + expression.charAt(i) - '0';
                }
                ans.add(num);
                return ans;
            }

            // 开始进行切分
            for (int i = 0; i < len; i++) {
                if (!Character.isDigit(expression.charAt(i))) {
                    //切分左右分治所使用的表达式数组
                    String left = expression.substring(0, i);
                    String right = expression.substring(i + 1);
                    //对左边的表达式在进行一次同样的操作
                    List<Integer> leftList = diffWaysToCompute(left);
                    //对右边的表达式在进行一次同样的操作
                    List<Integer> rightList = diffWaysToCompute(right);
                    //计算左右两个表达式在当前用来切分的运算符进行运算后得到的所有可能的结果
                    List<Integer> tempRes = calculate(leftList, rightList,
                            expression.charAt(i));
                    //将这些结果加入最后的列表中作为这一层分治的最终结果
                    ans.addAll(tempRes);
                }
            }

            // 将结果添加进备忘录
            memo.put(expression, ans);
            return ans;
        }

        /**
         * 计算表达式
         *
         * @param leftList
         * @param rightList
         * @param simple
         * @return
         */
        private List<Integer> calculate(List<Integer> leftList,
                                        List<Integer> rightList,
                                        char simple) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < leftList.size(); i++) {
                for (Integer j : rightList) {
                    int res = switch (simple) {
                        case '+' -> leftList.get(i) + j;
                        case '-' -> leftList.get(i) - j;
                        default -> leftList.get(i) * j;
                    };
                    ans.add(res);
                }
            }
            return ans;
        }

        /**
         * 判断是否是数字
         *
         * @param expression
         * @return
         */
        public boolean isNumber(String expression) {
            for (char c : expression.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
