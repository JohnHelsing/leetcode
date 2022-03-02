//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 1797 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q0046_Permutations {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            // 回溯法
            List<List<Integer>> ans = new ArrayList<>();
            // 记录「路径」
            LinkedList<Integer> track = new LinkedList<>();
            // 「路径」中的元素会被标记为 true，避免重复使用
            boolean[] used = new boolean[nums.length];
            backtracking(ans, nums, track, used);
            return ans;
        }

        /**
         * // 路径：记录在 track 中
         * // 选择列表：nums 中不存在于 track 的那些元素
         * // 结束条件：nums 中的元素全都在 track 中出现         * @param ans
         *
         * @param nums
         * @param track 路径
         * @param used
         * @return
         */
        public void backtracking(List<List<Integer>> ans,
                                 int[] nums, LinkedList<Integer> track,
                                 boolean[] used) {
            // 触发结束条件
            if (track.size() == nums.length) {
                ans.add(new LinkedList<>(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                // 排除不合法的选择
                if (used[i]) {
                    // nums[i] 已经在 track 中，跳过
                    continue;
                }
                // 做选择
                track.add(nums[i]);
                used[i] = true;
                // 进入下一层决策树
                backtracking(ans, nums, track, used);
                // 取消选择
                track.removeLast();
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
