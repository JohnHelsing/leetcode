//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治 
// 👍 4577 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0004_MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1, 2, 3};
        int[] b = {0,0,0,0,1};
        System.out.println(solution.findMedianSortedArrays(a, b));
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // 二分查找 分别找两个数组的中位数
            Double n1 = getOne(nums1);
            Double n2 = getOne(nums2);
            if (n1 == null) {
                return n2;
            } else if (n2 == null) {
                return n1;
            } else {
                return (n1 + n2) / 2.0;
            }
        }

        public double dis(int[] nums1, int[] nums2) {
            return 0;
        }

        public Double getOne(int[] nums) {
            if (nums.length == 0) {
                return null;
            }
            if (nums.length == 1) {
                return (double) nums[0];
            }
            if (nums.length % 2 != 0) {
                return (double) nums[nums.length / 2];
            } else {
                int i = nums.length / 2;
                return (nums[i] + nums[i - 1]) / 2.0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}