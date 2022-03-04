package com.helsing.leetcode.note.type;

import com.helsing.leetcode.editor.cn.*;

/**
 * 排列组合问题
 *
 * @author HelSing
 * @date 2022/3/4
 */
public class PermutationAndCombination {

    public static void main(String[] args) {
        /**
         * 排列
         * 组合
         * 子集
         * 三种问题：
         */
        // 形式一、元素无重不可复选
        // 即 nums 中的元素都是唯一的，每个元素最多只能被使用一次，这也是最基本的形式。

        // 形式二、元素可重不可复选
        // 即 nums 中的元素可以存在重复，每个元素最多只能被使用一次。

        // 形式三、元素无重可复选
        // 即 nums 中的元素都是唯一的，每个元素可以被使用若干次。

        /**
         * 但无论形式怎么变化，其本质就是穷举所有解，
         * 而这些解呈现树形结构，所以合理使用回溯算法框架，
         * 稍改代码框架即可把这些问题一网打尽。
         */
    }

    private void template() {
        // 形式一、元素无重不可复选，即 nums 中的元素都是唯一的，每个元素最多只能被使用一次
        String template = """
                /* 组合/子集问题回溯算法框架 */
                void backtrack(int[] nums, int start) {
                    // 回溯算法标准框架
                    for (int i = start; i < nums.length; i++) {
                        // 做选择
                        track.addLast(nums[i]);
                        // 注意参数
                        backtrack(nums, i + 1);
                        // 撤销选择
                        track.removeLast();
                    }
                }
                                
                /* 排列问题回溯算法框架 */
                void backtrack(int[] nums) {
                    for (int i = 0; i < nums.length; i++) {
                        // 剪枝逻辑
                        if (used[i]) {
                            continue;
                        }
                        // 做选择
                        used[i] = true;
                        track.addLast(nums[i]);
                                
                        backtrack(nums);
                        // 取消选择
                        track.removeLast();
                        used[i] = false;
                    }
                }
                """;
        // 形式二、元素可重不可复选，即 nums 中的元素可以存在重复，每个元素最多只能被使用一次，其关键在于排序和剪枝
        template = """
                Arrays.sort(nums);
                /* 组合/子集问题回溯算法框架 */
                void backtrack(int[] nums, int start) {
                    // 回溯算法标准框架
                    for (int i = start; i < nums.length; i++) {
                        // 剪枝逻辑，跳过值相同的相邻树枝
                        if (i > start && nums[i] == nums[i - 1]) {
                            continue;
                        }
                        // 做选择
                        track.addLast(nums[i]);
                        // 注意参数
                        backtrack(nums, i + 1);
                        // 撤销选择
                        track.removeLast();
                    }
                }
                                
                                
                Arrays.sort(nums);
                /* 排列问题回溯算法框架 */
                void backtrack(int[] nums) {
                    for (int i = 0; i < nums.length; i++) {
                        // 剪枝逻辑
                        if (used[i]) {
                            continue;
                        }
                        // 剪枝逻辑，固定相同的元素在排列中的相对位置
                        if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                            continue;
                        }
                        // 做选择
                        used[i] = true;
                        track.addLast(nums[i]);
                                
                        backtrack(nums);
                        // 取消选择
                        track.removeLast();
                        used[i] = false;
                    }
                }
                """;

        // 形式三、元素无重可复选，即 nums 中的元素都是唯一的，每个元素可以被使用若干次，只要删掉去重逻辑即可
        template = """
                /* 组合/子集问题回溯算法框架 */
                void backtrack(int[] nums, int start) {
                    // 回溯算法标准框架
                    for (int i = start; i < nums.length; i++) {
                        // 做选择
                        track.addLast(nums[i]);
                        // 注意参数
                        backtrack(nums, i);
                        // 撤销选择
                        track.removeLast();
                    }
                }
                                
                                
                /* 排列问题回溯算法框架 */
                void backtrack(int[] nums) {
                    for (int i = 0; i < nums.length; i++) {
                        // 做选择
                        track.addLast(nums[i]);
                                
                        backtrack(nums);
                        // 取消选择
                        track.removeLast();
                    }
                }
                """;
    }

    private void etc() {
        // 子集（元素无重不可复选）
        Q0078_Subsets.main(null);

        // 组合（元素无重不可复选）
        Q0077_Combinations.main(null);

        // 全排列（元素无重不可复选）
        Q0046_Permutations.main(null);

        // 子集/组合（元素可重不可复选）
        Q0090_SubsetsIi.main(null);
        Q0040_CombinationSumIi.main(null);

        // 排列（元素可重不可复选）
        Q0047_PermutationsIi.main(null);

        // 子集/组合（元素无重可复选）
        Q0039_CombinationSum.main(null);
    }
}
