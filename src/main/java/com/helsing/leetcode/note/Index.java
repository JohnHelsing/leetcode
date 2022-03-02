package com.helsing.leetcode.note;

import com.helsing.leetcode.common.bean.ListNode;

/**
 * 综述
 *
 * @author HelSing
 * @date 2022/3/2
 */
public class Index {

    /**
     * 核心
     */
    private void important() {
        /**
         * 一切数据结构的物理基础结构就两种
         * 数组
         * 链表
         */

        /**
         * 数据结构，主要目的：增删改查
         * 遍历 + 访问
         * 线性就是 for/while 迭代为代表
         * 非线性就是递归为代表
         */

        // 数组遍历框架，典型的线性迭代结构：
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            // 迭代访问 arr[i]
        }

        // 链表遍历框架，兼具迭代和递归结构：
        ListNode head = new ListNode();
        for (ListNode p = head; p != null; p = p.next) {
            // 迭代访问 p.val
        }
        // void traverse(ListNode head) {
        // 递归访问 head.val
        //    traverse(head.next);
        // }

        // 二叉树遍历框架，典型的非线性递归遍历结构：
        // void traverse(TreeNode root) {
        // 前序遍历
        //    traverse(root.left);
        // 中序遍历
        //    traverse(root.right);
        // 后序遍历
        //}

        // N叉树遍历框架，典型的非线性递归遍历结构：
        // void traverse(TreeNode root) {
        //    for (TreeNode child : root.children){
        //      traverse(child);
        //    }
        //}

        // 图的遍历，类似于N叉树，只不过要加上visited做标识
    }

    /**
     * 先刷树
     */
    private void tree() {
        /**
         * 很多算法内容都可以总结为
         * 数的前序中序后序遍历
         */
    }

    /**
     * 算法的本质
     * 穷举
     */
    private void nature() {
        /**
         * 穷举要保证
         * 1. 无遗漏
         * 2. 无冗余
         */
    }

    /**
     * 举例
     */
    private void etc() {
        // 一. 数组/单链表系列算法
        // 1. 单链表常考的技巧就是双指针
        // 2. 二分搜索技巧
        // 3. 滑动窗口算法技巧
        // 4. 回文串相关技巧(马拉车算法（Manacher 算法）)
        // 5. 前缀和
        // 6. 差分数组

        // 二. 二叉树系列算法
        // 1. 回溯算法（DFS）
        // 2. 动态规划
        // 3. 分治算法
        // 4. BFS

        // 三. 图论
        // 1. Dijkstra 算法
        // 2. Tarjan算法
    }
}
