//你有两个 有序 且数组内元素互不相同的数组 nums1 和 nums2 。 
//
// 一条 合法路径 定义如下： 
//
// 
// 选择数组 nums1 或者 nums2 开始遍历（从下标 0 处开始）。 
// 从左到右遍历当前数组。 
// 如果你遇到了 nums1 和 nums2 中都存在的值，那么你可以切换路径到另一个数组对应数字处继续遍历（但在合法路径中重复数字只会被统计一次）。 
// 
//
// 得分定义为合法路径中不同数字的和。 
//
// 请你返回所有可能合法路径中的最大得分。 
//
// 由于答案可能很大，请你将它对 10^9 + 7 取余后返回。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：nums1 = [2,4,5,8,10], nums2 = [4,6,8,9]
//输出：30
//解释：合法路径包括：
//[2,4,5,8,10], [2,4,5,8,9], [2,4,6,8,9], [2,4,6,8,10],（从 nums1 开始遍历）
//[4,6,8,9], [4,5,8,10], [4,5,8,9], [4,6,8,10]  （从 nums2 开始遍历）
//最大得分为上图中的绿色路径 [2,4,6,8,10] 。
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,3,5,7,9], nums2 = [3,5,100]
//输出：109
//解释：最大得分由路径 [1,3,5,100] 得到。
// 
//
// 示例 3： 
//
// 输入：nums1 = [1,2,3,4,5], nums2 = [6,7,8,9,10]
//输出：40
//解释：nums1 和 nums2 之间无相同数字。
//最大得分由路径 [6,7,8,9,10] 得到。
// 
//
// 示例 4： 
//
// 输入：nums1 = [1,4,5,8,9,11,19], nums2 = [2,3,4,11,12]
//输出：61
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 10^5 
// 1 <= nums2.length <= 10^5 
// 1 <= nums1[i], nums2[i] <= 10^7 
// nums1 和 nums2 都是严格递增的数组。 
// 
// Related Topics 贪心 数组 双指针 动态规划 
// 👍 45 👎 0

package com.helsing.leetcode.editor.cn;

public class Q1537_GetTheMaximumScore {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSum(int[] nums1, int[] nums2) {
            // 双指针
//            return doublePoint(nums1, nums2);
            // 动态规划
            return doublePoint(nums1, nums2);

        }

        public int dp(int[] nums1, int[] nums2) {
            final int MOD = 1000000007;
            int m = nums1.length;
            int n = nums2.length;
            long best1 = 0, best2 = 0;
            int i = 0, j = 0;
            while (i < m || j < n) {
                if (i < m && j < n) {
                    if (nums1[i] < nums2[j]) {
                        best1 += nums1[i];
                        i++;
                    } else if (nums1[i] > nums2[j]) {
                        best2 += nums2[j];
                        j++;
                    } else {
                        long best = Math.max(best1, best2) + nums1[i];
                        best1 = best2 = best;
                        i++;
                        j++;
                    }
                } else if (i < m) {
                    best1 += nums1[i];
                    i++;
                } else if (j < n) {
                    best2 += nums2[j];
                    j++;
                }
            }
            return (int) (Math.max(best1, best2) % MOD);
        }

        public int doublePoint(int[] nums1, int[] nums2) {
            int n1 = nums1.length, n2 = nums2.length;
            int i = 0, j = 0;
            long r1 = 0, r2 = 0;
            while (true) {
                if (i != n1 && j != n2) {
                    int num1 = nums1[i], num2 = nums2[j];
                    if (num1 < num2) {
                        r1 += num1;
                        i++;
                    } else if (num1 > num2) {
                        r2 += num2;
                        j++;
                    } else {
                        long t1 = r1 + num1;
                        long t2 = r2 + num2;
                        r1 = Math.max(t1, t2);
                        r2 = Math.max(t2, t1);
                        i++;
                        j++;
                    }
                } else if (i == n1) {
                    while (j < n2) {
                        r2 += nums2[j++];
                    }
                    break;
                } else {
                    while (i < n1) {
                        r1 += nums1[i++];
                    }
                    break;
                }
            }
            return (int) (Math.max(r1, r2) % (int) (1E9 + 7));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}