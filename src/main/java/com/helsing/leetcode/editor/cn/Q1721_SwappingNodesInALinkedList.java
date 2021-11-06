//给你链表的头节点 head 和一个整数 k 。 
//
// 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
//输出：[7,9,6,6,8,7,3,0,9,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：head = [1,2], k = 1
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：head = [1,2,3], k = 2
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目是 n 
// 1 <= k <= n <= 105 
// 0 <= Node.val <= 100 
// 
// Related Topics 链表 双指针 
// 👍 34 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.bean.ListNode;

public class Q1721_SwappingNodesInALinkedList {

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
        public ListNode swapNodes(ListNode head, int k) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;// 因为头结点可能会发生交换，所以要构造一个哑结点
            ListNode pre1 = dummy;// pre1指向第k个节点的前一个节点
            ListNode left = dummy.next;// 第k个节点
            ListNode pre2 = dummy;// pre2指向倒数第k个节点的前一个节点
            ListNode right = dummy.next;// 倒数第k个节点
            for (int i = 1; i < k; i++) {
                pre1 = pre1.next;
                left = left.next;
            }
            ListNode cur = left;
            ListNode temp = left.next;// 第k个节点的后一个节点
            while (cur.next != null) {
                pre2 = pre2.next;
                right = right.next;
                cur = cur.next;
            }
            if (right == pre1) {// 特殊情况，倒数第k个节点在第k个节点的左侧
                right.next = temp;
                left.next = right;
                pre2.next = left;
            } else {
                left.next = right.next;
                if (pre2 == left) {
                    right.next = left;
                }// 特殊情况，第k个节点在倒数第k个节点的左侧
                else {
                    pre2.next = left;
                    right.next = temp;
                }
                pre1.next = right;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}