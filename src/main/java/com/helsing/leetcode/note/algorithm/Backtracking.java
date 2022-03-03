package com.helsing.leetcode.note.algorithm;

import com.helsing.leetcode.editor.cn.*;

/**
 * 其实回溯算法其实就是我们常说的 DFS 算法，本质上就是一种暴力穷举算法。
 * <p>
 * 废话不多说，直接上回溯算法框架。解决一个回溯问题，实际上就是一个决策树的遍历过程。
 * 你只需要思考 3 个问题：
 * 1、路径：也就是已经做出的选择。
 * 2、选择列表：也就是你当前可以做的选择。
 * 3、结束条件：也就是到达决策树底层，无法再做选择的条件。
 *
 * @author HelSing
 * @date 2022/3/2
 */
public class Backtracking {

    public static void main(String[] args) {

    }

    /**
     *
     */
    private void think() {

    }

    private void template() {
        String template =
                """
                        result = []
                        def backtrack(路径, 选择列表):
                            if 满足结束条件:
                                result.add(路径)
                                return
                            for 选择 in 选择列表:
                                做选择
                                backtrack(路径, 选择列表)
                                撤销选择
                        """;
        // 其核心就是 for 循环里面的递归
        // 在递归调用之前「做选择」
        // 在递归调用之后「撤销选择」
    }

    /**
     * 举例
     */
    private void etc() {
        // 全排列
        Q0046_Permutations.main(null);

        // 全排列II
        Q0047_PermutationsIi.main(null);

        // N皇后
        Q0051_NQueens.main(null);

        // N皇后II
        Q0052_NQueensIi.main(null);

        // 不同的岛屿数量
        Q0694_NumberOfDistinctIslands.main(null);
    }
}
