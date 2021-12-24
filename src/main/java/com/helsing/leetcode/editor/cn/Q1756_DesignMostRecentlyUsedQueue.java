//设计一种类似队列的数据结构，该数据结构将最近使用的元素移到队列尾部。 
//
// 实现 MRUQueue 类： 
//
// 
// MRUQueue(int n) 使用 n 个元素： [1,2,3,...,n] 构造 MRUQueue 。 
// fetch(int k) 将第 k 个元素（从 1 开始索引）移到队尾，并返回该元素。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["MRUQueue", "fetch", "fetch", "fetch", "fetch"]
//[[8], [3], [5], [2], [8]]
//输出：
//[null, 3, 6, 2, 2]
//
//解释：
//MRUQueue mRUQueue = new MRUQueue(8); // 初始化队列为 [1,2,3,4,5,6,7,8]。
//mRUQueue.fetch(3); // 将第 3 个元素 (3) 移到队尾，使队列变为 [1,2,4,5,6,7,8,3] 并返回该元素。
//mRUQueue.fetch(5); // 将第 5 个元素 (6) 移到队尾，使队列变为 [1,2,4,5,7,8,3,6] 并返回该元素。
//mRUQueue.fetch(2); // 将第 2 个元素 (2) 移到队尾，使队列变为 [1,4,5,7,8,3,6,2] 并返回该元素。
//mRUQueue.fetch(8); // 第 8 个元素 (2) 已经在队列尾部了，所以直接返回该元素即可。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2000 
// 1 <= k <= n 
// 最多调用 2000 次 fetch 
// 
//
// 
//进阶：找到每次 fetch 的复杂度为 O(n) 的算法比较简单。
// 你可以找到每次 fetch 的复杂度更佳的算法吗？ Related Topics 栈 设计
// 树状数组 数组 哈希表 有序集合 👍 1 👎 0

package com.helsing.leetcode.editor.cn;

public class Q1756_DesignMostRecentlyUsedQueue {

    public static void main(String[] args) {
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class MRUQueue {
        int[] queue;

        public MRUQueue(int n) {
            queue = new int[n];
            for (int i = 0; i < n; i++) {
                queue[i] = i + 1;
            }
        }

        public int fetch(int k) {
            int value = queue[k - 1];
            if (queue.length - 1 - (k - 1) >= 0) {
                System.arraycopy(queue, k - 1 + 1, queue,
                        k - 1, queue.length - 1 - (k - 1));
            }
            queue[queue.length - 1] = value;
            return value;
        }
    }

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
