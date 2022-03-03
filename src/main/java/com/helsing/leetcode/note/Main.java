package com.helsing.leetcode.note;

import com.helsing.leetcode.common.bean.ListNode;
import com.helsing.leetcode.note.algorithm.*;
import com.helsing.leetcode.note.structure.array.Struct_Array;
import com.helsing.leetcode.note.structure.graph.Struct_Graph;
import com.helsing.leetcode.note.structure.hash.Struct_Hash;
import com.helsing.leetcode.note.structure.heap.Struct_Heap;
import com.helsing.leetcode.note.structure.linkedlist.Struct_LinkedList;
import com.helsing.leetcode.note.structure.que.Struct_Queue;
import com.helsing.leetcode.note.structure.stack.Struct_Stack;
import com.helsing.leetcode.note.structure.tree.Struct_Tree;
import com.helsing.leetcode.note.structure.unionfind.Struct_UnionFind;

/**
 * 综述
 *
 * @author HelSing
 * @date 2022/3/2
 */
public class Main {

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

        /**
         * 先刷树
         *
         * 很多算法内容都可以总结为
         * 数的前序中序后序遍历
         */

        /**
         * 算法的本质
         * 穷举
         *
         * 穷举要保证
         * 1. 无遗漏
         * 2. 无冗余
         */
    }

    /**
     * 算法
     */
    private void algorithm() {
        // 一. 数组/单链表系列算法
        // 1. 双指针
        TwoPointers.main(null);
        // 2. 二分查找技巧
        BinaryFind.main(null);
        // 3. 滑动窗口算法技巧

        // 4. 回文串相关技巧(马拉车算法（Manacher 算法）)

        // 5. 前缀和

        // 6. 差分数组

        // 二. 二叉树系列算法
        // 1. BFS
        BFS.main(null);
        // 2. DFS
        DFS.main(null);
        // 3. 回溯算法
        Backtracking.main(null);
        // 4. 动态规划
        DP.main(null);
        // 5. 分治算法
        DivideAndConquer.main(null);

        // 三. 图论
        // 1. Dijkstra 算法

        // 2. Tarjan算法

        // 四. 其他
        // 1. LRU
        LFU.main(null);
        // 2. LFU
        LRU.main(null);

    }

    /**
     * 数据结构
     */
    private void structure() {
        // 一。数组(一维数组、矩阵、树状数组)
        Struct_Array.main(null);
        // 二。链表(单向链表、双向链表)
        Struct_LinkedList.main(null);
        // 三。队列(单向队列、双向队列)
        Struct_Queue.main(null);
        // 四。栈(栈、单调栈)
        Struct_Stack.main(null);
        // 五。树(前缀树、二叉树、二叉搜索树、红黑树、后缀树、k-d树)
        Struct_Tree.main(null);
        // 七。并查集
        Struct_UnionFind.main(null);
        // 八。图
        Struct_Graph.main(null);
        // 九。堆
        Struct_Heap.main(null);
        // 十。散列
        Struct_Hash.main(null);
    }

    /**
     * 设计
     */
    private void design() {
        // LRU

        // LFU
    }
}
