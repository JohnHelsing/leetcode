//给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3, 2, 1]
//输出：1
//解释：第三大的数是 1 。 
//
// 示例 2： 
//
// 
//输入：[1, 2]
//输出：2
//解释：第三大的数不存在, 所以返回最大的数 2 。
// 
//
// 示例 3： 
//
// 
//输入：[2, 2, 3, 1]
//输出：1
//解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
//此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？ 
// Related Topics 数组 排序 👍 345 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0414_ThirdMaximumNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int thirdMax(int[] nums) {
            Integer a = null, b = null, c = null;
            for (int num : nums) {
                if (a == null || num > a) {
                    c = b;
                    b = a;
                    a = num;
                } else if (a > num && (b == null || num > b)) {
                    c = b;
                    b = num;
                } else if (b != null && b > num && (c == null || num > c)) {
                    c = num;
                }
            }
            return c == null ? a : c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
