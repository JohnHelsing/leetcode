package com.helsing.leetcode.common.bean;

import java.util.List;

/**
 * @author HelSing
 * @date 2021/11/10
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
