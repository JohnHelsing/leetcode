package com.helsing.leetcode.common.bean;

import java.util.Random;

/**
 * @author HelSing
 * @date 2021/11/11
 */
public class SolBase {

    private Random random = new Random();

    public int rand7() {
        return 1 + random.nextInt(6);
    }
}
