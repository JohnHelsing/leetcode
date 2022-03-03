package com.helsing.leetcode.note.structure.linkedlist;

import com.helsing.leetcode.editor.cn.*;

/**
 * 单链表
 * <p>
 * 常用双指针结题
 *
 * @author HelSing
 * @date 2022/3/2
 */
public class Struct_LinkedList {

    public static void main(String[] args) {

    }

    private void etc() {
        /**
         * 合并单链表
         * 递归解法：比较大小，返回结果
         * 双指针解法：虚拟头结点+双指针
         */
        Q0021_MergeTwoSortedLists.main(null);

        /**
         * 合并 k 个有序链表
         * 使用优先队列
         */
        Q0023_MergeKSortedLists.main(null);

        /**
         * 倒数第K个节点
         * 先后双指针
         */
        Q0019_RemoveNthNodeFromEndOfList.main(null);

        /**
         * 单链表的中点
         * 快慢双指针
         */
        Q0876_MiddleOfTheLinkedList.main(null);

        /**
         * 链表是否成环
         * 快慢双指针 判断中点的变种
         */
        Q0141_LinkedListCycle.main(null);

        /**
         * 链表环路起点
         * 快慢双指针， 先让快慢指针相遇
         * 然后头指针从头开始，与慢指针相同速度步进
         * 头指针与慢指针再次相遇的点就是入环点
         */
        Q0142_LinkedListCycleIi.main(null);

        /**
         * 两个链表是否相交
         * 只要是对的人，就算开始错过了，最终还是会再次相遇在一起的。
         */
        Q0160_IntersectionOfTwoLinkedLists.main(null);
    }
}
