//给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。 
//
// 注意：请不要在超过该数组长度的位置写入元素。 
//
// 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。 
//
// 
//
// 示例 1： 
//
// 输入：[1,0,2,3,0,4,5,0]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
// 
//
// 示例 2： 
//
// 输入：[1,2,3]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10000 
// 0 <= arr[i] <= 9 
// 
// Related Topics 数组 双指针 
// 👍 96 👎 0

package com.helsing.leetcode.editor.cn;

public class Q1089_DuplicateZeros {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {8, 4, 5, 0, 0, 0, 0, 7};
        solution.duplicateZeros(test);
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void duplicateZeros(int[] arr) {
            // 双指针  快慢指针
            twoPointersWithFastAndSlow(arr);
        }

        public void twoPointersWithFastAndSlow(int[] arr) {
            int n = arr.length;
            // 定义快慢指针
            int slow = 0, fast = 0;
            // 当遇到0，快指针多往前走一步
            while (fast < n) {
                if (arr[slow] == 0) {
                    fast++;
                }
                slow++;
                fast++;
            }
            // 快慢指针最终位置相同 无0
            if (fast == slow) {
                return;
            }
            // 指针回退到最后一次位置
            slow--;
            fast--; //快指针仍可能越界 fast = n
            // 当快指针大于慢指针时 倒序赋值
            while (fast > slow) {
                if (fast < n) {
                    arr[fast] = arr[slow];
                }
                if (arr[slow] == 0) {
                    // 快指针在回退一次，复制一遍0
                    fast--;
                    arr[fast] = arr[slow];
                }
                slow--;
                fast--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}