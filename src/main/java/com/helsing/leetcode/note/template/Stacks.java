package com.helsing.leetcode.note.template;

import com.helsing.leetcode.common.bean.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用栈解题模板
 *
 * @author HelSing
 * @date 2021/11/10
 */
public class Stacks {

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

}
