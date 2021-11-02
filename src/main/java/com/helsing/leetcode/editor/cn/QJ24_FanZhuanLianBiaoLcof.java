//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 递归 链表 
// 👍 324 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.bean.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class QJ24_FanZhuanLianBiaoLcof {

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
 *     ListNode(int x) { val = x; }
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