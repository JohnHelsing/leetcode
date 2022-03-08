package com.helsing.leetcode.note.structure.stack;

import com.helsing.leetcode.common.bean.TreeNode;
import com.helsing.leetcode.editor.cn.Q0316_RemoveDuplicateLetters;
import com.helsing.leetcode.editor.cn.Q1081_SmallestSubsequenceOfDistinctCharacters;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈
 * 一般在java中用栈的话，都用deque来做
 * <p>
 * 有的时候打开思路，栈里不要只放目标内容，可以放一些下标等辅助内容
 *
 * @author HelSing
 * @date 2021/11/9
 */
public class Struct_Stack {

    public static void main(String[] args) {
        Deque<Integer> stack;
        /**
         * 链表实现
         * 每次push都需要new Node节点，并且node节点里面有prev和next成员，也会有额外的空间占用。
         */
        stack = new LinkedList<>();

        /**
         * 数组实现
         * 当用作栈的实现时候，性能更好一点。
         */
        stack = new ArrayDeque<>();

        /**
         * 核心三个方法 push/pop/peek
         * push 入栈
         * pop  出栈
         * peek 获取栈顶元素
         */
        stack.push(1);
        stack.pop();
        stack.peek();

        /**
         * 其他辅助方法 isEmpty/size/clear
         * isEmpty 判空
         * size    长度
         * clear   清空
         */
        stack.isEmpty();
        stack.size();
        stack.clear();
    }

    public void algorithm() {

    }

    /**
     * 用于二叉树的遍历 前序 中序
     */
    public void proOrInTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                // 前序遍历 preorderTraversal
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 中序遍历 inorderTraversal
            root = root.right;
        }
    }

    /**
     * 用于二叉树的遍历 后序
     */
    public void travelsal(TreeNode root) {
        TreeNode prev = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                // 后序遍历 postorderTraversal
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
    }

    public void etc() {
        // 去除重复字母
        Q0316_RemoveDuplicateLetters.main(null);
        Q1081_SmallestSubsequenceOfDistinctCharacters.main(null);
    }

}
