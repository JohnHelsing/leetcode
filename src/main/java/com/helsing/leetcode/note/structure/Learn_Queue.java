package com.helsing.leetcode.note.structure;

import java.util.LinkedList;
import java.util.Queue;
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
}
