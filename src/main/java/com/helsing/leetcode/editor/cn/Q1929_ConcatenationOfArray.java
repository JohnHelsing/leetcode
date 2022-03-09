//给你一个长度为 n 的整数数组 nums 。
// 请你构建一个长度为 2n 的答案数组 ans ，数组下标 从 0 开始计数 ，对于所有 0 <= i < n 的
// i ，满足下述所有要求： 
//
// 
// ans[i] == nums[i] 
// ans[i + n] == nums[i] 
// 
//
// 具体而言，ans 由两个 nums 数组 串联 形成。 
//
// 返回数组 ans 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,1]
//输出：[1,2,1,1,2,1]
//解释：数组 ans 按下述方式形成：
//- ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
//- ans = [1,2,1,1,2,1] 
//
// 示例 2： 
//
// 
//输入：nums = [1,3,2,1]
//输出：[1,3,2,1,1,3,2,1]
//解释：数组 ans 按下述方式形成：
//- ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
//- ans = [1,3,2,1,1,3,2,1]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 1000 
// 1 <= nums[i] <= 1000 
// 
// Related Topics 数组 👍 21 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Arrays;

public class Q1929_ConcatenationOfArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getConcatenation(int[] nums) {
            int[] ans = Arrays.copyOf(nums, nums.length * 2);
            for (int i = 0; i < nums.length; i++) {
                ans[i + nums.length] = ans[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
