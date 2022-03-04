//给定一个候选人编号的集合 candidates 和一个目标数 target ，
// 找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 858 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q0040_CombinationSumIi {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {1, 5, 2, 1, 2};
        solution.combinationSum2(candidates, 6);
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> trackList = new LinkedList<>();
        int sum = 0;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            boolean[] used = new boolean[candidates.length];
            backtracking(candidates, target, 0, used);
            return ans;
        }

        private void backtracking(int[] candidates, int target, int start, boolean[] used) {
            if (sum == target) {
                ans.add(new ArrayList<>(trackList));
                return;
            }
            if (sum > target) {
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    continue;
                }
                if (i > start && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                    continue;
                }
                trackList.add(candidates[i]);
                used[i] = true;
                sum += candidates[i];
                backtracking(candidates, target, i + 1, used);
                int temp = trackList.removeLast();
                sum -= temp;
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
