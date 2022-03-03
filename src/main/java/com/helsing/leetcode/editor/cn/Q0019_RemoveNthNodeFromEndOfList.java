//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1626 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.common.bean.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q0019_RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        solution.removeNthFromEnd(node, 2);
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 栈
//            return stack(head, n);

            // 数组
//            return array(head, n);

            // 双指针 先后指针
            return twoPointersWithPreAndCur(head, n);
        }

        public ListNode twoPointersWithPreAndCur(ListNode head, int n) {
            ListNode dummyNode = new ListNode(0);//定义虚拟头节点，避免分类讨论
            dummyNode.next = head;
            ListNode pre = dummyNode;
            ListNode cur = head;
            int cnt = 0;
            while (cur != null) {
                //大于等于n的时候同时移动
                if (cnt >= n) {
                    pre = pre.next;
                }
                cur = cur.next;
                cnt++;
            }
            // 删除倒数第K个节点
            pre.next = pre.next.next;
            return dummyNode.next;
        }

        public ListNode stack(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            Deque<ListNode> stack = new LinkedList<>();
            ListNode cur = dummy;
            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }
            for (int i = 0; i < n; ++i) {
                stack.pop();
            }
            ListNode prev = stack.peek();
            prev.next = prev.next.next;
            ListNode ans = dummy.next;
            return ans;
        }

        public ListNode array(ListNode head, int n) {
            ListNode node = head;
            List<ListNode> list = new ArrayList<>();
            list.add(node);
            while (node.next != null) {
                node = node.next;
                list.add(node);
            }
            int size = list.size();
            int index = size - n;
            // 如果只有一个元素 或者 删到了第一个
            if (size == 1) {
                return null;
            }
            if (size == n) {
                return list.get(1);
            }
            // 如果删除的是最后一个元素
            if (n == 1) {
                list.get(index - 1).next = null;
            } else {
                list.get(index - 1).next = list.get(index + 1);
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}