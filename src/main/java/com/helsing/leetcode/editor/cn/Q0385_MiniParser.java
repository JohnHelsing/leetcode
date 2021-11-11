//给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。 
//
// 列表中的每个元素只可能是整数或整数嵌套列表 
//
// 提示：你可以假定这些字符串都是格式良好的： 
//
// 
// 字符串非空 
// 字符串不包含空格 
// 字符串只包含数字0-9、[、-、,、] 
// 
//
// 
//
// 示例 1： 
//
// 给定 s = "324",
//
//你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
// 
//
// 示例 2： 
//
// 给定 s = "[123,[456,[789]]]",
//
//返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
//
//1. 一个 integer 包含值 123
//2. 一个包含两个元素的嵌套列表：
//    i.  一个 integer 包含值 456
//    ii. 一个包含一个元素的嵌套列表
//         a. 一个 integer 包含值 789
// 
// Related Topics 栈 深度优先搜索 字符串 
// 👍 74 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.common.bean.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0385_MiniParser {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
    class Solution {
        public NestedInteger deserialize(String s) {
            // 双指针
//            return twoPointers(s);

            // 栈
            return stack(s);
        }

        public NestedInteger stack(String s) {
            Deque<NestedInteger> stack = new ArrayDeque<>();
            // 记录当前数字的字符串
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == '[') {
                    stack.push(new NestedInteger());
                } else if (c == ',') {
                    if (sb.length() != 0) {
                        // 说明是个数组，于是加到现在 NestedInteger里
                        stack.peek().add(new NestedInteger(Integer.parseInt(sb.toString())));
                        sb.setLength(0);
                    }
                } else if (c == ']') {
                    // 说明一个nestInteger已组成
                    if (sb.length() != 0) {
                        stack.peek().add(new NestedInteger(Integer.parseInt(sb.toString())));
                        sb.setLength(0);
                    }
                    // 要考虑是否还要add到另外一个里，除非之前是空的（即size<=1），则不需要
                    if (stack.size() > 1) {
                        NestedInteger back = stack.peek();
                        stack.pop();
                        stack.peek().add(back);
                    }
                } else {
                    // 这里题目假设字符串都是正常的，那么剩下就是数字
                    sb.append(c);
                }
            }

            // 考虑边缘情况，没有结束]字符
            if (sb.length() != 0) {
                stack.push(new NestedInteger(Integer.parseInt(sb.toString())));
            }
            return stack.pop();
        }

        public NestedInteger twoPointers(String s) {
            if (s.length() == 0) {
                return new NestedInteger();
            }
            if (s.charAt(0) != '[') {
                return new NestedInteger(Integer.valueOf(s));
            }
            if (s.length() == 2) {
                return new NestedInteger();
            }

            NestedInteger ni = new NestedInteger();
            for (int start = 1, i = 1, count = 0; i < s.length(); i++) {
                // s[length - 1]肯定是]。 注意这个if要排第一，如果s.chartAt(i) == ']'排在这前面，会少执行一次add操作
                if (count == 0 && (s.charAt(i) == ',' || s.length() - 1 == i)) {
                    // 加入兄弟节点
                    ni.add(deserialize(s.substring(start, i)));
                    start = i + 1;
                } else if (s.charAt(i) == '[') {
                    count++;
                } else if (s.charAt(i) == ']') {
                    count--;
                }
            }
            return ni;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}