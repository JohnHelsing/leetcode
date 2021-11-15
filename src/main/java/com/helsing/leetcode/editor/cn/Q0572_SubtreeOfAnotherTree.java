//
// 
// 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则
//，返回 false 。 
//
// 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,4,5,1,2], subRoot = [4,1,2]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// root 树上的节点数量范围是 [1, 2000] 
// subRoot 树上的节点数量范围是 [1, 1000] 
// -104 <= root.val <= 104 
// -104 <= subRoot.val <= 104 
// 
// 
// 
// Related Topics 树 深度优先搜索 二叉树 字符串匹配 哈希函数 
// 👍 586 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.common.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q0572_SubtreeOfAnotherTree {

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
        static final int MAX_N = 1005;
        static final int MOD = 1000000007;
        boolean[] vis = new boolean[MAX_N];
        int[] p = new int[MAX_N];
        int tot;
        Map<TreeNode, int[]> hS = new HashMap<TreeNode, int[]>();
        Map<TreeNode, int[]> hT = new HashMap<TreeNode, int[]>();

        public boolean isSubtree(TreeNode s, TreeNode t) {
            getPrime();
            dfs(s, hS);
            dfs(t, hT);

            int tHash = hT.get(t)[0];
            for (Map.Entry<TreeNode, int[]> entry : hS.entrySet()) {
                if (entry.getValue()[0] == tHash) {
                    return true;
                }
            }

            return false;
        }

        public void getPrime() {
            vis[0] = vis[1] = true;
            tot = 0;
            for (int i = 2; i < MAX_N; ++i) {
                if (!vis[i]) {
                    p[++tot] = i;
                }
                for (int j = 1; j <= tot && i * p[j] < MAX_N; ++j) {
                    vis[i * p[j]] = true;
                    if (i % p[j] == 0) {
                        break;
                    }
                }
            }
        }

        public void dfs(TreeNode o, Map<TreeNode, int[]> h) {
            h.put(o, new int[]{o.val, 1});
            if (o.left == null && o.right == null) {
                return;
            }
            if (o.left != null) {
                dfs(o.left, h);
                int[] val = h.get(o);
                val[1] += h.get(o.left)[1];
                val[0] = (int) ((val[0] + (31L * h.get(o.left)[0] * p[h.get(o.left)[1]]) % MOD) % MOD);
            }
            if (o.right != null) {
                dfs(o.right, h);
                int[] val = h.get(o);
                val[1] += h.get(o.right)[1];
                val[0] = (int) ((val[0] + (179L * h.get(o.right)[0] * p[h.get(o.right)[1]]) % MOD) % MOD);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}