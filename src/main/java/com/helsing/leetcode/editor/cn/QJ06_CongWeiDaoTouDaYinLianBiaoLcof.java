//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 
// 👍 197 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.bean.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class QJ06_CongWeiDaoTouDaYinLianBiaoLcof {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        solution.reversePrint(head);
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
        public int[] reversePrint(ListNode head) {
            Deque<ListNode> stack = new LinkedList<>();
            ListNode node = head;
            while (node != null) {
                stack.push(node);
                node = node.next;
            }
            int[] ans = new int[stack.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = stack.pop().val;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}