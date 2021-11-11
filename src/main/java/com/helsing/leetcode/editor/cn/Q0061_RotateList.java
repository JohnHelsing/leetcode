//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 5 2 2
// 3 1 2
// 3 2 0
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 2
//输出：[1,2,0]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 646 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.common.bean.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Q0061_RotateList {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rotateRight(new ListNode(1, new ListNode(2)), 2);
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
        public ListNode rotateRight(ListNode head, int k) {
            // 特判
            if (head == null) {
                return null;
            }

            // 转换为数组
//            return array(head, k);

            // 双指针 快慢指针
            return twoPointersFastAndSlow(head, k);
        }

        public ListNode twoPointersFastAndSlow(ListNode head, int k) {
            ListNode temp = head;
            ListNode fast = head;
            ListNode slow = head;
            int len = 0;
            while (head != null) {
                head = head.next;
                len++;
            }
            if (k % len == 0) {
                return temp;
            }
            // 快指针先走k步
            while ((k % len) > 0) {
                k--;
                fast = fast.next;
            }
            // 慢指针和快指针一起走
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            // 快指针走到链表尾部时，慢指针刚好走到旋转链表（返回的链表）的尾部。
            ListNode res = slow.next;

            // 把快指针指向的节点连到原链表头部，慢指针指向的节点断开和下一节点的联系。
            slow.next = null;
            fast.next = temp;
            return res;
        }

        public ListNode array(ListNode head, int k) {
            List<ListNode> list = new ArrayList<>();
            ListNode node = head;
            list.add(node);
            while (node.next != null) {
                node = node.next;
                list.add(node);
            }
            if (k >= list.size()) {
                k = k % list.size();
            }
            if (k == 0 || head.next == null) {
                return head;
            }
            // 只是第0个变到了第k个 第n-k个变成了第0个
            ListNode newHead = list.get(list.size() - k);
            list.get(list.size() - 1).next = list.get(0);
            // 第n-k个做结尾
            list.get(list.size() - k - 1).next = null;
            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}