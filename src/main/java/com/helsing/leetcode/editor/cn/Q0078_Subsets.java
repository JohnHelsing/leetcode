//给你一个整数数组 nums ，数组中的元素 互不相同 。
// 返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 👍 1502 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.*;

public class Q0078_Subsets {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        solution.subsets(nums);
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> trackList = new LinkedList<>();

        public List<List<Integer>> subsets(int[] nums) {
            // 标准回溯解法
//            backtracking(nums, 0);
            // 回溯 + DFS
            dfs(nums, 0);
            return ans;
        }

        public void dfs(int[] nums, int i) {
            if (i == nums.length) {
                ans.add(new LinkedList<>(trackList));
                return;
            }
            trackList.add(nums[i]);
            dfs(nums, i + 1);
            trackList.removeLast();
            dfs(nums, i + 1);
        }

        public void backtracking(int[] nums, int start) {
            ans.add(new LinkedList<>(trackList));
            for (int i = start; i < nums.length; i++) {
                trackList.add(nums[i]);
                backtracking(nums, i + 1);
                trackList.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
