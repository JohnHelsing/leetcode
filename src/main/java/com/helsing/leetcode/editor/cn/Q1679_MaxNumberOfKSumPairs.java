//给你一个整数数组 nums 和一个整数 k 。 
//
// 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。 
//
// 返回你可以对数组执行的最大操作数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4], k = 5
//输出：2
//解释：开始时 nums = [1,2,3,4]：
//- 移出 1 和 4 ，之后 nums = [2,3]
//- 移出 2 和 3 ，之后 nums = []
//不再有和为 5 的数对，因此最多执行 2 次操作。 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,3,4,3], k = 6
//输出：1
//解释：开始时 nums = [3,1,3,4,3]：
//- 移出前两个 3 ，之后nums = [1,4,3]
//不再有和为 6 的数对，因此最多执行 1 次操作。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 109 
// 1 <= k <= 109 
// 
// Related Topics 数组 哈希表 双指针 排序 
// 👍 19 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Arrays;

public class Q1679_MaxNumberOfKSumPairs {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxOperations(int[] nums, int k) {
            // 双指针
            return doublePoint(nums, k);
        }

        public int doublePoint(int[] nums, int k) {
            int result = 0;
            //排序
            Arrays.sort(nums);
            //头尾指针
            int i = 0, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j];
                if (k == sum) {//刚好相等。两个指针都往中间移动
                    result++;
                    i++;
                    j--;
                } else if (k > sum) {//两数之和太小，左指针右移，让和变大
                    i++;
                } else {//两数之和太大，右指针左移，让和变小
                    j--;
                }
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}