//我们从二叉树的根节点 root 开始进行深度优先搜索。 
//
// 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），
// 然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
//
// 如果节点只有一个子节点，那么保证该子节点为左子节点。 
//
// 给出遍历输出 S，还原树并返回其根节点 root。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入："1-2--3--4-5--6--7"
//输出：[1,2,5,3,4,6,7]
// 
//
// 示例 2： 
//
// 
//
// 输入："1-2--3---4-5--6---7"
//输出：[1,2,5,3,null,6,null,4,null,7]
// 
//
// 示例 3： 
//
// 
//
// 输入："1-401--349---90--88"
//输出：[1,401,null,349,88,90]
// 
//
// 
//
// 提示： 
//
// 
// 原始树中的节点数介于 1 和 1000 之间。 
// 每个节点的值介于 1 和 10 ^ 9 之间。 
// 
// Related Topics 树 深度优先搜索 字符串 二叉树 👍 209 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.common.bean.TreeNode;

import java.util.*;

public class Q1028_RecoverATreeFromPreorderTraversal {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(211);
        root.left.left = new TreeNode(31);
        root.left.right = new TreeNode(411);
        root.right = new TreeNode(51);
        root.right.left = new TreeNode(6111);
        root.right.right = new TreeNode(71);
        StringBuilder sb = new StringBuilder();
        solution.dfs(sb, root, 0);
        System.out.println(sb.toString());
        solution.recoverFromPreorder(sb.toString());
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
        public TreeNode recoverFromPreorder(String traversal) {
            Deque<TreeNode> path = new LinkedList<TreeNode>();
            int pos = 0;
            while (pos < traversal.length()) {
                int level = 0;
                while (traversal.charAt(pos) == '-') {
                    level++;
                    pos++;
                }
                int value = 0;
                while (pos < traversal.length() && Character.isDigit(traversal.charAt(pos))) {
                    value = value * 10 + (traversal.charAt(pos) - '0');
                    pos++;
                }
                TreeNode node = new TreeNode(value);
                if (level == path.size()) {
                    if (!path.isEmpty()) {
                        path.peek().left = node;
                    }
                } else {
                    while (level != path.size()) {
                        path.pop();
                    }
                    path.peek().right = node;
                }
                path.push(node);
            }
            while (path.size() > 1) {
                path.pop();
            }
            return path.peek();
        }

        // 先模拟一下输出
        public void dfs(StringBuilder sb, TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            for (int i = 0; i < depth; i++) {
                sb.append("-");
            }
            sb.append(root.val);
            dfs(sb, root.left, depth + 1);
            dfs(sb, root.right, depth + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
