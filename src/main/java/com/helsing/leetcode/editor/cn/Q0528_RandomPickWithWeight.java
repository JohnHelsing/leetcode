//给你一个 下标从 0 开始 的正整数数组 w ，其中 w[i] 代表第 i 个下标的权重。 
//
// 请你实现一个函数 pickIndex ，它可以 随机地 从范围 [0, w.length - 1]
// 内（含 0 和 w.length - 1）选出并返回一个下标。选取下标 i 的 概率 为 w[i] / sum(w) 。
//
// 
// 
//
// 
// 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 +
// 3) = 0.75（即，75%）。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["Solution","pickIndex"]
//[[[1]],[]]
//输出：
//[null,0]
//解释：
//Solution solution = new Solution([1]);
//solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。 
//
// 示例 2： 
//
// 
//输入：
//["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
//[[[1,3]],[],[],[],[],[]]
//输出：
//[null,1,1,1,1,0]
//解释：
//Solution solution = new Solution([1, 3]);
//solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。
//
//由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:
//[null,1,1,1,1,0]
//[null,1,1,1,1,1]
//[null,1,1,1,0,0]
//[null,1,1,1,0,1]
//[null,1,0,1,0,0]
//......
//诸若此类。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= w.length <= 10⁴ 
// 1 <= w[i] <= 10⁵ 
// pickIndex 将被调用不超过 10⁴ 次 
// 
// Related Topics 数学 二分查找 前缀和 随机化 👍 206 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Random;

public class Q0528_RandomPickWithWeight {

    public static void main(String[] args) {
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Random random = new Random();
        private int[] preSum;
        private int n;

        public Solution(int[] w) {
            this.n = w.length;
            // 前缀数组，下标0就是原数组w[0]
            preSum = new int[n];
            preSum[0] = w[0];
            for (int i = 1; i < n; i++) {
                preSum[i] = preSum[i - 1] + w[i];
            }
        }

        public int pickIndex() {
            // 保证取到[1, preSum[n-1]]的闭区间
            int target = random.nextInt(preSum[n - 1]) + 1;
            // right可以从n-1开始，也可以从n开始，对结果的正确性没有影响
            int left = 0, right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 如果找到了，直接去当前的下标
                if (preSum[mid] == target) {
                    left = mid;
                    break;
                } else if (preSum[mid] > target) {
                    // 向左找，因为当前mid的值大于target，可能是"第一个大于target"的值，所以不能丢弃mid
                    // 如果mid的值不再需要了(最终不会取到现在的mid)，那么就可以right=mid-1；
                    right = mid;
                } else {
                    // 向右找，因为当前的mid的值比target小，永远不会取到了。所以left=mid+1;
                    left = mid + 1;
                }
            }
            // left代表的含义：
            // 当目标元素 target 不存在数组 nums 中时，
            // 搜索左侧边界的二分搜索的返回值可以做以下几种解读：
            // 1、返回的这个值是 nums 中大于等于 target 的最小元素索引。
            // 2、返回的这个值是 target 应该插入在 nums 中的索引位置。
            // 3、返回的这个值是 nums 中小于 target 的元素个数。
            return left;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
