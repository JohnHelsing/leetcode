package com.helsing.leetcode.note.algorithm;

import com.helsing.leetcode.editor.cn.Q0322_CoinChange;
import com.helsing.leetcode.editor.cn.Q0509_FibonacciNumber;

/**
 * 动态规划
 * 一般用来求最值
 * 本质上是【穷举】
 * 一定存在【最优子结构】 -- 【备忘录、DP Table】
 * <p>
 * // TODO 待续 还有整章内容要写
 *
 * @author HelSing
 * @date 2022/3/2
 */
public class DP {

    public static void main(String[] args) {

    }

    /**
     * 解题思路
     * 明确 base case -> 明确「状态」-> 明确「选择」 -> 定义 dp 数组/函数的含义。
     */
    private void think() {
        // 1、确定 base case
        // 2、确定「状态」，也就是原问题和子问题中会变化的变量。
        // 3、确定「选择」，也就是导致「状态」产生变化的行为。
        // 4、明确 dp 函数/数组的定义。
        // 4.1 自顶向下的解法，会有一个递归的dp函数，
        // 一般来说函数的参数就是状态转移中会变化的量，
        // 也就是上面说到的「状态」；
        // 函数的返回值就是题目要求我们计算的量。
    }

    /**
     * 模板
     */
    private void template() {
        String template = """
                # 初始化 base case
                dp[0][0][...] = base
                # 进行状态转移
                 for 状态1 in 状态1的所有取值：
                    for 状态2 in 状态2的所有取值：
                       for ...
                         dp[状态1][状态2][...] = 求最值(选择1，选择2...)
                """;
    }

    /**
     * 例题
     */
    private void etc() {
        // 斐波那契
        Q0509_FibonacciNumber.main(null);

        // 零钱兑换
        Q0322_CoinChange.main(null);
    }
}
