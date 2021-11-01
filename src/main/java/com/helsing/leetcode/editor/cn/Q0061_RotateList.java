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

import com.helsing.leetcode.bean.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Q0061_RotateList {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rotateRight(new ListNode(1, new ListNode(2)),2);
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
            if (head == null) {
                return null;
            }

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
            list.get(list.size() - k-1).next = null;
            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}