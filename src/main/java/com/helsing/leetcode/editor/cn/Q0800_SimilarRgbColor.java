//RGB 颜色 "#AABBCC" 可以简写成 "#ABC" 。 
//
// 
// 例如，"#15c" 其实是 "#1155cc" 的简写。 
// 
//
// 现在，假如我们分别定义两个颜色 "#ABCDEF" 和 "#UVWXYZ"，则他们的相似度可以通过这个表达式 -(AB - UV)^2 - (CD - W
//X)^2 - (EF - YZ)^2 来计算。 
//
// 那么给你一个按 "#ABCDEF" 形式定义的字符串 color 表示 RGB 颜色，请你以字符串形式，返回一个与它相似度最大且可以简写的颜色。（比如，可
//以表示成类似 "#XYZ" 的形式） 
//
// 任何 具有相同的（最大）相似度的答案都会被视为正确答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：color = "#09f166"
//输出："#11ee66"
//解释： 
//因为相似度计算得出 -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -7
//3
//这已经是所有可以简写的颜色中最相似的了
// 
//
// 示例 2： 
//
// 
//输入：color = "#4e3fe1"
//输出："#5544dd"
// 
//
// 
//
// 提示： 
//
// 
// color.length == 7 
// color[0] == '#' 
// 对于任何 i > 0，color[i] 都是一个在范围 ['0', 'f'] 内的 16 进制数 
// 
// Related Topics 数学 字符串 枚举 
// 👍 13 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0800_SimilarRgbColor {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String similarRGB(String color) {
            return "#" + f(color.substring(1, 3)) + f(color.substring(3, 5)) + f(color.substring(5));
        }

        public String f(String comp) {
            // 0x11 = 17
            int q = Integer.parseInt(comp, 16);
            q = q / 17 + (q % 17 > 8 ? 1 : 0);
            return String.format("%02x", 17 * q);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}