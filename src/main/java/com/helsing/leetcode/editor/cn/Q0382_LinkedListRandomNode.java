//给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。 
//
// 进阶: 
//如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？ 
//
// 示例: 
//
// 
//// 初始化一个单链表 [1,2,3].
//ListNode head = new ListNode(1);
//head.next = new ListNode(2);
//head.next.next = new ListNode(3);
//Solution solution = new Solution(head);
//
//// getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
//solution.getRandom();
// 
// Related Topics 水塘抽样 链表 数学 随机化 
// 👍 164 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.bean.ListNode;

import java.util.Random;

public class Q0382_LinkedListRandomNode {

    public static void main(String[] args) {
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
        ListNode head;
        Random random;

        public Solution(ListNode head) {
            this.head = head;
            this.random = new Random();
        }

        public int getRandom() {
            // 蓄水池算法
            int reserve = 0;
            ListNode cur = head;
            int count = 0;
            while (cur != null) {
                count++;
                int r = this.random.nextInt(count) + 1;
                if (r == count) {
                    reserve = cur.val;
                }
                cur = cur.next;
            }
            return reserve;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}