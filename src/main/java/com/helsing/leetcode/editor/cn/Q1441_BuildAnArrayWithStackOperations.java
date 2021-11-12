//给你一个目标数组 target 和一个整数 n。每次迭代，需要从 list = {1,2,3..., n} 中依序读取一个数字。 
//
// 请使用下述操作来构建目标数组 target ： 
//
// 
// Push：从 list 中读取一个新元素， 并将其推入数组中。 
// Pop：删除数组中的最后一个元素。 
// 如果目标数组构建完成，就停止读取更多元素。 
// 
//
// 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。 
//
// 请返回构建目标数组所用的操作序列。 
//
// 题目数据保证答案是唯一的。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = [1,3], n = 3
//输出：["Push","Push","Pop","Push"]
//解释： 
//读取 1 并自动推入数组 -> [1]
//读取 2 并自动推入数组，然后删除它 -> [1]
//读取 3 并自动推入数组 -> [1,3]
// 
//
// 示例 2： 
//
// 
//输入：target = [1,2,3], n = 3
//输出：["Push","Push","Push"]
// 
//
// 示例 3： 
//
// 
//输入：target = [1,2], n = 4
//输出：["Push","Push"]
//解释：只需要读取前 2 个数字就可以停止。
// 
//
// 示例 4： 
//
// 
//输入：target = [2,3,4], n = 4
//输出：["Push","Pop","Push","Push","Push"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target.length <= 100 
// 1 <= target[i] <= 100 
// 1 <= n <= 100 
// target 是严格递增的 
// 
// Related Topics 栈 数组 模拟 
// 👍 27 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q1441_BuildAnArrayWithStackOperations {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> buildArray(int[] target, int n) {
            // 双栈
//            return stack(target, n);

            // 单词循环
            return fori(target, n);
        }

        public List<String> fori(int[] target, int n) {
            List<String> result = new ArrayList<>(n);
            for (int i = 0, num = 1; i < target.length; i++, num++) {
                result.add("Push");
                if (target[i] != num) {
                    result.add("Pop");
                    i--;
                }
            }
            return result;
        }

        public List<String> stack(int[] target, int n) {
            List<String> ans = new ArrayList<>();
            Deque<Integer> stack = new ArrayDeque<>();

            // num是产生的数字，index 是 target 数组的下标
            for (int num = 1, index = 0; num <= n && index < target.length; ++num) {
                // 不管是否符合要求，先把数和操作放进来
                stack.add(num);
                ans.add("Push");
                // 检查一下是否符合要求，如果不符合，那么就把栈顶元素弹出来，然后再加入Pop操作
                if (target[index] != stack.peek()) {
                    stack.pop();
                    ans.add("Pop");
                } else {
                    index++; // 符合要求的话，就把游标往右移动一个
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}