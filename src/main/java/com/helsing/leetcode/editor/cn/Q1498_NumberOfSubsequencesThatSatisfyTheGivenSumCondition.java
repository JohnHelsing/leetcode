//给你一个整数数组 nums 和一个整数 target 。 
//
// 请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。 
//
// 由于答案可能很大，请将结果对 10^9 + 7 取余后返回。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,5,6,7], target = 9
//输出：4
//解释：有 4 个子序列满足该条件。
//[3] -> 最小元素 + 最大元素 <= target (3 + 3 <= 9)
//[3,5] -> (3 + 5 <= 9)
//[3,5,6] -> (3 + 6 <= 9)
//[3,6] -> (3 + 6 <= 9)
// 
//
// 示例 2： 
//
// 输入：nums = [3,3,6,8], target = 10
//输出：6
//解释：有 6 个子序列满足该条件。（nums 中可以有重复数字）
//[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6] 
//
// 示例 3： 
//
// 输入：nums = [2,3,3,4,6,7], target = 12
//输出：61
//解释：共有 63 个非空子序列，其中 2 个不满足条件（[6,7], [7]）
//有效序列总数为（63 - 2 = 61）
// 
//
// 示例 4： 
//
// 输入：nums = [5,2,4,1,7,6,8], target = 16
//输出：127
//解释：所有非空子序列都满足条件 (2^7 - 1) = 127 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 1 <= target <= 10^6 
// 
// Related Topics 数组 双指针 二分查找 排序 
// 👍 70 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Arrays;

public class Q1498_NumberOfSubsequencesThatSatisfyTheGivenSumCondition {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int P = 1000000007;
        static final int MAX_N = 100005;

        int[] f = new int[MAX_N];

        public int numSubseq(int[] nums, int target) {
            Arrays.sort(nums);
            // 计算贡献
//            return caculateSubmit(nums, target);

            // 双指针
            return doublePoint(nums, target);
        }

        public int caculateSubmit(int[] nums, int target) {
            pretreatment();
            int ans = 0;
            for (int i = 0; i < nums.length && nums[i] * 2 <= target; ++i) {
                int maxValue = target - nums[i];
                int pos = binarySearch(nums, maxValue) - 1;
                int contribute = (pos >= i) ? f[pos - i] : 0;
                ans = (ans + contribute) % P;
            }
            return ans;
        }

        public int doublePoint(int[] nums, int target) {
            int n = nums.length;
            int mod = 1000000007;
            int[] tmp = new int[n];
            tmp[0] = 1;
            for (int i = 1; i < n; i++) {
                tmp[i] = (tmp[i - 1] << 1) % mod;
            }
            int res = 0;
            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                if (nums[l] + nums[r] > target) {
                    r--;
                } else {
                    res = (res + tmp[r - l]) % mod;
                    l++;
                }
            }
            return res;
        }

        public void pretreatment() {
            f[0] = 1;
            for (int i = 1; i < MAX_N; ++i) {
                f[i] = (f[i - 1] << 1) % P;
            }
        }

        public int binarySearch(int[] nums, int target) {
            int low = 0, high = nums.length;
            while (low < high) {
                int mid = (high - low) / 2 + low;
                if (mid == nums.length) {
                    return mid;
                }
                int num = nums[mid];
                if (num <= target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}