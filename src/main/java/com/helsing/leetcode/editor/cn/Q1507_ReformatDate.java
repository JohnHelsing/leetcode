//给你一个字符串 date ，它的格式为 Day Month Year ，其中： 
//
// 
// Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。 
// Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", 
//"Oct", "Nov", "Dec"} 中的一个元素。 
// Year 的范围在 [1900, 2100] 之间。 
// 
//
// 请你将字符串转变为 YYYY-MM-DD 的格式，其中： 
//
// 
// YYYY 表示 4 位的年份。 
// MM 表示 2 位的月份。 
// DD 表示 2 位的天数。 
// 
//
// 
//
// 示例 1： 
//
// 输入：date = "20th Oct 2052"
//输出："2052-10-20"
// 
//
// 示例 2： 
//
// 输入：date = "6th Jun 1933"
//输出："1933-06-06"
// 
//
// 示例 3： 
//
// 输入：date = "26th May 1960"
//输出："1960-05-26"
// 
//
// 
//
// 提示： 
//
// 
// 给定日期保证是合法的，所以不需要处理异常输入。 
// 
// Related Topics 字符串 👍 15 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q1507_ReformatDate {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reformatDate(String date) {
            StringBuilder sb = new StringBuilder(10);
            int length = date.length();
            int index = date.indexOf(' ', 3);
            sb.append(date.charAt(length - 4))
                    .append(date.charAt(length - 3))
                    .append(date.charAt(length - 2))
                    .append(date.charAt(length - 1))
                    .append('-')
                    .append(getMounth(index + 1, date))
                    .append('-');
            if (index == 4) {
                sb.append(date.charAt(0)).append(date.charAt(1));
            } else {
                sb.append('0').append(date.charAt(0));
            }
            return sb.toString();
        }

        private String getMounth(int index, String date) {
            switch (date.charAt(index)) {
                case 'J': {
                    if (date.charAt(index + 1) == 'a') {
                        return "01";
                    } else if (date.charAt(index + 2) == 'n') {
                        return "06";
                    }
                    return "07";
                }
                case 'A': {
                    if (date.charAt(index + 1) == 'u') {
                        return "08";
                    }
                    return "04";
                }
                case 'M': {
                    if (date.charAt(index + 2) == 'r') {
                        return "03";
                    }
                    return "05";
                }
                case 'F':
                    return "02";
                case 'S':
                    return "09";
                case 'O':
                    return "10";
                case 'N':
                    return "11";
                case 'D':
                    return "12";
            }
            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
