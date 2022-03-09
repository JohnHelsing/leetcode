//以数组 intervals 表示若干个区间的集合，
// 其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回
// 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics 数组 排序 👍 1363 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0056_MergeIntervals {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[0][2];
            }

            List<int[]> ansList = new ArrayList<>();
            Arrays.sort(intervals, (a, b) -> {
                return a[0] - b[0];
            });
            int[] a = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                int[] b = intervals[i];
                if (a[1] < b[0]) {
                    ansList.add(a);
                    a = b;
                    continue;
                }
                if (a[1] <= b[1]) {
                    a[1] = b[1];
                }
            }
            ansList.add(a);
            int[][] ans = new int[ansList.size()][2];
            for (int i = 0; i < ansList.size(); i++) {
                ans[i] = ansList.get(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
