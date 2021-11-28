//给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。 
//
// 由于答案可能很大，因此 返回答案模 10^9 + 7 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,2,4]
//输出：17
//解释：
//子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
//最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。 
//
// 示例 2： 
//
// 
//输入：arr = [11,81,94,43,3]
//输出：444
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 3 * 10⁴ 
// 1 <= arr[i] <= 3 * 10⁴ 
// 
//
//
// Related Topics 栈 数组 动态规划 单调栈 👍 286 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0907_SumOfSubarrayMinimums {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumSubarrayMins(int[] arr) {
            // 单调栈
            return stackMonotone(arr);
        }

        public int stackMonotone(int[] arr) {
            int MOD = 1_000_000_007;

            Deque<RepInteger> stack = new ArrayDeque<>();
            int ans = 0, dot = 0;
            for (int j = 0; j < arr.length; ++j) {
                // Add all answers for subarrays [i, j], i <= j
                int count = 1;
                while (!stack.isEmpty() && stack.peek().val >= arr[j]) {
                    RepInteger node = stack.pop();
                    count += node.count;
                    dot -= node.val * node.count;
                }
                stack.push(new RepInteger(arr[j], count));
                dot += arr[j] * count;
                ans += dot;
                ans %= MOD;
            }

            return ans;
        }

        class RepInteger {
            int val, count;

            RepInteger(int v, int c) {
                val = v;
                count = c;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
