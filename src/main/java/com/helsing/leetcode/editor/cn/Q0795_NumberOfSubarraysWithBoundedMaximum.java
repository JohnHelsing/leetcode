//给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。 
//
// 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。 
//
// 例如 :
//输入: 
//A = [2, 1, 4, 3]
//L = 2
//R = 3
//输出: 3
//解释: 满足条件的子数组: [2], [2, 1], [3].
// 
//
// 注意: 
//
// 
// L, R 和 A[i] 都是整数，范围在 [0, 10^9]。 
// 数组 A 的长度范围在[1, 50000]。 
// 
// Related Topics 数组 双指针 
// 👍 155 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0795_NumberOfSubarraysWithBoundedMaximum {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayBoundedMax(int[] A, int L, int R) {
            return count(A, R) - count(A, L - 1);
        }

        public int count(int[] A, int bound) {
            int ans = 0, cur = 0;
            for (int x : A) {
                cur = x <= bound ? cur + 1 : 0;
                ans += cur;
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}