//三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模100
//0000007。 
//
// 示例1: 
//
// 
// 输入：n = 3 
// 输出：4
// 说明: 有四种走法
// 
//
// 示例2: 
//
// 
// 输入：n = 5
// 输出：13
// 
//
// 提示: 
//
// 
// n范围在[1, 1000000]之间 
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 67 👎 0

package com.helsing.leetcode.editor.cn;

public class QM0801_ThreeStepsProblemLcci {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int waysToStep(int n) {
            if (n <= 2) {
                return n;
            }
            return dp(n);
        }

        public int dp(int n) {
            int mod = 1000000007;
            int[] fi = new int[n + 1];
            fi[0] = 1;
            for (int i = 1; i <= n; i++) {
                fi[i] = fi[i - 1];
                if (i >= 2) {
                    fi[i] = (fi[i] + fi[i - 2]) % mod;
                }
                if (i >= 3) {
                    fi[i] = (fi[i] + fi[i - 3]) % mod;
                }
            }
            return fi[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}