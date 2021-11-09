//中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。 
//
// 请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。 
//
// 
//
// 示例 1: 
//
// 输入: num = "69"
//输出: true
// 
//
// 示例 2: 
//
// 输入: num = "88"
//输出: true 
//
// 示例 3: 
//
// 输入: num = "962"
//输出: false 
//
// 示例 4： 
//
// 输入：num = "1"
//输出：true
// 
// Related Topics 哈希表 双指针 字符串 
// 👍 33 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0246_StrobogrammaticNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isStrobogrammatic(String num) {
            return twoPointers(num);
        }

        public boolean twoPointers(String num) {
            char[] reverse = new char[]{'0', '1', 'a', 'a', 'a', 'a', '9', 'a', '8', '6'};
            char[] s = num.toCharArray();
            int left = 0, right = s.length - 1;
            while (left <= right) {
                if (reverse[s[left] - '0'] != s[right]) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}