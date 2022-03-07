//给你单链表的头指针 head 和两个整数 left 和 right ，
// 其中 left <= right 。请你反转从位置 left 到位置 right 的链
// 表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 👍 1172 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.common.bean.ListNode;

public class Q0092_ReverseLinkedListIi {

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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // 头插法
            return dummy(head, left, right);

            // 迭代

//            // 递归
//            if (left == 1) {
//                return recur(head, right);
//            }
//            // 前进到反转的起点触发 base case
//            head.next = reverseBetween(head.next, left - 1, right - 1);
//            return head;
        }

        private ListNode dummy(ListNode head, int left, int right) {
            ListNode dummyNode = new ListNode(-1);
            dummyNode.next = head;
            ListNode pre = dummyNode;
            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }
            ListNode cur = pre.next;
            ListNode next;
            for (int i = 0; i < right - left; i++) {
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            return dummyNode.next;
        }

        ListNode successor = null; // 后驱节点

        public ListNode recur(ListNode head, int n) {
            if (n == 1) {
                successor = head.next;
                return head;
            }
            ListNode last = recur(head.next, n - 1);

            head.next.next = head;
            head.next = successor;
            return last;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
