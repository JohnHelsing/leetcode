//请你实现一个数据结构支持以下操作： 
//
// 
// Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。 
// Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否则使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任
//何事情。key 保证不为空字符串。 
// GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串"" 。 
// GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。 
// 
//
// 
//
// 挑战： 
//
// 你能够以 O(1) 的时间复杂度实现所有操作吗？ 
// Related Topics 设计 哈希表 链表 双向链表 
// 👍 108 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q0432_AllOoneDataStructure {

    public static void main(String[] args) {
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class AllOne {

        class DLinkedNode {
            int val;
            Set<String> keys;
            DLinkedNode pre, next;

            public DLinkedNode(int val) {
                this.val = val;
                this.keys = new HashSet<>();
            }
        }

        // map1保存key-.value 的映射
        private Map<String, Integer> map1;
        // map2保存val->keys 的映射， DLinkedNode为双向链表节点
        // map2的作用是为了O(1)时间拿到统计次数对应的链表节点
        // 链表中的所有操作只会涉及到前一个节点或者后一个节点，时间也为O(1)
        private Map<Integer, DLinkedNode> map2;
        // 双向链表的头， 双向链表从head到tail的value值依次减小
        private DLinkedNode head;
        // 双向链表的尾
        private DLinkedNode tail;

        /**
         * Initialize your data structure here.
         */
        public AllOne() {
            map1 = new HashMap<>();
            map2 = new HashMap<>();
            head = new DLinkedNode(0);
            tail = new DLinkedNode(0);
            head.next = tail;
            tail.pre = head;
        }

        /**
         * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
         */
        public void inc(String key) {
            // 如果map1中包含key
            if (map1.containsKey(key)) {
                int val = map1.get(key);
                map1.put(key, val + 1);
                // 根据value拿到次数更新前的node
                DLinkedNode node = map2.get(val);
                // value加一后，从原node的Set中删除key
                node.keys.remove(key);
                DLinkedNode preNode = node.pre;
                // 当前一个node为head或前一个node的次数统计大于val+1时，
                // 表示还目前没有统计次数为val+1的key，
                // 此时应该新建一个DLinkedNode，将newNode插入到preNode和node之间，并把key加入到newNode的保存key的Set中
                // 同时，将新的统计次数（val+1）和新节点newNode的映射加入到map2中
                if (preNode == head || preNode.val > val + 1) {
                    DLinkedNode newNode = new DLinkedNode(val + 1);
                    newNode.keys.add(key);
                    newNode.next = node;
                    newNode.pre = preNode;
                    preNode.next = newNode;
                    node.pre = newNode;
                    map2.put(val + 1, newNode);
                    preNode = newNode;
                } else {    // 如果当前已经有统计次数为val+1的节点，只需key加入到Set中即可
                    preNode.keys.add(key);
                }
                // 如果原节点在移除key后size为0，则删除该节点，并在map2中删除val->node的映射
                if (node.keys.size() == 0) {
                    preNode.next = node.next;
                    node.next.pre = preNode;
                    map2.remove(val);
                }
            } else {    // map1中不包含key
                map1.put(key, 1);
                DLinkedNode node = map2.get(1);
                // 如果当前没有统计次数为1的节点，则新建节点并插入到双向链表的尾部，因为统计次数最小为1
                // 并将1->newNode的映射加入到map2中
                if (node == null) {
                    DLinkedNode newNode = new DLinkedNode(1);
                    newNode.keys.add(key);
                    newNode.next = tail;
                    newNode.pre = tail.pre;
                    tail.pre.next = newNode;
                    tail.pre = newNode;
                    map2.put(1, newNode);
                } else {
                    node.keys.add(key);
                }
            }
        }

        /**
         * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
         */
        public void dec(String key) {
            // 如果map1中包含key,进行处理，否则不做任何操作
            if (map1.containsKey(key)) {
                // 获取当前统计次数
                int val = map1.get(key);
                // 当前统计次数对应的节点
                DLinkedNode node = map2.get(val);
                // 从节点的keys set中移除当前key
                node.keys.remove(key);
                // 如果原统计次数为1，从map1中移除当前key
                if (val == 1) {
                    map1.remove(key);
                } else {
                    // 更新map1中的统计次数
                    map1.put(key, val - 1);
                    // 拿到当前节点的下一个节点
                    DLinkedNode nextNode = node.next;
                    // 如果下一个节点为链表尾部或下一个节点的统计次数小于val-1
                    // 则新建一个节点，统计次数为val-1，将当前key加入到keys Set中
                    // 并将新节点插入到当前节点的后面，同时更新map2
                    if (nextNode == tail || nextNode.val < val - 1) {
                        DLinkedNode newNode = new DLinkedNode(val - 1);
                        newNode.keys.add(key);
                        newNode.pre = node;
                        newNode.next = nextNode;
                        node.next = newNode;
                        nextNode.pre = newNode;
                        map2.put(val - 1, newNode);
                    } else {    // 下一个节点的统计次数为val-1，将key加到下一节点的keys Set中
                        nextNode.keys.add(key);
                    }
                }
                // 如果当前节点只包含这一个key，删除后size为0，则将当前节点删除，并更新map2
                if (node.keys.size() == 0) {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                    map2.remove(val);
                }
            }
        }

        /**
         * Returns one of the keys with maximal value.
         */
        public String getMaxKey() {
            // 按照双向链表的定义，如果链表中存在节点（head和tail不算，dummy节点），则对应最大value的keys为head的下一个节点
            if (head.next == tail) {
                return "";
            } else {
                return head.next.keys.iterator().next();
            }
        }

        /**
         * Returns one of the keys with Minimal value.
         */
        public String getMinKey() {
            // 按照双向链表的定义，如果链表中存在节点（head和tail不算，dummy节点），则对应最小value的keys为tail的前一个节点
            if (tail.pre == head) {
                return "";
            } else {
                return tail.pre.keys.iterator().next();
            }
        }

    }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
//leetcode submit region end(Prohibit modification and deletion)

}