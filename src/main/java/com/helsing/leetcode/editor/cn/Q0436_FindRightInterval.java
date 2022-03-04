//给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，
// 且每个 starti 都 不同 。
//
// 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。 
//
// 返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。
// 如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,2]]
//输出：[-1]
//解释：集合中只有一个区间，所以输出-1。
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[3,4],[2,3],[1,2]]
//输出：[-1,0,1]
//解释：对于 [3,4] ，没有满足条件的“右侧”区间。
//对于 [2,3] ，区间[3,4]具有最小的“右”起点;
//对于 [1,2] ，区间[2,3]具有最小的“右”起点。
// 
//
// 示例 3： 
//
// 
//输入：intervals = [[1,4],[2,3],[3,4]]
//输出：[-1,2,-1]
//解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
//对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 2 * 10⁴ 
// intervals[i].length == 2 
// -10⁶ <= starti <= endi <= 10⁶ 
// 每个间隔的起点都 不相同 
// 
// Related Topics 数组 二分查找 排序 👍 99 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Arrays;

public class Q0436_FindRightInterval {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findRightInterval(int[][] intervals) {
            int len = intervals.length;
            int[] ans = new int[len];
            int[][] info = new int[len][2];
            for (int i = 0; i < len; i++) {
                info[i][0] = intervals[i][0];
                info[i][1] = i;
            }
            Arrays.sort(info, (a, b) -> a[0] - b[0]);
            for (int i = 0; i < len; i++) {
                int find = intervals[i][1];
                int l = 0, r = len - 1;
                int cur = -1;
                while (l <= r) {
                    int m = l + ((r - l) >> 1);
                    int[] ifo = info[m];
                    if (ifo[0] == find) {
                        cur = ifo[1];
                        break;
                    } else if (ifo[0] > find) {
                        cur = ifo[1];
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
                ans[i] = cur;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
