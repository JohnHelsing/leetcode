//给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的 k 个值。 
//
// 注意： 
//
// 
// 给定的目标值 target 是一个浮点数 
// 你可以默认 k 值永远是有效的，即 k ≤ 总结点数 
// 题目保证该二叉搜索树中只会存在一种 k 个值集合最接近目标值 
// 
//
// 示例： 
//
// 输入: root = [4,2,5,1,3]，目标值 = 3.714286，且 k = 2
//
//    4
//   / \
//  2   5
// / \
//1   3
//
//输出: [4,3] 
//
// 拓展： 
//假设该二叉搜索树是平衡的，请问您是否能在小于 O(n)（n 为总结点数）的时间复杂度内解决该问题呢？ 
// Related Topics 栈 树 深度优先搜索 二叉搜索树 双指针 二叉树 堆（优先队列） 
// 👍 87 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.common.bean.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q0272_ClosestBinarySearchTreeValueIi {

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
        Deque<TreeNode> less = new LinkedList<>();
        Deque<TreeNode> more = new LinkedList<>();
        List<Integer> res = new ArrayList();

        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            if (root == null) {
                return res;
            }

            // O(Height)
            while (root != null) {
                if (root.val <= target) {
                    less.push(root);
                    root = root.right;
                } else {
                    more.push(root);
                    root = root.left;
                }
            }

            while (k > 0) {
                k--;
                TreeNode tmp;
                double l = less.isEmpty() ? Integer.MAX_VALUE : Math.abs(less.peek().val - target);
                double r = more.isEmpty() ? Integer.MAX_VALUE : Math.abs(more.peek().val - target);
                if (l < r) {
                    tmp = less.pop();
                    res.add(tmp.val);
                    getLess(tmp);
                } else {
                    tmp = more.pop();
                    res.add(tmp.val);
                    getMore(tmp);
                }
            }

            return res;
        }

        // 前驱路径
        private void getLess(TreeNode node) {
            node = node.left;
            while (node != null) {
                less.push(node);
                node = node.right;
            }
        }

        // 后继路径
        private void getMore(TreeNode node) {
            node = node.right;
            while (node != null) {
                more.push(node);
                node = node.left;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}