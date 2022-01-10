//给你一个字符串化学式 formula ，返回 每种原子的数量 。 
//
// 原子总是以一个大写字母开始，接着跟随 0 个或任意个小写字母，表示原子的名字。 
//
// 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。 
//
// 
// 例如，"H2O" 和 "H2O2" 是可行的，但 "H1O2" 这个表达是不可行的。 
// 
//
// 两个化学式连在一起可以构成新的化学式。 
//
// 
// 例如 "H2O2He3Mg4" 也是化学式。 
// 
//
// 由括号括起的化学式并佐以数字（可选择性添加）也是化学式。 
//
// 
// 例如 "(H2O2)" 和 "(H2O2)3" 是化学式。 
// 
//
// 返回所有原子的数量，格式为：第一个（按字典序）原子的名字，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于
// 1），以此类推。 
//
// 
//
// 示例 1： 
//
// 
//输入：formula = "H2O"
//输出："H2O"
//解释：原子的数量是 {'H': 2, 'O': 1}。
// 
//
// 示例 2： 
//
// 
//输入：formula = "Mg(OH)2"
//输出："H2MgO2"
//解释：原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
// 
//
// 示例 3： 
//
// 
//输入：formula = "K4(ON(SO3)2)2"
//输出："K4N2O14S4"
//解释：原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
// 
//
// 示例 4： 
//
// 
//输入：formula = "Be32"
//输出："Be32"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= formula.length <= 1000 
// formula 由英文字母、数字、'(' 和 ')' 组成 
// formula 总是有效的化学式 
// 输出的所有值总是在 32-bit 整数范围内 
// 
// Related Topics 栈 哈希表 字符串 排序 👍 234 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.*;

public class Q0726_NumberOfAtoms {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int i, n;
        String formula;

        public String countOfAtoms(String formula) {
            return stack(formula);
        }


        public String stack(String formula) {
            this.i = 0;
            this.n = formula.length();
            this.formula = formula;

            Deque<Map<String, Integer>> stack = new LinkedList<>();
            stack.push(new HashMap<>());
            while (i < n) {
                char ch = formula.charAt(i);
                if (ch == '(') {
                    i++;
                    // 将一个空的哈希表压入栈中，准备统计括号内的原子数量
                    stack.push(new HashMap<>());
                } else if (ch == ')') {
                    i++;
                    int num = parseNum(); // 括号右侧数字
                    Map<String, Integer> popMap = stack.pop(); // 弹出括号内的原子数量
                    Map<String, Integer> topMap = stack.peek();
                    for (Map.Entry<String, Integer> entry : popMap.entrySet()) {
                        String atom = entry.getKey();
                        int v = entry.getValue();
                        // 将括号内的原子数量乘上 num，加到上一层的原子数量中
                        topMap.put(atom,
                                topMap.getOrDefault(atom, 0) + v * num);
                    }
                } else {
                    String atom = parseAtom();
                    int num = parseNum();
                    Map<String, Integer> topMap = stack.peek();
                    // 统计原子数量
                    topMap.put(atom, topMap.getOrDefault(atom, 0) + num);
                }
            }

            Map<String, Integer> map = stack.pop();
            TreeMap<String, Integer> treeMap = new TreeMap<>(map);

            StringBuffer sb = new StringBuffer();
            for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
                String atom = entry.getKey();
                int count = entry.getValue();
                sb.append(atom);
                if (count > 1) {
                    sb.append(count);
                }
            }
            return sb.toString();
        }

        public String parseAtom() {
            StringBuffer sb = new StringBuffer();
            sb.append(formula.charAt(i++)); // 扫描首字母
            while (i < n && Character.isLowerCase(formula.charAt(i))) {
                sb.append(formula.charAt(i++)); // 扫描首字母后的小写字母
            }
            return sb.toString();
        }

        public int parseNum() {
            if (i == n || !Character.isDigit(formula.charAt(i))) {
                // 不是数字，视作 1
                return 1;
            }
            int num = 0;
            while (i < n && Character.isDigit(formula.charAt(i))) {
                num = num * 10 + formula.charAt(i++) - '0'; // 扫描数字
            }
            return num;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
