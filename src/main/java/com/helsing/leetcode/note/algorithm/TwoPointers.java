package com.helsing.leetcode.note.algorithm;

import com.helsing.leetcode.common.bean.ListNode;

/**
 * 双指针算法
 * 双指针一般包括左右指针，快慢指针等
 * 常用在链表、二分等算法题中
 *
 * @author HelSing
 * @date 2021/11/9
 */
public class TwoPointers {


    /**
     * 左右双指针
     */
    public void leftAndRight(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            boolean leftCondition = false, rightCondition = false;
            if (leftCondition) {
                left++;
            }
            if (rightCondition) {
                right--;
            }
        }
    }

    /**
     * 先后双指针
     * 找倒数第N个之类的
     */
    public void preAndCur(ListNode head) {
        // 定义哑结点
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = head;
        while (cur != null) {
            // 满足某个条件时同时移动
            boolean someCondition = false;
            if (someCondition) {
                pre = pre.next;
            }
            // 否则前指针先移动
            cur = cur.next;
        }
        // 便于理解还可以分两次循环
        // for(someCondition){cur++}
        // for(someCondition){pre++}
    }

    /**
     * 快慢指针
     * 读写双指针，找环之类的
     *
     * @param nums
     */
    public void fastAndSlow(int[] nums) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            // 满足某个条件时，慢指针才移动
            boolean someCondition = false;
            if (someCondition) {
                slow++;
            }
            fast++;
        }
    }

    /**
     * 滑动窗口
     */
    public void slideWindow() {

    }
}
