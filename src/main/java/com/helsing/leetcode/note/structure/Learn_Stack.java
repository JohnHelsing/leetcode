package com.helsing.leetcode.note.structure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈
 * 一般在java中用栈的话，都用deque来做
 *
 * @author HelSing
 * @date 2021/11/9
 */
public class Learn_Stack {

    public static void main(String[] args) {
        Deque<Integer> stack;
        /**
         * 链表实现
         * 每次push都需要new Node节点，并且node节点里面有prev和next成员，也会有额外的空间占用。
         */
        stack = new LinkedList<>();

        /**
         * 数组实现
         * 当用作栈的实现时候，性能更好一点。
         */
        stack = new ArrayDeque<>();

        /**
         * 核心三个方法 push/pop/peek
         */
        // push 入栈
        stack.push(1);

        // pop 出栈
        stack.pop();

        // 判空和长度
        stack.isEmpty();
        stack.size();
    }

}
