//编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。 
// 示例： 
// 输入： a = 1, b = 2
//输出： 2
// 
// Related Topics 位运算 脑筋急转弯 数学 
// 👍 96 👎 0

package com.helsing.leetcode.editor.cn;

public class QM1607_MaximumLcci {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximum(int a, int b) {
            long x = (long) a - (long) b;
            int k = (int) (x >> 63);
            return (1 + k) * a - b * k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}