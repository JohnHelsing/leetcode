//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1135 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.common.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q0104_MaximumDepthOfBinaryTree {

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
        public int maxDepth(TreeNode root) {
//            return dfs(root);
            // 迭代 ，广度搜索
            return bfs(root);
        }

        private int bfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int ans = 0;
            Queue<TreeNode> que = new LinkedList<>();
            que.offer(root);
            while (!que.isEmpty()) {
                int size = que.size();
                while (size > 0) {
                    TreeNode node = que.poll();
                    if (node.left != null) {
                        que.offer(node.left);
                    }
                    if (node.right != null) {
                        que.offer(node.right);
                    }
                    size--;
                }
                ans++;
            }
            return ans;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(dfs(root.left), dfs(root.right)) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
