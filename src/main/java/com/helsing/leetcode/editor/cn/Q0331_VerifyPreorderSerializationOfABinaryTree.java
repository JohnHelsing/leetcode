//序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。 
//
//      _9_
//    /   \
//   3     2
//  / \   / \
// 4   1  #  6
/// \ / \   / \
//# # # #   # #
// 
//
// 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。 
//
// 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。 
//
// 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。 
//
// 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。 
//
// 示例 1: 
//
// 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
//输出: true 
//
// 示例 2: 
//
// 输入: "1,#"
//输出: false
// 
//
// 示例 3: 
//
// 输入: "9,#,#,1"
//输出: false 
// Related Topics 栈 树 字符串 二叉树 
// 👍 348 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0331_VerifyPreorderSerializationOfABinaryTree {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSerialization(String preorder) {
            // 栈
//            return stack(preorder);

            // 栈的优化
            return stackWithOpt(preorder);
        }

        public boolean stackWithOpt(String preorder) {
            // 如果把栈中元素看成一个整体，即所有剩余槽位的数量，也能维护槽位的变化。
            // 因此，我们可以只维护一个计数器，代表栈中所有元素之和，其余的操作逻辑均可以保持不变。
            int n = preorder.length();
            int i = 0;
            int slots = 1;
            while (i < n) {
                if (slots == 0) {
                    return false;
                }
                if (preorder.charAt(i) == ',') {
                    i++;
                } else if (preorder.charAt(i) == '#') {
                    slots--;
                    i++;
                } else {
                    // 读一个数字
                    while (i < n && preorder.charAt(i) != ',') {
                        i++;
                    }
                    slots++; // slots = slots - 1 + 2
                }
            }
            return slots == 0;
        }

        public boolean stack(String preorder) {
            int n = preorder.length();
            int i = 0;
            // 栈中的每个元素，代表了对应节点处剩余槽位的数量
            // 而栈顶元素就对应着下一步可用的槽位数量。
            // 当遇到空节点时，仅将栈顶元素减 11；当遇到非空节点时，将栈顶元素减 11 后，再向栈中压入一个 22。
            // 无论何时，如果栈顶元素变为 00，就立刻将栈顶弹出。
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(1);
            while (i < n) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (preorder.charAt(i) == ',') {
                    i++;
                } else if (preorder.charAt(i) == '#') {
                    int top = stack.pop() - 1;
                    if (top > 0) {
                        stack.push(top);
                    }
                    i++;
                } else {
                    // 读一个数字
                    while (i < n && preorder.charAt(i) != ',') {
                        i++;
                    }
                    int top = stack.pop() - 1;
                    if (top > 0) {
                        stack.push(top);
                    }
                    stack.push(2);
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
