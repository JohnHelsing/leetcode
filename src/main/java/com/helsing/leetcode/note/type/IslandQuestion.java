package com.helsing.leetcode.note.type;

import com.helsing.leetcode.editor.cn.*;

/**
 * 岛屿问题
 * 岛屿系列题目的核心考点就是用 DFS/BFS 算法遍历二维数组。
 *
 * @author HelSing
 * @date 2022/3/2
 */
public class IslandQuestion {

    public static void main(String[] args) {

    }

    public void template() {

    }

    public void etc() {
        // 岛屿数量 FLOODFILL算法
        Q0200_NumberOfIslands.main(null);

        // 封闭岛屿数量 先用dfs淹掉靠边的岛
        Q1254_NumberOfClosedIslands.main(null);

        // 飞地的面积
        Q1020_NumberOfEnclaves.main(null);

        // 岛屿的最大面积
        // dfs 函数设置返回值，记录每次淹没的陆地的个数
        Q0695_MaxAreaOfIsland.main(null);

        // 子岛屿数量
        // 反向思考
        Q1905_CountSubIslands.main(null);

        // 不同的岛屿数量
        Q0694_NumberOfDistinctIslands.main(null);
    }
}
