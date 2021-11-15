//请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。 
//
// 实现 LFUCache 类： 
//
// 
// LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象 
// int get(int key) - 如果键存在于缓存中，则获取键的值，否则返回 -1。 
// void put(int key, int value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之
//前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。 
// 
//
// 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。 
//
// 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。 
//
// 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。 
//
// 
//
// 示例： 
//
// 
//输入：
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "g
//et"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//输出：
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//解释：
//// cnt(x) = 键 x 的使用计数
//// cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
//LFUCache lFUCache = new LFUCache(2);
//lFUCache.put(1, 1);   // cache=[1,_], cnt(1)=1
//lFUCache.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//lFUCache.get(1);      // 返回 1
//                      // cache=[1,2], cnt(2)=1, cnt(1)=2
//lFUCache.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
//                      // cache=[3,1], cnt(3)=1, cnt(1)=2
//lFUCache.get(2);      // 返回 -1（未找到）
//lFUCache.get(3);      // 返回 3
//                      // cache=[3,1], cnt(3)=2, cnt(1)=2
//lFUCache.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
//                      // cache=[4,3], cnt(4)=1, cnt(3)=2
//lFUCache.get(1);      // 返回 -1（未找到）
//lFUCache.get(3);      // 返回 3
//                      // cache=[3,4], cnt(4)=1, cnt(3)=3
//lFUCache.get(4);      // 返回 4
//                      // cache=[3,4], cnt(4)=2, cnt(3)=3 
//
// 
//
// 提示： 
//
// 
// 0 <= capacity, key, value <= 104 
// 最多调用 105 次 get 和 put 方法 
// 
//
// 
//
// 进阶：你可以为这两种操作设计时间复杂度为 O(1) 的实现吗？ 
// Related Topics 设计 哈希表 链表 双向链表 
// 👍 456 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q0460_LfuCache {

    public static void main(String[] args) {
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {

        /**
         * 双链表中的链表节点对象
         */
        static class DLinkedNode {
            //对应输入的key
            private final int key;

            //对应输入的value
            private int value;

            //被访问的频率
            private int freq;

            //指向前一个节点、后一个节点的指针
            protected DLinkedNode pre, next;

            public DLinkedNode(int key, int value, int freq) {
                this.key = key;
                this.value = value;
                this.freq = freq;
            }

            public DLinkedNode(int key, int value, int freq, DLinkedNode pre, DLinkedNode next) {
                this.key = key;
                this.value = value;
                this.freq = freq;
                this.pre = null;
                this.next = null;
            }

            public void updateValue(int value) {
                this.value = value;
            }

            public void incrFreq() {
                ++this.freq;
            }

            public int getKey() {
                return this.key;
            }

            public int getValue() {
                return this.value;
            }

            public int getFreq() {
                return this.freq;
            }

            public static final DLinkedNode createEmptyNode() {
                return new DLinkedNode(-1, -1, -1, null, null);
            }
        }

        /**
         * 自定义的双向链表类
         */
        protected static class LinkedList {
            //双向链表的头结点
            private final DLinkedNode head;

            //双向链表的尾节点
            private final DLinkedNode tail;

            public LinkedList() {
                this.head = DLinkedNode.createEmptyNode();
                this.tail = DLinkedNode.createEmptyNode();
                this.head.next = this.tail;
                this.tail.pre = this.head;
            }

            /**
             * 将指定的节点插入到链表的第一个位置
             *
             * @param node 将要插入的节点
             */
            public void insertFirst(DLinkedNode node) {
                if (node == null) {
                    throw new IllegalArgumentException();
                }
                node.next = this.head.next;
                this.head.next.pre = node;
                node.pre = this.head;
                this.head.next = node;
            }

            /**
             * 从链表中删除指定的节点
             *
             * @param node 将要删除的节点
             */
            public void deleteNode(DLinkedNode node) {
                if (node == null) {
                    throw new IllegalArgumentException();
                }
                node.pre.next = node.next;
                node.next.pre = node.pre;
                node.pre = null;
                node.next = null;
            }

            /**
             * 从链表中获取最后一个节点
             *
             * @return 双向链表中的最后一个节点，如果是空链表则返回None
             */
            public DLinkedNode getLastNode() {
                if (this.head.next == this.tail) {
                    return DLinkedNode.createEmptyNode();
                }
                return this.tail.pre;
            }

            /**
             * 判断链表是否为空，除了head和tail没有其他节点即为空链表
             *
             * @return 链表不空返回True，否则返回False
             */
            public boolean isEmpty() {
                return this.head.next == this.tail;
            }
        }

        //key->Node 这种结构的哈希表
        private final Map<Integer, DLinkedNode> keyMap = new HashMap<Integer, DLinkedNode>();

        //freq->LinkedList 这种结构的哈希表
        private final Map<Integer, LinkedList> freqMap = new HashMap<Integer, LinkedList>();

        //缓存的最大容量
        private final int capacity;

        //记录缓存中最低频率
        private int minFreq = 0;

        public LFUCache(int capacity) {
//		if(capacity<=0) {
//			throw new IllegalArgumentException();
//		}
            this.capacity = capacity;
        }

        /**
         * 获取一个元素，如果key不存在则返回-1，否则返回对应的value，同时更新被访问元素的频率
         *
         * @param key 要查找的关键字
         * @return 如果没找到则返回-1，否则返回对应的value
         */
        public int get(int key) {
            if (!this.keyMap.containsKey(key)) {
                return -1;
            }
            DLinkedNode node = this.keyMap.get(key);
            this.increment(node);
            return node.getValue();
        }

        /**
         * 插入指定的key和value，如果key存在则更新value，同时更新频率，
         * 如果key不存并且缓存满了，则删除频率最低的元素，并插入新元素。否则，直接插入新元素
         *
         * @param key   要插入的关键字
         * @param value 要插入的值
         */
        public void put(int key, int value) {
            if (this.keyMap.containsKey(key)) {
                DLinkedNode node = this.keyMap.get(key);
                node.updateValue(value);
                this.increment(node);
            } else {
                if (this.capacity == 0) {
                    return;
                }
                if (this.keyMap.size() == this.capacity) {
                    this.remoteMinFreqNode();
                }
                DLinkedNode node = new DLinkedNode(key, value, 1);
                this.increment(node, true);
                this.keyMap.put(key, node);
            }
        }


        /**
         * 更新节点的访问频率
         *
         * @param node 要更新的节点
         */
        private void increment(DLinkedNode node) {
            increment(node, false);
        }

        /**
         * 更新节点的访问频率
         *
         * @param node      要更新的节点
         * @param isNewNode 是否是新节点，新插入的节点和非新插入节点更新逻辑不同
         */
        private void increment(DLinkedNode node, boolean isNewNode) {
            if (isNewNode) {
                this.minFreq = 1;
                this.insertToLinkedList(node);
            } else {
                this.deleteNode(node);
                node.incrFreq();
                this.insertToLinkedList(node);
                if (!this.freqMap.containsKey(this.minFreq)) {
                    ++this.minFreq;
                }
            }
        }

        /**
         * 根据节点的频率，插入到对应的LinkedList中，如果LinkedList不存在则创建
         *
         * @param node 将要插入到LinkedList的节点
         */
        private void insertToLinkedList(DLinkedNode node) {
            if (!this.freqMap.containsKey(node.getFreq())) {
                this.freqMap.put(node.getFreq(), new LinkedList());
            }
            LinkedList linkedList = this.freqMap.get(node.getFreq());
            linkedList.insertFirst(node);
        }

        /**
         * 删除指定的节点，如果节点删除后，对应的双链表为空，则从__freqMap中删除这个链表
         *
         * @param node 将要删除的节点
         */
        private void deleteNode(DLinkedNode node) {
            LinkedList linkedList = this.freqMap.get(node.getFreq());
            linkedList.deleteNode(node);
            if (linkedList.isEmpty()) {
                this.freqMap.remove(node.getFreq());
            }
        }

        /**
         * 删除频率最低的元素，从freqMap和keyMap中都要删除这个节点，
         * 如果节点删除后对应的链表为空，则要从__freqMap中删除这个链表
         */
        private void remoteMinFreqNode() {
            LinkedList linkedList = this.freqMap.get(this.minFreq);
            DLinkedNode node = linkedList.getLastNode();
            linkedList.deleteNode(node);
            this.keyMap.remove(node.getKey());
            if (linkedList.isEmpty()) {
                this.freqMap.remove(node.getFreq());
            }
        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}