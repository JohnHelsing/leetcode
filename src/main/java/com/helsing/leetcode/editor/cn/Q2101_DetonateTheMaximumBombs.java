//给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。 
//
// 炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，
// 其中 bombs[i] = [xi, yi, ri] 。xi 和 yi 表示第 i 个炸弹的
//X 和 Y 坐标，ri 表示爆炸范围的 半径 。 
//
// 你需要选择引爆 一个 炸弹。当这个炸弹被引爆时，
// 所有 在它爆炸范围内的炸弹都会被引爆，这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。
//
// 给你数组 bombs ，请你返回在引爆 一个 炸弹的前提下，最多 能引爆的炸弹数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：bombs = [[2,1,3],[6,1,4]]
//输出：2
//解释：
//上图展示了 2 个炸弹的位置和爆炸范围。
//如果我们引爆左边的炸弹，右边的炸弹不会被影响。
//但如果我们引爆右边的炸弹，两个炸弹都会爆炸。
//所以最多能引爆的炸弹数目是 max(1, 2) = 2 。
// 
//
// 示例 2： 
//
// 
//
// 输入：bombs = [[1,1,5],[10,10,5]]
//输出：1
//解释：
//引爆任意一个炸弹都不会引爆另一个炸弹。所以最多能引爆的炸弹数目为 1 。
// 
//
// 示例 3： 
//
// 
//
// 输入：bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
//输出：5
//解释：
//最佳引爆炸弹为炸弹 0 ，因为：
//- 炸弹 0 引爆炸弹 1 和 2 。红色圆表示炸弹 0 的爆炸范围。
//- 炸弹 2 引爆炸弹 3 。蓝色圆表示炸弹 2 的爆炸范围。
//- 炸弹 3 引爆炸弹 4 。绿色圆表示炸弹 3 的爆炸范围。
//所以总共有 5 个炸弹被引爆。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= bombs.length <= 100 
// bombs[i].length == 3 
// 1 <= xi, yi, ri <= 10⁵ 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 几何 数组 数学 👍 20 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q2101_DetonateTheMaximumBombs {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumDetonation(int[][] bombs) {
            // 构建有向图，i j 为不同炸弹
            List<List<Integer>> graph =
                    IntStream.range(0, bombs.length)
                            .mapToObj(i -> new ArrayList<Integer>())
                            .collect(Collectors.toList());
            for (int i = 0; i < bombs.length; i++) {
                for (int j = 0; j < bombs.length; j++) {
                    if (i != j && isDetonates(i, j, bombs)) {
                        graph.get(i).add(j);
                    }
                }
            }

            int ans = 0;
            // 遍历每一个炸弹，更新能引爆的最大数量
            for (int i = 0; i < bombs.length; i++) {
                ans = Math.max(dfs(i, graph, new boolean[bombs.length]), ans);
            }
            return ans;
        }

        private int dfs(int u, List<List<Integer>> graph, boolean[] visited) {
            visited[u] = true;
            // 当流中没有满足过滤条件的元素的时候终止
            return 1 + graph.get(u)
                    .stream()
                    .filter(v -> !visited[v])
                    .mapToInt(v -> dfs(v, graph, visited))
                    .sum();
        }

        // isDetonates：判断 炸弹i 能否相互引爆 炸弹j
        private boolean isDetonates(int i, int j, int[][] bombs) {
            long x = bombs[j][0] - bombs[i][0],
                    y = bombs[j][1] - bombs[i][1];
            return x * x + y * y <= (long) bombs[i][2] * bombs[i][2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
