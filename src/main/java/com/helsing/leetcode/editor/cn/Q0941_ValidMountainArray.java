//给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。 
//
// 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组： 
//
// 
// arr.length >= 3 
// 在 0 < i < arr.length - 1 条件下，存在 i 使得：
// 
// arr[0] < arr[1] < ... arr[i-1] < arr[i] 
// arr[i] > arr[i+1] > ... > arr[arr.length - 1] 
// 
// 
// 
//
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [2,1]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：arr = [3,5,5]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [0,3,2,1]
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 104 
// 0 <= arr[i] <= 104 
// 
// Related Topics 数组 
// 👍 157 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0941_ValidMountainArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validMountainArray(int[] arr) {
            int N = arr.length;
            int i = 0;

            // 递增扫描
            while (i + 1 < N && arr[i] < arr[i + 1]) {
                i++;
            }

            // 最高点不能是数组的第一个位置或最后一个位置
            if (i == 0 || i == N - 1) {
                return false;
            }

            // 递减扫描
            while (i + 1 < N && arr[i] > arr[i + 1]) {
                i++;
            }

            return i == N - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}