//Alice 和 Bob 交替进行一个游戏，由 Alice 先手。 
//
// 在游戏中，共有 n 堆石头。在每个玩家的回合中，玩家需要 选择 任一非空石头堆，从中移除任意 非零 数量的石头。如果不能移除任意的石头，就输掉游戏，同时另
//一人获胜。 
//
// 给定一个整数数组 piles ，piles[i] 为 第 i 堆石头的数量，如果 Alice 能获胜返回 true ，反之返回 false 。 
//
// Alice 和 Bob 都会采取 最优策略 。 
//
// 
//
// 示例 1： 
//
// 
//输入：piles = [1]
//输出：true
//解释：只有一种可能的情况：
//- 第一回合，Alice 移除了第 1 堆中 1 块石头。piles = [0]。
//- 第二回合，Bob 没有任何石头可以移除。Alice 获胜。
// 
//
// 示例 2： 
//
// 
//输入：piles = [1,1]
//输出：false
//解释：可以证明，Bob一定能获胜。一种可能的情况：
//- 第一回合，Alice 移除了第 1 堆中 1 块石头。 piles = [0,1]。
//- 第二回合，Bob 移除了第 2 堆中 1 块石头。 piles = [0,0]。
//- 第三回合，Alice 没有任何石头可以移除。Bob 获胜。
// 
//
// 示例 3： 
//
// 
//输入：piles = [1,2,3]
//输出：false
//解释：可以证明，Bob一定能获胜。一种可能的情况：
//- 第一回合，Alice 移除了第 3 堆中 3 块石头。 piles = [1,2,0]。
//- 第二回合，Bob 移除了第 2 堆中 1 块石头。 piles = [1,1,0]。
//- 第三回合，Alice 移除了第 1 堆中 1 块石头。piles = [0,1,0]。
//- 第四回合，Bob 移除了第 2 堆中 1 块石头。 piles = [0,0,0]。
//- 第三回合，Alice 没有任何石头可以移除。Bob 获胜。 
//
// 
//
// 提示： 
//
// 
// n == piles.length 
// 1 <= n <= 7 
// 1 <= piles[i] <= 7 
// 
//
// 
//
// 进阶：你能想出一个 线性时间 的解决方案吗？虽然这一答案可能超出了面试所需的范围，但了解它可能会很有趣。 
// Related Topics 位运算 脑筋急转弯 数组 数学 动态规划 博弈 
// 👍 2 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q1908_GameOfNim {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean nimGame(int[] piles) {
            // 动态规划
            int maxPile = 0;
            for (int pile : piles) {
                maxPile = Math.max(maxPile, pile);
            }
            int n = piles.length;
            int[] radices = new int[n];
            radices[0] = 1;
            for (int i = 1; i < n; i++) {
                radices[i] = radices[i - 1] * (maxPile + 1);
            }
            int total = 0;
            for (int i = 0; i < n; i++) {
                total += piles[i] * radices[i];
            }
            Map<Integer, Boolean> memo = new HashMap<Integer, Boolean>();
            memo.put(0, false);
            return dp(memo, n, radices, total);

            // 数学：异或状态
//            return xor(piles);
        }

        public boolean dp(Map<Integer, Boolean> memo, int n, int[] radices, int state) {
            if (!memo.containsKey(state)) {
                int[] piles = new int[n];
                int remain = state;
                for (int i = n - 1; i >= 0; i--) {
                    piles[i] = remain / radices[i];
                    remain %= radices[i];
                }
                boolean flag = false;
                for (int i = 0; i < n && !flag; i++) {
                    for (int j = 1; j <= piles[i]; j++) {
                        int nextState = state - j * radices[i];
                        boolean nextFlag = dp(memo, n, radices, nextState);
                        if (!nextFlag) {
                            flag = true;
                            break;
                        }
                    }
                }
                memo.put(state, flag);
            }
            return memo.get(state);
        }

        public boolean xor(int[] piles) {
            int xor = 0;
            for (int pile : piles) {
                xor ^= pile;
            }
            return xor != 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}