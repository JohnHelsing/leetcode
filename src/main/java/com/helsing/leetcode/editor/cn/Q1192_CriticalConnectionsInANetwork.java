//力扣数据中心有 n 台服务器，分别按从 0 到 n-1 的方式进行了编号。 
//
// 它们之间以「服务器到服务器」点对点的形式相互连接组成了一个内部集群，其中连接 connections 是无向的。 
//
// 从形式上讲，connections[i] = [a, b] 表示服务器 a 和 b 之间形成连接。任何服务器都可以直接或者间接地通过网络到达任何其他服务器
//。 
//
// 「关键连接」是在该集群中的重要连接，也就是说，假如我们将它移除，便会导致某些服务器无法访问其他服务器。 
//
// 请你以任意顺序返回该集群内的所有 「关键连接」。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
//输出：[[1,3]]
//解释：[[3,1]] 也是正确的。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^5 
// n-1 <= connections.length <= 10^5 
// connections[i][0] != connections[i][1] 
// 不存在重复的连接 
// 
// Related Topics 深度优先搜索 图 双连通分量 
// 👍 164 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.*;

public class Q1192_CriticalConnectionsInANetwork {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            // Tarjan算法
            return tarjan(n, connections);
        }

        public List<List<Integer>> tarjan(int n, List<List<Integer>> connections) {
            // 构建邻接表
            Map<Integer, Set<Integer>> map = new HashMap<>();
            buildMap(connections, map);

            // 创建一个数组，存放每个节点访问的时间戳
            int[] dfn = new int[n];
            Arrays.fill(dfn, -1);

            // 选取一个点作为根节点，dfs向下递归，过程中识别出哪个边是critical connection
            List<List<Integer>> res = new ArrayList<>();
            // 假设根节点有一个编号是-1父节点
            dfs(0, 0, -1, dfn, map, res);

            return res;
        }

        public void buildMap(List<List<Integer>> con, Map<Integer, Set<Integer>> map) {
            for (List<Integer> edge : con) {
                int n1 = edge.get(0);
                int n2 = edge.get(1);

                Set<Integer> n1n = map.getOrDefault(n1, new HashSet<>());
                Set<Integer> n2n = map.getOrDefault(n2, new HashSet<>());

                n1n.add(n2);
                n2n.add(n1);

                map.put(n1, n1n);
                map.put(n2, n2n);
            }
        }

        public int dfs(int node, int time, int parent, int[] dfn,
                       Map<Integer, Set<Integer>> map, List<List<Integer>> res) {
            dfn[node] = time;

            // 获取该节点所有连接的点
            Set<Integer> set = map.get(node);
            for (Integer neighbor : set) {
                if (neighbor == parent) {
                    continue;
                } else if (dfn[neighbor] == -1) {
                    dfn[node] = Math.min(dfn[node], dfs(neighbor, time + 1, node, dfn, map, res));
                } else {
                    dfn[node] = Math.min(dfn[node], dfn[neighbor]);
                }
            }

            if (dfn[node] == time && node != 0) {
                res.add(Arrays.asList(parent, node));
            }

            return dfn[node];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}