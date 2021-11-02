//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 
// 👍 2054 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.bean.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class Q0206_ReverseLinkedList {

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
        public ListNode reverseList(ListNode head) {
            // 特判
            if (head == null || head.next == null) {
                return head;
            }

            // 栈
//            return stack(head);

            // 双指针
//            return doublePoint(head);

            // 迭代
//            return recur(head, null);

            // 头插法
            return headInsert(head);
        }

        public ListNode headInsert(ListNode head) {
            ListNode headNew = new ListNode(-1);
            headNew.next = head;
            ListNode last = head;
            while (head != null) {
                ListNode next = head.next;
                //头插法
                head.next = headNew.next;
                headNew.next = head;
                head = next;
            }
            last.next = null;
            return headNew.next;
        }

        public ListNode recur(ListNode cur, ListNode pre) {
            if (cur == null) {
                return pre;
            }
            ListNode res = recur(cur.next, cur);
            cur.next = pre;
            return res;
        }

        public ListNode doublePoint(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = head.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

        public ListNode stack(ListNode head) {
            Deque<ListNode> stack = new LinkedList<>();
            while (head != null) {
                stack.push(head);
                head = head.next;
            }
            ListNode node = stack.pop();
            head = node;
            while (!stack.isEmpty()) {
                node.next = stack.pop();
                node = node.next;
            }
            node.next = null;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}