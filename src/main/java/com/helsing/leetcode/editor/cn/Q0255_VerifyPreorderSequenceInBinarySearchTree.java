//给定一个整数数组，你需要验证它是否是一个二叉搜索树正确的先序遍历序列。 
//
// 你可以假定该序列中的数都是不相同的。 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [5,2,6,1,3]
//输出: false 
//
// 示例 2： 
//
// 输入: [5,2,1,3,6]
//输出: true 
//
// 进阶挑战： 
//
// 您能否使用恒定的空间复杂度来完成此题？ 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 
// 👍 127 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0255_VerifyPreorderSequenceInBinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPreorder(int[] preorder) {
            // 单调栈
            return stackMonotone(preorder);
        }

        public boolean stackMonotone(int[] preorder) {
            // 用单调栈的方式，递减栈，当碰到一个数比栈顶元素大的时候，说明从左子树到了右子树。
            // 此时要删掉左子树的所有节点，并且保留子树的根为最小值，此时遍历的所有右子树的节点都必须大于这个根，否则非法
            int len = preorder.length;
            int[] stack = new int[len];
            int top = -1;
            int min = Integer.MIN_VALUE;
            for (int value : preorder) {
                if (value < min) {
                    return false;
                }
                while (top > -1 && value > stack[top]) {
                    min = stack[top];
                    top--;
                }
                stack[++top] = value;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}