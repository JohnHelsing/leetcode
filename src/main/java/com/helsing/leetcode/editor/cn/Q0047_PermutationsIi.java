//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 957 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q0047_PermutationsIi {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1, 1, 2};
        solution.permuteUnique(a);
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            // 路径 选择条件 结束条件
            LinkedList<Integer> trackList = new LinkedList<>();
            // 「路径」中的元素会被标记为 true，避免重复使用
            boolean[] used = new boolean[nums.length];
            // 要保证数据不被重复使用功能
            Arrays.sort(nums);
            backtracking(nums, ans, 0, trackList, used);
            return ans;
        }

        public void backtracking(int[] nums, List<List<Integer>> ans,
                                 int idx, List<Integer> perm, boolean[] used) {
            if (idx == nums.length) {
                ans.add(new ArrayList<Integer>(perm));
                return;
            }
            for (int i = 0; i < nums.length; ++i) {
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                    continue;
                }
                perm.add(nums[i]);
                used[i] = true;
                backtracking(nums, ans, idx + 1, perm, used);
                used[i] = false;
                perm.remove(idx);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
