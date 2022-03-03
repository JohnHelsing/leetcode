package com.helsing.leetcode.note.algorithm;

import com.helsing.leetcode.note.type.IslandQuestion;

/**
 * 与回溯类似
 * Dfs不需要回溯，而搜索回溯算法需要回溯。
 * <p>
 * 搜索回溯是一次性完成搜索，Dfs是正向展开反向计算。
 * 搜索回溯需要从整体考虑，Dfs只需要考虑边界条件和第一步的算法。
 * <p>
 * 搜索回溯适合不能确定是否可以搜完的搜索（深度有限），DFS适合确定可以完全搜完的搜索。
 *
 * @author HelSing
 * @date 2022/3/3
 */
public class DFS {

    public static void main(String[] args) {

    }

    private void etc() {
        // 岛屿类型题目(可以用DFS来做)
        IslandQuestion.main(null);
    }
}
