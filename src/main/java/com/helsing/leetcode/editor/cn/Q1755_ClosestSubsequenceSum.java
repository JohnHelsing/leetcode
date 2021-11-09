//给你一个整数数组 nums 和一个目标值 goal 。 
//
// 你需要从 nums 中选出一个子序列，使子序列元素总和最接近 goal 。也就是说，如果子序列元素和为 sum ，你需要 最小化绝对差 abs(sum -
// goal) 。 
//
// 返回 abs(sum - goal) 可能的 最小值 。 
//
// 注意，数组的子序列是通过移除原始数组中的某些元素（可能全部或无）而形成的数组。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [5,-7,3,5], goal = 6
//输出：0
//解释：选择整个数组作为选出的子序列，元素和为 6 。
//子序列和与目标值相等，所以绝对差为 0 。
// 
//
// 示例 2： 
//
// 输入：nums = [7,-9,15,-2], goal = -5
//输出：1
//解释：选出子序列 [7,-9,-2] ，元素和为 -4 。
//绝对差为 abs(-4 - (-5)) = abs(1) = 1 ，是可能的最小值。
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3], goal = -7
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 40 
// -107 <= nums[i] <= 107 
// -109 <= goal <= 109 
// 
// Related Topics 位运算 数组 双指针 动态规划 状态压缩 
// 👍 54 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Q1755_ClosestSubsequenceSum {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums;

        public int minAbsDifference(int[] nums, int goal) {
            this.nums = nums;
            Set<Integer> left = new HashSet<>();
            Set<Integer> right = new HashSet<>();
            generate(0, 0, nums.length / 2, left);
            generate(nums.length / 2, 0, nums.length, right);
            TreeSet<Integer> set = new TreeSet<>(right);
            int ans = Math.abs(goal);
            for (int l : left) {
                int target = goal - l;
                if (set.contains(target)) {
                    return 0;
                }
                Integer before = set.lower(target);
                Integer after = set.higher(target);
                if (before != null) {
                    ans = Math.min(ans, Math.abs(before + l - goal));
                }
                if (after != null) {
                    ans = Math.min(ans, Math.abs(after + l - goal));
                }
            }
            return ans;
        }

        void generate(int pos, int cur, int end, Set<Integer> set) {
            if (pos == end) {
                set.add(cur);
                return;
            }
            generate(pos + 1, cur, end, set);
            generate(pos + 1, cur + nums[pos], end, set);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}