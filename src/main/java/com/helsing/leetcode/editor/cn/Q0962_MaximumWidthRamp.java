//给定一个整数数组 A，坡是元组 (i, j)，其中 i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。 
//
// 找出 A 中的坡的最大宽度，如果不存在，返回 0 。 
//
// 
//
// 示例 1： 
//
// 输入：[6,0,8,2,1,5]
//输出：4
//解释：
//最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
// 
//
// 示例 2： 
//
// 输入：[9,8,1,0,1,9,4,0,4,1]
//输出：7
//解释：
//最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 50000 
// 0 <= A[i] <= 50000 
// 
//
// 
// Related Topics 栈 数组 单调栈 👍 141 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0962_MaximumWidthRamp {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxWidthRamp(int[] nums) {
            // 单调栈
            return stackMonotone(nums);
        }

        public int stackMonotone(int[] nums) {
            int n = nums.length;
            int maxWidth = 0;

            Deque<Integer> stack = new ArrayDeque<>();
            for (int i=0;i<n;i++) {
                if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                    stack.push(i);
                }
            }

            for (int i=n-1;i>=0;i--) {
                while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                    int pos = stack.pop();
                    maxWidth = Math.max(maxWidth, i - pos);
                }
            }
            return maxWidth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
