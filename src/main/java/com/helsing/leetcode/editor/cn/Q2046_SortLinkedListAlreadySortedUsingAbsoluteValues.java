//null Related Topics 链表 双指针 排序 
// 👍 0 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.common.bean.ListNode;

public class Q2046_SortLinkedListAlreadySortedUsingAbsoluteValues {

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
        public ListNode sortLinkedList(ListNode head) {
            // 头插法
            return headInsert(head);
        }

        public ListNode headInsert(ListNode head) {
            ListNode prev = head, curr = head.next;
            while (curr != null) {
                if (curr.val < 0) {
                    ListNode t = curr.next;
                    prev.next = t;
                    curr.next = head;
                    head = curr;
                    curr = t;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}