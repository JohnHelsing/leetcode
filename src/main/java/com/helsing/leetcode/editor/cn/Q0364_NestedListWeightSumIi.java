//给你一个整数嵌套列表 nestedList ，每一个元素要么是一个整数，要么是一个列表（这个列表中的每个元素也同样是整数或列表）。 
//
// 整数的 深度 取决于它位于多少个列表内部。例如，嵌套列表 [1,[2,2],[[3],2],1] 的每个整数的值都等于它的 深度 。令 maxDepth 
//是任意整数的 最大深度 。 
//
// 整数的 权重 为 maxDepth - (整数的深度) + 1 。 
//
// 将 nestedList 列表中每个整数先乘权重再求和，返回该加权和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nestedList = [[1,1],2,[1,1]]
//输出：8
//解释：4 个 1 在深度为 1 的位置， 一个 2 在深度为 2 的位置。
//1*1 + 1*1 + 2*2 + 1*1 + 1*1 = 8
// 
//
// 示例 2： 
//
// 
//输入：nestedList = [1,[4,[6]]]
//输出：17
//解释：一个 1 在深度为 3 的位置， 一个 4 在深度为 2 的位置，一个 6 在深度为 1 的位置。 
//1*3 + 4*2 + 6*1 = 17
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nestedList.length <= 50 
// 嵌套列表中整数的值在范围 [-100, 100] 
// 任意整数的最大 深度 小于等于 50 
// 
// Related Topics 栈 深度优先搜索 广度优先搜索 
// 👍 74 👎 0

package com.helsing.leetcode.editor.cn;

import com.helsing.leetcode.common.bean.NestedInteger;

import java.util.List;

public class Q0364_NestedListWeightSumIi {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
    class Solution {
        public int depthSumInverse(List<NestedInteger> nestedList) {
            // dfs + 缓存深度
            return dfs(nestedList, deep(nestedList));
        }

        private int dfs(List<NestedInteger> nestedList, int deep) {
            int sum = 0;
            for (NestedInteger e : nestedList) {
                if (e.isInteger()) {
                    sum += e.getInteger() * deep;
                } else {
                    sum += dfs(e.getList(), deep - 1);
                }
            }
            return sum;
        }

        private int deep(List<NestedInteger> l) {
            int dep = 1;
            for (NestedInteger e : l) {
                if (!e.isInteger()) {
                    dep = Math.max(dep, deep(e.getList()) + 1);
                }
            }
            return dep;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}