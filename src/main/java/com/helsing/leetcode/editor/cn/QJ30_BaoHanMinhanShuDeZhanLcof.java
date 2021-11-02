//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。 
//
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// 各函数的调用总次数不超过 20000 次 
// 
//
// 
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/ 
// Related Topics 栈 设计 
// 👍 215 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class QJ30_BaoHanMinhanShuDeZhanLcof {

    public static void main(String[] args) {
        MinStack solution = new MinStack();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        Deque<Integer> stack;
        Deque<Integer> stackMin;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new LinkedList<>();
            stackMin = new LinkedList<>();
        }

        public void push(int val) {
            stack.push(val);
            if (stackMin.isEmpty() || stackMin.peek() >= val) {
                stackMin.push(val);
            }
        }

        public void pop() {
            int val = stack.pop();
            if (!stackMin.isEmpty() && val == stackMin.peek()) {
                stackMin.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return stackMin.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

}