//给定一个二进制数组 nums ，如果最多可以翻转一个 0 ，则返回数组中连续 1 的最大个数。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,1,1,0]
//输出：4
//解释：翻转第一个 0 可以得到最长的连续 1。
//     当翻转以后，最大连续 1 的个数为 4。
// 
//
// 示例 2: 
//
// 
//输入：nums = [1,0,1,1,0,1]
//输出：4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1. 
// 
//
// 
//
// 进阶：如果输入的数字是作为 无限流 逐个输入如何处理？换
// 句话说，内存不能存储下所有从流中输入的数字。您可以有效地解决吗？
// Related Topics 数组 动态规划 滑动窗口 👍 93 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0487_MaxConsecutiveOnesIi {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
//            return slideWindow(nums);
            return dp(nums);
        }

        private int dp(int[] nums) {
            int n = nums.length, ans = 0, dp0 = 0, dp1 = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] == 1) {
                    dp1++;
                    dp0++;
                } else {
                    dp1 = dp0 + 1;
                    dp0 = 0;
                }
                ans = Math.max(ans, Math.max(dp0, dp1));
            }
            return ans;
        }

        public int slideWindow(int[] nums) {
            int l = 0, r = 0;
            int ans = 0, n = nums.length;
            boolean flag = true;
            int t = 0;
            while (r < n) {
                if (nums[r] == 0) {
                    if (flag) {
                        flag = false;
                    } else {
                        ans = Math.max(ans, r - l);
                        l = t + 1;
                    }
                    t = r;
                }
                r++;
            }
            ans = Math.max(ans, r - l);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
