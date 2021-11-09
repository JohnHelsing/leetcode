//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics 链表 双指针 
// 👍 472 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.bean.ListNode;

public class Q0086_PartitionList {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    class Solution {
        public ListNode partition(ListNode head, int x) {
            // 特判
            if (head == null) {
                return null;
            }

            // 插入排序
//            return insertSort(head, x);

            // 双指针 快慢(读写)指针
            return twoPointersWithFastAndSlow(head, x);
        }

        public ListNode twoPointersWithFastAndSlow(ListNode head, int x) {
            ListNode slow = new ListNode(0);
            ListNode p = slow, fast = head.next;
            slow.next = head;
            while (fast != null) {
                if (slow.next.val < x) {
                    slow = slow.next;
                    head = fast;
                } else if (fast.val < x) {
                    head.next = fast.next;
                    fast.next = slow.next;
                    slow = slow.next = fast;
                } else {
                    head = fast;
                }
                fast = head.next;
            }
            return p.next;
        }

        public ListNode insertSort(ListNode head, int x) {
            ListNode small = new ListNode(0);
            ListNode smallHead = small;
            ListNode large = new ListNode(0);
            ListNode largeHead = large;
            while (head != null) {
                if (head.val < x) {
                    small.next = head;
                    small = small.next;
                } else {
                    large.next = head;
                    large = large.next;
                }
                head = head.next;
            }
            large.next = null;
            small.next = largeHead.next;
            return smallHead.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}