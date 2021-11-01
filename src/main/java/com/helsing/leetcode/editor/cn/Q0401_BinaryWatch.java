//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
// 
//
// 
// 例如，下面的二进制手表读取 "3:25" 。 
// 
//
// 
//
// （图源：WikiMedia - Binary clock samui moon.jpg ，许可协议：Attribution-ShareAlike 3.0 
//Unported (CC BY-SA 3.0) ） 
//
// 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。 
//
// 小时不会以零开头： 
//
// 
// 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。 
// 
//
// 分钟必须由两位数组成，可能会以零开头： 
//
// 
// 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：turnedOn = 1
//输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
// 
//
// 示例 2： 
//
// 
//输入：turnedOn = 9
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= turnedOn <= 10 
// 
// Related Topics 位运算 回溯 
// 👍 332 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q0401_BinaryWatch {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> readBinaryWatch(int turnedOn) {
            List<String> res = new ArrayList<>();
            backtrace(0, 0, 10, turnedOn, res);
            return res;
        }

        private void backtrace(int path, int idx, int len, int total, List<String> res) {
            if (total == 0) {
                String r = convert(path);
                if (!"".equals(r)) {
                    res.add(r);
                }
                return;
            }
            //剪枝
            if (len - idx < total) {
                return;
            }
            //选和不选
            backtrace(path, idx + 1, len, total, res);
            path |= (1 << idx);
            backtrace(path, idx + 1, len, total - 1, res);
        }

        private String convert(int num) {
            int hour = (num & 0b1111000000) >> 6;
            int minute = (num & 0b111111);
            if (hour >= 12) {
                return "";
            }
            if (minute > 59) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(hour + ":");
            if (minute < 10) {
                sb.append("0");
            }
            sb.append(minute);
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}