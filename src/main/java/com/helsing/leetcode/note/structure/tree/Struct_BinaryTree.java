package com.helsing.leetcode.note.structure.tree;

import com.helsing.leetcode.common.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树
 * <p>
 * 二叉树题目的递归解法可以分两类思路，
 * 第一类是遍历一遍二叉树得出答案，
 * 第二类是通过分解问题计算出答案，
 * <p>
 * 这两类思路分别对应着 回溯算法核心框架 和 动态规划核心框架。
 * <p>
 * 是否可以通过遍历一遍二叉树得到答案？
 * 如果不能的话，是否可以定义一个递归函数，通过子问题（子树）的答案推导出原问题的答案？
 *
 * @author HelSing
 * @date 2022/3/2
 */
public class Struct_BinaryTree {

    /**
     * 前中后序遍历
     * <p>
     * 但这里面大有玄妙，意味着前序位置的代码只能从函数参数中获取父节点传递来的数据，
     * 而后序位置的代码不仅可以获取参数数据，还可以获取到子树通过函数返回值传递回来的数据。
     *
     * @param root
     */
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        traverse(root.left);
        // 中序位置
        traverse(root.right);
        // 后序位置
    }

    /**
     * 层序遍历
     *
     * @param root
     */
    void levelTraverse(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // 从上到下遍历二叉树的每一层
        while (!q.isEmpty()) {
            int sz = q.size();
            // 从左到右遍历每一层的每个节点
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // 将下一层节点放入队列
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        int ans = maxDepth(root);
        System.out.println(ans);
    }

    // 定义：输入根节点，返回这棵二叉树的最大深度
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 利用定义，计算左右子树的最大深度
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 整棵树的最大深度等于左右子树的最大深度取最大值，
        // 然后再加上根节点自己
        return Math.max(leftMax, rightMax) + 1;
    }
}
