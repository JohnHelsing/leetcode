//给你一个无向图，无向图由整数 n ，表示图中节点的数目，和 edges 组成，其中 edges[i] = [ui, vi] 表示 ui 和 vi 之间有一条
//无向边。同时给你一个代表查询的整数数组 queries 。 
//
// 第 j 个查询的答案是满足如下条件的点对 (a, b) 的数目： 
//
// 
// a < b 
// cnt 是与 a 或者 b 相连的边的数目，且 cnt 严格大于 queries[j] 。 
// 
//
// 请你返回一个数组 answers ，其中 answers.length == queries.length 且 answers[j] 是第 j 个查询的答
//案。 
//
// 请注意，图中可能会有 重复边 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, edges = [[1,2],[2,4],[1,3],[2,3],[2,1]], queries = [2,3]
//输出：[6,5]
//解释：每个点对中，与至少一个点相连的边的数目如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：n = 5, edges = [[1,5],[1,5],[3,4],[2,5],[1,3],[5,1],[2,3],[2,5]], queries =
// [1,2,3,4,5]
//输出：[10,10,9,8,6]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 2 * 104 
// 1 <= edges.length <= 105 
// 1 <= ui, vi <= n 
// ui != vi 
// 1 <= queries.length <= 20 
// 0 <= queries[j] < edges.length 
// 
// Related Topics 图 双指针 二分查找 
// 👍 25 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q1782_CountPairsOfNodes {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int P = 100000;

        public int[] countPairs(int n, int[][] edges, int[] queries) {
            int[] du = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < edges.length; i++) {
                int m = edges[i][0] - 1, k = edges[i][1] - 1;
                if (m > k) {
                    int t = m;
                    m = k;
                    k = t;
                }
                du[m]++;
                du[k]++;
                int temp = m * P + k;       //将点和出现频率压入哈希表中的技巧方法
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
            int e = edges.length;
            int[] cnt = new int[e + 2];     //前缀和数组 +2 保证 头尾有空档 否则会少处理数据
            for (int i = 0; i < n; i++) {
                cnt[du[i]]++;
            }
            for (int i = e - 1; i >= 0; i--) {
                cnt[i] += cnt[i + 1];
            }
            int[] res = new int[queries.length];
            HashMap<Integer, Integer> map1 = new HashMap<>();
            for (int i = 0; i < queries.length; i++) {
                if (map1.containsKey(queries[i])) {
                    res[i] = map1.get(queries[i]);
                    continue;
                }
                int estimate = 0;
                for (int j = 0; j < e + 1; j++) {       // 边界条件 考虑边数远远小于 点数的情况
                    estimate += (cnt[j] - cnt[j + 1]) * cnt[queries[i] - j + 1 > 0 ? queries[i] - j + 1 : 0];
                }
                for (int j = 0; j < n; j++) {
                    if (du[j] * 2 > queries[i]) {
                        estimate--;
                    }
                }
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    int m1 = entry.getKey() / P, m2 = entry.getKey() % P;
                    if (m1 > m2) {
                        int t1 = m2;
                        m2 = m1;
                        m1 = t1;
                    }
                    if (du[m1] + du[m2] > queries[i] && du[m1] + du[m2] - entry.getValue() <= queries[i]) {
                        estimate -= 2;
                    }
                }
                res[i] = estimate / 2;
                map1.put(queries[i], res[i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}