//给出两棵二叉搜索树，请你从两棵树中各找出一个节点，使得这两个节点的值之和等于目标值 Target。 
//
// 如果可以找到返回 True，否则返回 False。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：root1 = [2,1,4], root2 = [1,0,3], target = 5
//输出：true
//解释：2 加 3 和为 5 。
// 
//
// 示例 2： 
//
// 
//
// 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
//输出：false 
//
// 
//
// 提示： 
//
// 
// 每棵树上最多有 5000 个节点。 
// -10^9 <= target, node.val <= 10^9 
// 
// Related Topics 栈 树 深度优先搜索 二叉搜索树 双指针 二分查找 二叉树 
// 👍 33 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.common.bean.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q1214_TwoSumBsts {

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
        public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
            // 两个栈 双指针
//            return twoPointersWithStack(root1, root2, target);

            // 中序遍历 双指针
            return twoPointersWithSort(root1, root2, target);
        }

        public boolean twoPointersWithSort(TreeNode root1, TreeNode root2, int target) {
            if (root1 == null || root2 == null)
                return false;
            List<TreeNode> listA = new ArrayList<>();
            List<TreeNode> listB = new ArrayList<>();
            inorder(root1, listA);
            inorder(root2, listB);
            // 双指针查找
            int lenA = listA.size();
            int lenB = listB.size();
            int pa = 0, pb = lenB - 1;
            while (pa < lenA && pb >= 0) {
                int valA = listA.get(pa).val;
                int valB = listB.get(pb).val;
                if (valA + valB == target)
                    return true;
                else if (valA + valB > target)
                    pb--;
                else
                    pa++;
            }
            return false;
        }

        private void inorder(TreeNode node, List<TreeNode> list) {
            if (node == null) {
                return;
            }
            inorder(node.left, list);
            list.add(node);
            inorder(node.right, list);
        }

        private Deque<TreeNode> leftStack;
        private TreeNode leftCur;
        private Deque<TreeNode> rightStack;
        private TreeNode rightCur;

        public boolean twoPointersWithStack(TreeNode root1, TreeNode root2, int target) {
            if (root1 == null || root2 == null) {
                return false;
            }
            leftStack = new LinkedList<>();
            rightStack = new LinkedList<>();
            leftCur = root1;
            rightCur = root2;
            // 双指针查找
            TreeNode nodeA = nextNodeA();
            TreeNode nodeB = nextNodeB();
            while (nodeA != null && nodeB != null) {
                if (nodeA.val + nodeB.val == target) {
                    return true;
                } else if (nodeA.val + nodeB.val > target) {
                    nodeB = nextNodeB();
                } else {
                    nodeA = nextNodeA();
                }
            }
            return false;
        }

        // left mid right 从小到大
        private TreeNode nextNodeA() {
            if (leftCur == null && leftStack.isEmpty())
                return null;
            while (leftCur != null) {
                leftStack.push(leftCur);
                leftCur = leftCur.left;
            }
            TreeNode ret = leftStack.pop();
            leftCur = ret.right;
            return ret;
        }

        // right mid left 从大到小
        private TreeNode nextNodeB() {
            if (rightCur == null && rightStack.isEmpty())
                return null;
            while (rightCur != null) {
                rightStack.push(rightCur);
                rightCur = rightCur.right;
            }
            TreeNode ret = rightStack.pop();
            rightCur = ret.left;
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}