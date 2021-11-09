package com.helsing.leetcode.bean;

/**
 * @author HelSing
 * @date 2021/11/9
 */
public class PolyNode {

    public int coefficient, power;

    public PolyNode next = null;

    public PolyNode() {
    }

    public PolyNode(int x, int y) {
        this.coefficient = x;
        this.power = y;
    }

    public PolyNode(int x, int y, PolyNode next) {
        this.coefficient = x;
        this.power = y;
        this.next = next;
    }
}
