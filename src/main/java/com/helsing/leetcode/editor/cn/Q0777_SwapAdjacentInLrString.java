//在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或
//者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回T
//rue。 
//
// 
//
// 示例 : 
//
// 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
//输出: True
//解释:
//我们可以通过以下几步将start转换成end:
//RXXLRXRXL ->
//XRXLRXRXL ->
//XRLXRXRXL ->
//XRLXXRRXL ->
//XRLXXRRLX
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(start) = len(end) <= 10000。 
// start和end中的字符串仅限于'L', 'R'和'X'。 
// 
// Related Topics 双指针 字符串 
// 👍 103 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0777_SwapAdjacentInLrString {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canTransform(String start, String end) {
            // 双指针
            return twoPointers(start, end);
        }

        public boolean twoPointers(String start, String end) {
            if (start.length() != end.length())
                return false;

            int len = start.length();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < start.length(); i++) {
                if (start.charAt(i) != 'X')
                    sb1.append(start.charAt(i));
                if (end.charAt(i) != 'X')
                    sb2.append(end.charAt(i));
            }

            if (!sb1.toString().equals(sb2.toString()))
                return false;

            // L R
            int up = 0, down = 0;
            /**
             * to see the L part
             *   L -> start.charAt() index1
             *   L -> end.charAt()   index2
             *      |
             *          |
             *      index1 < index2 -> false
             */
            while (up < len && down < len) {
                while (up < len && start.charAt(up) != 'L')
                    up++;
                while (down < len && end.charAt(down) != 'L')
                    down++;

                if (up == len || down == len) {
                    if (noSymbol(start, up + 1, 'L', true) && noSymbol(end, down + 1, 'L', true))
                        break;
                    else
                        return false;
                }

                if (up < down)
                    return false;
                up++;
                down++;
            }

            up = len - 1;
            down = len - 1;
            /**
             * to see the right part
             *  R -> start.charAt() index1
             *  R -> start.charAt() index2
             *    |    |
             *      |
             *      index1 >  index2 false
             */
            while (up >= 0 && down >= 0) {
                while (up >= 0 && start.charAt(up) != 'R')
                    up--;
                while (down >= 0 && end.charAt(down) != 'R')
                    down--;

                if (up == 0 || down == 0) {
                    if (noSymbol(start, up - 1, 'R', false) && noSymbol(end, down - 1, 'R', false))
                        break;
                    else
                        return false;
                }

                if (up > down)
                    return false;
                up--;
                down--;
            }

            return true;
        }

        private boolean noSymbol(String start, int index, char ch, boolean l2r) {
            if (l2r) {
                for (int i = index; i < start.length(); i++) {
                    if (start.charAt(i) == ch)
                        return false;
                }
                return true;
            } else {
                for (int i = index; i >= 0; i--) {
                    if (start.charAt(i) == ch)
                        return false;
                }
                return true;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}