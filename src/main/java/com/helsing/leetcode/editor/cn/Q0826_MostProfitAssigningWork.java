package com.helsing.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
//
// 现在我们有一些工人。worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。 
//
// 每一个工人都最多只能安排一个工作，但是一个工作可以完成多次。 
//
// 举个例子，如果 3 个工人都尝试完成一份报酬为 1 的同样工作，那么总收益为 $3。如果一个工人不能完成任何工作，他的收益为 $0 。 
//
// 我们能得到的最大收益是多少？ 
//
// 
//
// 示例 1： 
//
// 
//输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
//输出: 100 
//解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。 
//
// 示例 2: 
//
// 
//输入: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
//输出: 0 
//
// 
//
// 提示: 
//
// 
// n == difficulty.length 
// n == profit.length 
// m == worker.length 
// 1 <= n, m <= 104 
// 1 <= difficulty[i], profit[i], worker[i] <= 105 
// 
// Related Topics 贪心 数组 双指针 二分查找 排序 
// 👍 69 👎 0

public class Q0826_MostProfitAssigningWork {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
            int N = difficulty.length;
            int[][] jobs = new int[N][2];
            for (int i = 0; i < N; ++i) {
                jobs[i][0] = difficulty[i];
                jobs[i][1] = profit[i];
            }
            Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));
            Arrays.sort(worker);

            int ans = 0, i = 0, best = 0;
            for (int skill : worker) {
                while (i < N && skill >= jobs[i][0]) {
                    best = Math.max(best, jobs[i++][1]);
                }
                ans += best;
            }

            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}