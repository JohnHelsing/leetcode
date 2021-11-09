//我们称一个分割整数数组的方案是 好的 ，当它满足： 
//
// 
// 数组被分成三个 非空 连续子数组，从左至右分别命名为 left ， mid ， right 。 
// left 中元素和小于等于 mid 中元素和，mid 中元素和小于等于 right 中元素和。 
// 
//
// 给你一个 非负 整数数组 nums ，请你返回 好的 分割 nums 方案数目。由于答案可能会很大，请你将结果对 109 + 7 取余后返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1]
//输出：1
//解释：唯一一种好的分割方案是将 nums 分成 [1] [1] [1] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,2,2,5,0]
//输出：3
//解释：nums 总共有 3 种好的分割方案：
//[1] [2] [2,2,5,0]
//[1] [2,2] [2,5,0]
//[1,2] [2,2] [5,0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,2,1]
//输出：0
//解释：没有好的分割方案。 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 105 
// 0 <= nums[i] <= 104 
// 
// Related Topics 数组 双指针 二分查找 前缀和 
// 👍 61 👎 0

package com.helsing.leetcode.editor.cn;

public class Q1712_WaysToSplitArrayIntoThreeSubarrays {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int waysToSplit(int[] nums) {
            int n = nums.length;
            int[] sum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
            final int MOD = 1000000000 + 7;
            long ans = 0;
            // |______|________|_______|________|
            // 1      i        l       r        n
            // i 表示第一刀的位置，枚举第一刀的位置，计算第二刀的可选位置数
            for (int i = 1, l = 2, r = 2; i <= n - 1; i++) {
                l = Math.max(l, i + 1);
                r = Math.max(r, i + 1);
                // sum(right) >= sum(mid)，r最大为n-1，right保证要有一个数
                while (r <= n - 1 && sum[n] - sum[r] >= sum[r] - sum[i]) {
                    r++;
                }
                // sum(mid) >= sum(left)
                while (l <= n - 1 && sum[l] - sum[i] < sum[i]) {
                    l++;
                }
                if (l <= r) {
                    ans += r - l;
                }
            }
            return (int) (ans % MOD);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}