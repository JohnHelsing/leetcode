//给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，
//并且每个节点没有左子节点，只有一个右子节点。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
//输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
// 
//
// 示例 2： 
//
// 
//输入：root = [5,1,7]
//输出：[1,null,5,null,7]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的取值范围是 [1, 100] 
// 0 <= Node.val <= 1000 
// 
// Related Topics 栈 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 247 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.common.bean.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q0897_IncreasingOrderSearchTree {

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

        public TreeNode increasingBST(TreeNode root) {
            // 迭代 中序遍历
            return stack(root);
        }

        public TreeNode stack(TreeNode root) {
            List<TreeNode> list = new ArrayList<>();
            Deque<TreeNode> d = new ArrayDeque<>();
            while (root != null || !d.isEmpty()) {
                while (root != null) {
                    d.add(root);
                    root = root.left;
                }
                root = d.pollLast();
                list.add(root);
                root = root.right;
            }
            TreeNode dummy = new TreeNode(-1);
            TreeNode cur = dummy;
            for (TreeNode node : list) {
                cur.right = node;
                node.left = null;
                cur = node;
            }
            return dummy.right;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}