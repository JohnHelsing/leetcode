package com.helsing.leetcode.bean;

import java.util.Random;

/**
 * @author HelSing
 * @date 2021/11/8
 */
public class CustomFunction {

    private Random random = new Random();

    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    public int f(int x, int y) {
        return random.nextInt();
    }

}
