//给定一个 每个结点的值互不相同 的二叉树，和一个目标整数值 k，
// 返回树中与目标值 k 最近的叶结点 。
//
// 与叶结点最近 表示在二叉树中到达该叶节点需要行进的边数与到达其它叶结点相比最少
// 。而且，当一个结点没有孩子结点时称其为叶结点。
//
// 示例 1： 
//
//
//输入：root = [1, 3, 2], k = 1
//输出： 2
//解释： 2 和 3 都是距离目标 1 最近的叶节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1], k = 1
//输出：1
//解释：最近的叶节点是根结点自身。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [1,2,3,4,null,null,null,5,null,6], k = 2
//输出：3
//解释：值为 3（而不是值为 6）的叶节点是距离结点 2 的最近结点。
// 
//
// 
//
// 提示： 
//
// 
// 二叉树节点数在 [1, 1000] 范围内 
// 1 <= Node.val <= 1000 
// 每个节点值都 不同 
// 给定的二叉树中有某个结点使得 node.val == k 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 86 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.common.bean.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q0742_ClosestLeafInABinaryTree {

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
        static List<int[]> memo;
        static Set<Integer> leafNode;

        public int findClosestLeaf(TreeNode root, int k) {
            List<Integer>[] graph = new List[1001];
            boolean[] visited = new boolean[1001];
            memo = new ArrayList<>();
            leafNode = new HashSet<>();
            preOrder(root);

            // 绘制图
            for (int i = 0; i <= 1000; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] item : memo) {
                graph[item[0]].add(item[1]);
                graph[item[1]].add(item[0]);
            }

            // 广度优先遍历,找最近的叶子节点
            List<Integer> list = new ArrayList<>();
            list.add(k);
            while (!list.isEmpty()) {
                List<Integer> temp = new ArrayList<>();
                for (int item : list) {
                    // 访问没有访问过的点
                    if (!visited[item]) {
                        if (leafNode.contains(item)) return item;
                        temp.addAll(graph[item]);
                        visited[item] = true;
                    }
                }
                list = temp;
            }
            return -1;
        }

        // 前序遍历获取边
        public void preOrder(TreeNode root) {
            if (root == null) return;
            // 获取叶子节点
            if (root.left == null && root.right == null) {
                leafNode.add(root.val);
                return;
            }
            if (root.left != null) {
                memo.add(new int[]{root.val, root.left.val});
            }
            if (root.right != null) {
                memo.add(new int[]{root.val, root.right.val});
            }
            preOrder(root.left);
            preOrder(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
