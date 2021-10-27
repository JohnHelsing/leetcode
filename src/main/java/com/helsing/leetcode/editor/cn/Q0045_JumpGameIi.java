//给你一个非负整数数组 nums ，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 104 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 1242 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0045_JumpGameIi {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            // 性能优化
            if (nums.length < 2) {
                return nums.length - 1;
            }

            // 动态规划
            return dp(nums);
        }

        public int dp(int[] nums) {
            int maxI = 0, length = nums.length;
            int[] dp = new int[length + 1];
            dp[0] = 0;
            for (int i = 0; i < length + 1; i++) {
                maxI = Math.max(nums[i] + i, maxI);
                // 当某一时刻能够达到最大下标时，直接进入最大下标，避免不必要的循环
                if (maxI >= length - 1) {
                    dp[length - 1] =
                            dp[length - 1] == 0 ? dp[i] + 1 : Math.min(dp[length - 1], dp[i] + 1);
                    return dp[length - 1];
                }
                // 每次从当前结点出发，遍历每一个能达到的结点，并更新他们的dp值
                for (int j = i + 1; j <= i + nums[i] && j < length; j++) {
                    dp[j] =
                            dp[j] == 0 ? dp[i] + 1 : Math.min(dp[j], dp[i] + 1);
                }
            }
            return dp[length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}