//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。 
//
// 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 
//输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 
//输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 258 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.common.bean.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Q0993_CousinsInBinaryTree {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            return bfs(root, x, y);
        }

        private boolean bfs(TreeNode root, int x, int y) {
            Deque<TreeNode[]> q = new LinkedList<>();
            q.offer(new TreeNode[]{root, null});
            while (!q.isEmpty()) {
                int size = q.size();
                int fx = 0, fy = 0;
                TreeNode[] candidates = new TreeNode[2];
                for (int i = 0; i < size; i++) {
                    TreeNode[] nodes = q.poll();
                    TreeNode cur = nodes[0], parent = nodes[1];
                    if (cur.val == x) {
                        fx = 1;
                        candidates[0] = parent;
                    } else if (cur.val == y) {
                        fy = 1;
                        candidates[1] = parent;
                    }
                    if (cur.left != null) {
                        q.offer(new TreeNode[]{cur.left, cur});
                    }
                    if (cur.right != null) {
                        q.offer(new TreeNode[]{cur.right, cur});
                    }
                }
                if ((fx | fy) == 0) {
                    continue;
                }
                if ((fx ^ fy) == 1) {
                    return false;
                }
                if ((fx & fy) == 1) {
                    return candidates[0] != candidates[1];
                }
            }
            return false;
        }


        public static int[] mini(int[] a, int[] b, int[] c) {
            // 假设数据都是正序排的
            int[] ans = new int[10];
            int i = 0, k = 0, j = 0;
            for (int n = 0; n < 10; n++) {
                int min = a[i];
                if (min <= b[j] && b[j] <= c[k]) {
                    i++;
                } else if (b[j] <= min && b[j] <= c[k]) {
                    min = b[j];
                    j++;
                } else if (c[k] <= min && c[k] <= b[j]) {
                    min = c[k];
                    k++;
                }
                ans[n] = min;
            }
            return ans;
        }

        public static int[] solution(int n) {
            int size = n * (n + 1) / 2 + 2 * n;
            int[] ans = new int[size];
            for (int i = 1, index = 0; i <= n; i++) {
                ans[index++] = i;
                for (int j = 0; j < i; j++) {
                    ans[index++] = 0;
                }
                ans[index++] = i;
            }
            return ans;
        }

        public static void main(String[] args) {
            // 输入n，代表着
            // 10120023000344..nn的数组
            // 按照规则往每两个相同的数字之中添加指定数量的数字(全填0)
            int[] ans = solution(8);
            System.out.println(Arrays.toString(ans));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
