//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 105] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 
// 👍 1162 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.bean.ListNode;

public class Q0234_PalindromeLinkedList {

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
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            return twoPointersFastAndSlow(head);
        }

        public boolean twoPointersFastAndSlow(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            ListNode prev = null;
            // 快慢指针，并同时反转链表前半部分
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                // 反转
                ListNode nextNode = slow.next;
                slow.next = prev;
                prev = slow;
                slow = nextNode;
            }
            ListNode prepre = slow;
            if (fast != null) {
                slow = slow.next;
            }
            // 比较值并反转还原前半部分
            boolean isPalindrome = true;
            while (prev != null) {
                if (slow.val != prev.val) {
                    isPalindrome = false;
                }
                slow = slow.next;
                // 前半部分再次反转
                ListNode nextNode = prev.next;
                prev.next = prepre;
                prepre = prev;
                prev = nextNode;
            }
            return isPalindrome;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}