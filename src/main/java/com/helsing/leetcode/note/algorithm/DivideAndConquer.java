package com.helsing.leetcode.note.algorithm;

import com.helsing.leetcode.editor.cn.Q0241_DifferentWaysToAddParentheses;

/**
 * 分治算法
 * <p>
 * 分治算法呢，可以认为是一种算法思想，通过将原问题分解成小规模的子问题，
 * 然后根据子问题的结果构造出原问题的答案。这里有点类似动态规划，
 * 所以说运用分治算法也需要满足一些条件，你的原问题结果应该可以通过合并子问题结果来计算。
 *
 * @author HelSing
 * @date 2022/3/3
 */
public class DivideAndConquer {

    public static void main(String[] args) {

    }

    private void think() {

    }

    /**
     * 典型的分治算法
     * 归并排序
     */
    private void sort(int[] nums, int lo, int hi) {
        int mid = (lo + hi) / 2;
        /****** 分 ******/
        // 对数组的两部分分别排序
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        /****** 治 ******/
        // 合并两个排好序的子数组
        merge(nums, lo, mid, hi);
    }

    private void etc() {
        // 为运算表达式设计优先级
        Q0241_DifferentWaysToAddParentheses.main(null);

    }

    private void merge(int[] nums, int lo, int mid, int hi) {

    }


}
