//一行中有 N 张多米诺骨牌，我们将每张多米诺骨牌垂直竖立。 
//
// 在开始时，我们同时把一些多米诺骨牌向左或向右推。 
//
// 
//
// 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。 
//
// 同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。 
//
// 如果同时有多米诺骨牌落在一张垂直竖立的多米诺骨牌的两边，由于受力平衡， 该骨牌仍然保持不变。 
//
// 就这个问题而言，我们会认为正在下降的多米诺骨牌不会对其它正在下降或已经下降的多米诺骨牌施加额外的力。 
//
// 给定表示初始状态的字符串 "S" 。如果第 i 张多米诺骨牌被推向左边，则 S[i] = 'L'；如果第 i 张多米诺骨牌被推向右边，则 S[i] = '
//R'；如果第 i 张多米诺骨牌没有被推动，则 S[i] = '.'。 
//
// 返回表示最终状态的字符串。 
//
// 示例 1： 
//
// 输入：".L.R...LR..L.."
//输出："LL.RR.LLRRLL.." 
//
// 示例 2： 
//
// 输入："RR.L"
//输出："RR.L"
//说明：第一张多米诺骨牌没有给第二张施加额外的力。 
//
// 提示： 
//
// 
// 0 <= N <= 10^5 
// 表示多米诺骨牌状态的字符串只含有 'L'，'R'; 以及 '.'; 
// 
// Related Topics 双指针 字符串 动态规划 
// 👍 116 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0838_PushDominoes {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String pushDominoes(String dominoes) {
            // 双指针
            return doublePoint(dominoes);
        }

        public String doublePoint(String dominoes) {
            char[] A = dominoes.toCharArray();
            int N = A.length;
            int[] forces = new int[N];

            // Populate forces going from left to right
            int force = 0;
            for (int i = 0; i < N; ++i) {
                if (A[i] == 'R') {
                    force = N;
                } else if (A[i] == 'L') {
                    force = 0;
                } else {
                    force = Math.max(force - 1, 0);
                }
                forces[i] += force;
            }

            // Populate forces going from right to left
            force = 0;
            for (int i = N - 1; i >= 0; --i) {
                if (A[i] == 'L') {
                    force = N;
                } else if (A[i] == 'R') {
                    force = 0;
                } else {
                    force = Math.max(force - 1, 0);
                }
                forces[i] -= force;
            }

            StringBuilder ans = new StringBuilder();
            for (int f : forces) {
                ans.append(f > 0 ? 'R' : f < 0 ? 'L' : '.');
            }
            return ans.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}