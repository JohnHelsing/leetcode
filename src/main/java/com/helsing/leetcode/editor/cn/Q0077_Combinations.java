//给定两个整数 n 和 k，返回范围 [1, n]
// 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 👍 882 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q0077_Combinations {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans;
        LinkedList<Integer> trackList = new LinkedList<>();

        public List<List<Integer>> combine(int n, int k) {
            ans = new ArrayList<>();
            backtracking(n, k, 1);
            return ans;
        }

        private void backtracking(int n, int k, int start) {
            // 回溯停止条件
            if (trackList.size() == k) {
                ans.add(new ArrayList<>(trackList));
                return;
            }
            for (int i = start; i <= n; i++) {
                trackList.add(i);
                backtracking(n, k, i + 1);
                trackList.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
