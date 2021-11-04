//指定年份 Y 和月份 M，请你帮忙计算出该月一共有多少天。 
//
// 
//
// 示例 1： 
//
// 输入：Y = 1992, M = 7
//输出：31
// 
//
// 示例 2： 
//
// 输入：Y = 2000, M = 2
//输出：29
// 
//
// 示例 3： 
//
// 输入：Y = 1900, M = 2
//输出：28
// 
//
// 
//
// 提示： 
//
// 
// 1583 <= Y <= 2100 
// 1 <= M <= 12 
// 
// Related Topics 数学 
// 👍 7 👎 0

package com.helsing.leetcode.editor.cn;

public class Q1118_NumberOfDaysInAMonth {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfDays(int year, int month) {
            int[] year1 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 闰年
            int[] year2 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 非闰年
            if ((year % 100 != 0 && year % 4 == 0) || year % 400 == 0) {
                return year1[month - 1];
            }
            return year2[month - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}