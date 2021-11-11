//给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。 
//
// 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：1
//输出：true
// 
//
// 示例 2： 
//
// 输入：10
//输出：false
// 
//
// 示例 3： 
//
// 输入：16
//输出：true
// 
//
// 示例 4： 
//
// 输入：24
//输出：false
// 
//
// 示例 5： 
//
// 输入：46
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 10^9 
// 
// Related Topics 数学 计数 枚举 排序 
// 👍 139 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Q0869_ReorderedPowerOf2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<String> powerOf2Digits = new HashSet<String>();

        public boolean reorderedPowerOf2(int n) {
            init();
            return powerOf2Digits.contains(countDigits(n));
        }

        public void init() {
            for (int n = 1; n <= 1e9; n <<= 1) {
                powerOf2Digits.add(countDigits(n));
            }
        }

        public String countDigits(int n) {
            char[] cnt = new char[10];
            while (n > 0) {
                cnt[n % 10]++;
                n /= 10;
            }
            return new String(cnt);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}