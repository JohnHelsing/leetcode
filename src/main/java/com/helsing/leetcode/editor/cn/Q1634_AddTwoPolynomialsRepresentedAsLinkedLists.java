//多项式链表是一种特殊形式的链表，每个节点表示多项式的一项。 
//
// 每个节点有三个属性： 
//
// 
// coefficient：该项的系数。项 9x4 的系数是 9 。 
// power：该项的指数。项 9x4 的指数是 4 。 
// next：指向下一个节点的指针（引用），如果当前节点为链表的最后一个节点则为 null 。 
// 
//
// 例如，多项式 5x3 + 4x - 7 可以表示成如下图所示的多项式链表： 
//
// 
//
// 多项式链表必须是标准形式的，即多项式必须 严格 按指数 power 的递减顺序排列（即降幂排列）。另外，系数 coefficient 为 0 的项需要省略
//。 
//
// 给定两个多项式链表的头节点 poly1 和 poly2，返回它们的和的头节点。 
//
// PolyNode 格式： 
//
// 输入/输出格式表示为 n 个节点的列表，其中每个节点表示为 [coefficient, power] 。例如，多项式 5x3 + 4x - 7 表示为： 
//[[5,3],[4,1],[-7,0]] 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：poly1 = [[1,1]], poly2 = [[1,0]]
//输出：[[1,1],[1,0]]
//解释：poly1 = x. poly2 = 1. 和为 x + 1.
// 
//
// 示例 2： 
//
// 
//输入：poly1 = [[2,2],[4,1],[3,0]], poly2 = [[3,2],[-4,1],[-1,0]]
//输出：[[5,2],[2,0]]
//解释：poly1 = 2x2 + 4x + 3. poly2 = 3x2 - 4x - 1. 和为 5x2 + 2. 注意，我们省略 "0x" 项。
// 
//
// 示例 3： 
//
// 
//输入：poly1 = [[1,2]], poly2 = [[-1,2]]
//输出：[]
//解释：和为 0。我们返回空链表。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 104 
// -109 <= PolyNode.coefficient <= 109 
// PolyNode.coefficient != 0 
// 0 <= PolyNode.power <= 109 
// PolyNode.power > PolyNode.next.power 
// 
// Related Topics 链表 数学 双指针 
// 👍 4 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.common.bean.PolyNode;

public class Q1634_AddTwoPolynomialsRepresentedAsLinkedLists {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 *     int coefficient, power;
 *     PolyNode next = null;
 *     PolyNode() {}
 *     PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 *     PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
 * }
 */

    class Solution {
        public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
            if (poly1 == null) {
                return poly2;
            }
            if (poly2 == null) {
                return poly1;
            }
            // 双指针
            return twoPointers(poly1, poly2);
        }

        public PolyNode twoPointers(PolyNode poly1, PolyNode poly2) {
            // 伪头结点
            PolyNode dummyNode = new PolyNode(0, 0);
            PolyNode cur = dummyNode;
            PolyNode cur1 = poly1, cur2 = poly2;
            while (cur1 != null && cur2 != null) {
                if (cur1.power > cur2.power) {
                    cur.next = new PolyNode(cur1.coefficient, cur1.power);
                    cur1 = cur1.next;
                } else if (cur1.power < cur2.power) {
                    cur.next = new PolyNode(cur2.coefficient, cur2.power);
                    cur2 = cur2.next;
                } else {
                    int num = cur1.coefficient + cur2.coefficient;
                    if (num != 0) {
                        cur.next = new PolyNode(num, cur1.power);
                        cur1 = cur1.next;
                        cur2 = cur2.next;
                    } else {
                        cur1 = cur1.next;
                        cur2 = cur2.next;
                        continue;
                    }

                }
                cur = cur.next;
            }
            if (cur1 != null) {
                cur.next = cur1;
            }
            if (cur2 != null) {
                cur.next = cur2;
            }
            return dummyNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}