//RandomizedCollection 是一种包含数字集合(可能是重复的)的数据结构。
// 它应该支持插入和删除特定元素，以及删除随机元素。
//
// 实现 RandomizedCollection 类: 
//
// 
// RandomizedCollection()初始化空的 RandomizedCollection 对象。 
// bool insert(int val) 将一个 val 项插入到集合中，即使该项已经存在。
// 如果该项不存在，则返回 true ，否则返回 false 。
//
// bool remove(int val) 如果存在，从集合中移除一个 val 项。
// 如果该项存在，则返回 true ，否则返回 false 。注意，如果val 在集合中出现多次，我们只删除其中一个。
// int getRandom() 从当前的多个元素集合中返回一个随机元素。
// 每个元素被返回的概率与集合中包含的相同值的数量 线性相关 。
// 
//
// 您必须实现类的函数，使每个函数的 平均 时间复杂度为 O(1) 。 
//
// 注意：生成测试用例时，只有在 RandomizedCollection 中 至少有一项 时，才会调用 getRandom 。 
//
// 
//
// 示例 1: 
//
// 
//输入
//["RandomizedCollection", "insert", "insert", "insert", "getRandom", "remove", 
//"getRandom"]
//[[], [1], [1], [2], [], [1], []]
//输出
//[null, true, false, true, 2, true, 1]
//
//解释
//RandomizedCollection collection = new RandomizedCollection();// 初始化一个空的集合。
//collection.insert(1);// 向集合中插入 1 。返回 true 表示集合不包含 1 。
//collection.insert(1);// 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
//collection.insert(2);// 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
//collection.getRandom();// getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
//collection.remove(1);// 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
//collection.getRandom();// getRandom 应有相同概率返回 1 和 2 。
// 
//
// 
//
// 提示: 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// insert, remove 和 getRandom 最多 总共 被调用 2 * 10⁵ 次 
// 当调用 getRandom 时，数据结构中 至少有一个 元素 
// 
// Related Topics 设计 数组 哈希表 数学 随机化 👍 239 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.*;

public class Q0381_InsertDeleteGetrandomO1DuplicatesAllowed {

    public static void main(String[] args) {
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedCollection {
        Map<Integer, Set<Integer>> idx;
        List<Integer> nums;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            idx = new HashMap<>();
            nums = new ArrayList<>();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            nums.add(val);
            Set<Integer> set = idx.getOrDefault(val, new HashSet<>());
            set.add(nums.size() - 1);
            idx.put(val, set);
            return set.size() == 1;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            if (!idx.containsKey(val)) {
                return false;
            }
            Iterator<Integer> it = idx.get(val).iterator();
            int i = it.next();
            int lastNum = nums.get(nums.size() - 1);
            nums.set(i, lastNum);
            idx.get(val).remove(i);
            idx.get(lastNum).remove(nums.size() - 1);
            if (i < nums.size() - 1) {
                idx.get(lastNum).add(i);
            }
            if (idx.get(val).size() == 0) {
                idx.remove(val);
            }
            nums.remove(nums.size() - 1);
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            return nums.get((int) (Math.random() * nums.size()));
        }
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
