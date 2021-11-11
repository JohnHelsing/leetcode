//给定一个形如 “HH:MM” 表示的时刻，利用当前出现过的数字构造下一个距离当前时间最近的时刻。每个出现数字都可以被无限次使用。 
//
// 你可以认为给定的字符串一定是合法的。例如，“01:34” 和 “12:09” 是合法的，“1:34” 和 “12:9” 是不合法的。 
//
// 
//
// 样例 1: 
//
// 输入: "19:34"
//输出: "19:39"
//解释: 利用数字 1, 9, 3, 4 构造出来的最近时刻是 19:39，是 5 分钟之后。结果不是 19:33 因为这个时刻是 23 小时 59 分钟之后
//。
// 
//
// 
//
// 样例 2: 
//
// 输入: "23:59"
//输出: "22:22"
//解释: 利用数字 2, 3, 5, 9 构造出来的最近时刻是 22:22。 答案一定是第二天的某一时刻，所以选择可构造的最小时刻。
// 
//
// 
// Related Topics 字符串 枚举 
// 👍 50 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Q0681_NextClosestTime {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String nextClosestTime(String time) {
            String[] arr = time.split(":");
            Set<Character> s = new HashSet();
            s.add(arr[0].charAt(0));
            s.add(arr[0].charAt(1));
            s.add(arr[1].charAt(0));
            s.add(arr[1].charAt(1));
            int hour = Integer.valueOf(arr[0]);
            int minute = Integer.valueOf(arr[1]);
            int minutes = hour * 60 + minute;
            for (int i = minutes + 1; i <= minutes + 24 * 60; i++) {
                String h = "" + (i % (24 * 60)) / 60;
                if (h.length() == 1) {
                    h = "0" + h;
                }
                String m = "" + (i % (24 * 60)) % 60;
                if (m.length() == 1) {
                    m = "0" + m;
                }
                if (s.contains(m.charAt(0)) &&
                        s.contains(m.charAt(1)) &&
                        s.contains(h.charAt(0)) &&
                        s.contains(h.charAt(1))) {
                    return h + ":" + m;
                }
            }
            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}