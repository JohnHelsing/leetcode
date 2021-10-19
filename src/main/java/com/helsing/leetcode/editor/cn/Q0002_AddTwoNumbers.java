//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 6916 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0002_AddTwoNumbers {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(9, new ListNode(9));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode res = solution.addTwoNumbers(l1, l2);
        System.out.println(res.getVal());
        System.out.println(res.getNext().getVal());
        System.out.println(res.getNext().getNext().getVal());
        System.out.println(res.getNext().getNext().getNext().getVal());
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public ListNode getNext() {
            return next;
        }
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 模拟
//            return simulate(l1, l2);

            // 转换成数字
            return changeToNum(l1, l2);
        }

        public ListNode simulate(ListNode l1, ListNode l2) {
            ListNode head = null, tail = null;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int n1 = l1 != null ? l1.val : 0;
                int n2 = l2 != null ? l2.val : 0;
                int sum = n1 + n2 + carry;
                if (head == null) {
                    head = tail = new ListNode(sum % 10);
                } else {
                    tail.next = new ListNode(sum % 10);
                    tail = tail.next;
                }
                carry = sum / 10;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (carry > 0) {
                tail.next = new ListNode(carry);
            }
            return head;
        }

        public ListNode changeToNum(ListNode l1, ListNode l2) {
            int res = nodeToInt(l1) + nodeToInt(l2);
            ListNode resNode = null;
            int quo = res / 10;
            while (quo < 10) {
                int mod = res % 10;
                if(){

                }
                resNode
            }
        }

        public int nodeToInt(ListNode node) {

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}