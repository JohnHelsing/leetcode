//给定一个未排序的整数数组，找到最长递增子序列的个数。 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。 
// Related Topics 树状数组 线段树 数组 动态规划 
// 👍 500 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Arrays;
import java.util.TreeSet;

public class Q0673_NumberOfLongestIncreasingSubsequence {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            // 树状数组
            return treeArray(nums);
        }

        int n = 0;
        int[][] fenwick;

        public int treeArray(int[] nums) {
            // 离散化
            var set = new TreeSet<Integer>();
            for (int num : nums) {
                set.add(num);
            }
            n = set.size();
            fenwick = new int[n + 1][2];
            var record = new int[set.size()];
            int count = 0;
            for (int num : set) {
                record[count++] = num;
            }
            // 开始计算
            for (int num : nums) {
                // 二分得到离散化后的值 （因为内循环时间复杂度已经是O(logN)，用hashmap意义不大）
                int index = Arrays.binarySearch(record, num) + 1;
                // 查询[1, index - 1]的tuple
                var prev = query(index - 1);
                // 加上num自己的长度
                prev[0] += 1;
                // 确保至少出现一次
                prev[1] = Math.max(1, prev[1]);
                // 更新[index, end]
                update(index, prev);
            }
            // 基于贪心: 必然最大的元素存在于最长序列中
            return query(set.size())[1];
        }

        private int lowbit(int x) {
            return x & (-x);
        }

        // 运算的前提假设：b的index 大于 a的index
        private int[] operate(int[] a, int[] b) {
            var ans = new int[]{b[0], b[1]};
            if (a[0] == b[0]) {
                ans[0] = a[0];
                ans[1] = a[1] + b[1];
            } else if (a[0] > b[0]) {
                ans[0] = a[0];
                ans[1] = a[1];
            }
            return ans;
        }

        private int[] query(int index) {
            int[] sum = new int[]{0, 0};
            for (int i = index; i > 0; i -= lowbit(i)) {
                sum = operate(fenwick[i], sum);
            }
            return sum;
        }

        private void update(int index, int[] tuple) {
            for (int i = index; i <= n; i += lowbit(i)) {
                fenwick[i] = operate(tuple, fenwick[i]);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}