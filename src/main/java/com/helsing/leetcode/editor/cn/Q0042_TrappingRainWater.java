//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 2785 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0042_TrappingRainWater {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            // 特判
            if (height.length == 0) {
                return 0;
            }

            // 朴素做法
            // ignore 计算每个height[i]的接水量 = 左边最大---右边最大 O(n^2)

            // 动态规划
//            return dp(height);

            // 双指针
            return twoPointersWithLeftAndRight(height);
        }

        public int twoPointersWithLeftAndRight(int[] height) {
            int ans = 0;
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            while (left < right) {
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);
                // 如果height[left] < height[right]
                // 则必有leftMax<rightMax
                // 下标left处能接的雨水量等于leftMax - height[left]，
                // 将下标left处能接的雨水量加到能接的雨水总量，然后left++
                if (height[left] < height[right]) {
                    ans += leftMax - height[left];
                    left++;
                } else {
                    ans += rightMax - height[right];
                    right--;
                }
            }
            return ans;
        }

        public int dp(int[] height) {
            int ans = 0, n = height.length;
            int[] leftMax = new int[n];
            leftMax[0] = height[0];
            for (int i = 1; i < n; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }

            int[] rightMax = new int[n];
            rightMax[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; --i) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }

            for (int i = 0; i < n; ++i) {
                ans += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}