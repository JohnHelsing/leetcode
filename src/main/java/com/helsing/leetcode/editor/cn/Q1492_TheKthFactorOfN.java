//给你两个正整数 n 和 k 。 
//
// 如果正整数 i 满足 n % i == 0 ，那么我们就说正整数 i 是整数 n 的因子。 
//
// 考虑整数 n 的所有因子，将它们 升序排列 。请你返回第 k 个因子。如果 n 的因子数少于 k ，请你返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12, k = 3
//输出：3
//解释：因子列表包括 [1, 2, 3, 4, 6, 12]，第 3 个因子是 3 。
// 
//
// 示例 2： 
//
// 
//输入：n = 7, k = 2
//输出：7
//解释：因子列表包括 [1, 7] ，第 2 个因子是 7 。
// 
//
// 示例 3： 
//
// 
//输入：n = 4, k = 4
//输出：-1
//解释：因子列表包括 [1, 2, 4] ，只有 3 个因子，所以我们应该返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 1000 
// 
// Related Topics 数学 👍 23 👎 0

package com.helsing.leetcode.editor.cn;

public class Q1492_TheKthFactorOfN {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthFactor(int n, int k) {
//            int count = 0;
//            for (int factor = 1; factor <= n; factor++) {
//                if (n % factor == 0) {
//                    count++;
//                    if (count == k) {
//                        return factor;
//                    }
//                }
//            }
//            return -1;

            // 优化
            int count = 0, factor;
            for (factor = 1; factor * factor <= n; factor++) {
                if (n % factor == 0) {
                    ++count;
                    if (count == k) {
                        return factor;
                    }
                }
            }
            factor--;
            if (factor * factor == n) {
                factor--;
            }
            for (; factor > 0; --factor) {
                if (n % factor == 0) {
                    ++count;
                    if (count == k) {
                        return n / factor;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
