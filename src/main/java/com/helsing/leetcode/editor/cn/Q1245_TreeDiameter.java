//给你这棵「无向树」，请你测算并返回它的「直径」：这棵树上最长简单路径的 边数。 
//
// 我们用一个由所有「边」组成的数组 edges 来表示一棵无向树，
// 其中 edges[i] = [u, v] 表示节点 u 和 v 之间的双向边。
//
// 树上的节点都已经用 {0, 1, ..., edges.length} 中的数做了标记，
// 每个节点上的标记都是独一无二的。
//
// 
//
// 示例 1： 
//
// 
//
// 输入：edges = [[0,1],[0,2]]
//输出：2
//解释：
//这棵树上最长的路径是 1 - 0 - 2，边数为 2。
// 
//
// 示例 2： 
//
// 
//
// 输入：edges = [[0,1],[1,2],[2,3],[1,4],[4,5]]
//输出：4
//解释： 
//这棵树上最长的路径是 3 - 2 - 1 - 4 - 5，边数为 4。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= edges.length < 10^4 
// edges[i][0] != edges[i][1] 
// 0 <= edges[i][j] <= edges.length 
// edges 会形成一棵无向树 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 👍 83 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q1245_TreeDiameter {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int maxDist = 0;

        public int treeDiameter(int[][] edges) {
            if (edges == null || edges.length == 0 || edges[0].length == 0) {
                return 0;
            }
            // The index of the list mapps to each node, Assuming the node values are unique.
            List<List<Integer>> graph = new ArrayList<>();
            // The length of graph is edges.length + 1 (the count of nodes is one more than that of edges)
            for (int i = 0; i < edges.length + 1; i++) {
                graph.add(new ArrayList<Integer>());
            }
            for (int[] edge : edges) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }
            boolean[] visited = new boolean[graph.size()];
            dfs(graph, 0, visited);
            return maxDist;
        }

        private int dfs(List<List<Integer>> graph, int index, boolean[] visited) {
            visited[index] = true;
            List<Integer> nodes = graph.get(index);
            int max1 = 0;
            int max2 = 0;
            for (int next : nodes) {
                if (visited[next]) {
                    continue;
                }
                int dist = dfs(graph, next, visited);
                if (dist > max1) {
                    max2 = max1;
                    max1 = dist;
                } else if (dist > max2) {
                    max2 = dist;
                }
            }
            maxDist = Math.max(maxDist, max1 + max2);

            return Math.max(max1, max2) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
