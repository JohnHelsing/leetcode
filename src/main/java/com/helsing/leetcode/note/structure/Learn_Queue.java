package com.helsing.leetcode.note.structure;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 队列
 * 分为单向队列和双向队列
 *
 * @author HelSing
 * @date 2021/11/9
 */
public class Learn_Queue {

    /**
     * 单向队列
     * 找出第一个满足某个条件的元素
     */
    public void queue() throws Exception {
        /**
         * 常用linkedList做队列的具体实现
         */
        Queue<Integer> queue = new LinkedList<>();
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

        /**
         * 队尾添加：add/offer/put
         * add     增加一个元索            如果队列已满，则抛出一个IIIegaISlabEepeplian异常
         * offer   添加一个元素并返回true   如果队列已满，则返回false
         * put     添加一个元素            如果队列满，则阻塞
         */
        queue.add(1);
        queue.offer(1);
        // 阻塞队列
        blockingQueue.put(1);

        /**
         * 获取并移除队头：remove/poll/take
         * remove  移除并返回队列头部的元素   如果队列为空，则抛出一个NoSuchElementException异常
         * poll    移除并返问队列头部的元素   如果队列为空，则返回null
         * take    移除并返回队列头部的元素    如果队列为空，则阻塞
         */
        queue.remove();
        queue.poll();
        // 阻塞队列
        blockingQueue.take();

        /**
         * 获取队头，但不删除：element/peek
         * element 返回队列头部的元素  如果队列为空，则抛出一个NoSuchElementException异常
         * peek    返回队列头部的元素  如果队列为空，则返回null
         */
        queue.peek();
        queue.element();
    }

    /**
     * 双向队列
     * 能够同时对头和尾进行操作
     */
    public void deque() {
        /**
         * 常用ArrayDeque做具体实现
         */
        Deque<Integer> deque = new ArrayDeque<>();

        /**
         * 针对第一个元素  addFirst/removeFirst/getFirst  offerFirst/pollFirst/peekFirst
         *
         *           抛出异常	      特殊值
         * 插入	   addFirst(e)	   offerFirst(e)
         * 删除	   removeFirst()   pollFirst()
         * 检查	   getFirst()	   peekFirst()
         */
        deque.addFirst(1);
        deque.offerFirst(1);
        deque.removeFirst();
        deque.pollFirst();
        deque.getFirst();
        deque.peekFirst();

        /**
         * 针对最后一个元素 addLast/removeLast/getLast  offerLast/pollLast/peekLast
         *
         * 	          抛出异常	         特殊值
         * 插入	    addLast(e)	    offerLast(e)
         * 删除	    removeLast()	pollLast()
         * 检查	  	getLast()	    peekLast()
         */
        deque.addLast(1);
        deque.offerLast(1);
        deque.removeLast();
        deque.pollLast();
        deque.getLast();
        deque.peekLast();
    }

    /**
     * 优先队列
     */
    public void priority() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return x - y;
            }
        });
        queue.add(1);
        queue.offer(2);

        queue.peek();

        queue.remove();
        queue.poll();
    }
}
