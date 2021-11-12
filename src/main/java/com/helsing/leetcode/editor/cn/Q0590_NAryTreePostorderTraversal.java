//给定一个 N 叉树，返回其节点值的 后序遍历 。 
//
// N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。 
//
// 
// 
// 
//
// 进阶： 
//
// 递归法很简单，你可以使用迭代法完成此题吗? 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[5,6,3,2,4,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
// 
//
// 
//
// 提示： 
//
// 
// N 叉树的高度小于或等于 1000 
// 节点总数在范围 [0, 10^4] 内 
// 
// 
// 
// Related Topics 栈 树 深度优先搜索 
// 👍 167 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.common.bean.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q0590_NAryTreePostorderTraversal {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {
        public List<Integer> postorder(Node root) {
            if (root == null) {
                return new ArrayList<>();
            }
            // 迭代 栈
            return stack(root);
        }

        public List<Integer> stack(Node root) {
            List<Integer> value = new ArrayList<>();
            Deque<Node> stack = new ArrayDeque<>();
            // child 记录 对应结点 已经遍历过的孩子数量
            Deque<Integer> childStack = new ArrayDeque<>();
            Node cur = root;
            int next;
            while (!stack.isEmpty() || cur != null) {
                while (cur != null) {
                    stack.push(cur);
                    childStack.push(0);
                    if (cur.children.size() > 0) {
                        cur = cur.children.get(0);
                    } else
                        cur = null;
                }
                cur = stack.poll();
                next = childStack.poll();
                if (cur.children.size() == 0 || next >= cur.children.size()) {
                    value.add(cur.val);
                    cur = null;
                } else {
                    stack.push(cur);
                    childStack.push(next + 1);
                    if (next + 1 < cur.children.size())
                        cur = cur.children.get(next + 1);
                    else
                        cur = null;
                }
            }
            return value;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}