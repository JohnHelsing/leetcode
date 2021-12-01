//假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。 
//
// 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则
//的情况下种入 n 朵花？能则返回 true ，不能则返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：flowerbed = [1,0,0,0,1], n = 1
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：flowerbed = [1,0,0,0,1], n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= flowerbed.length <= 2 * 10⁴ 
// flowerbed[i] 为 0 或 1 
// flowerbed 中不存在相邻的两朵花 
// 0 <= n <= flowerbed.length 
// 
// Related Topics 贪心 数组 👍 408 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0605_CanPlaceFlowers {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            if (flowerbed == null || flowerbed.length == 0) {
                return n == 0;
            }
            // 当前全0区段中连续0的数量，刚开始预设1个0，因为开头花坛的最左边没有花，可以认为存在一个虚无的0
            int countOfZero = 1;
            // 可以种的花的数量
            int canPlace = 0;
            for (int bed : flowerbed) {
                if (bed == 0) {
                    // 遇到0，连续0的数量+1
                    countOfZero++;
                } else {
                    // 遇到1，结算上一段连续的0区间，看能种下几盆花：(countOfZero-1)/2
                    canPlace += (countOfZero - 1) / 2;
                    if (canPlace >= n) {
                        return true;
                    }
                    // 0的数量清零，开始统计下一个全0分区
                    countOfZero = 0;
                }
            }
            // 最后一段0区还未结算：
            countOfZero++; // 最后再预设1个0，因为最后花坛的最右边没有花，可以认为存在一个虚无的0
            canPlace += (countOfZero - 1) / 2;
            return canPlace >= n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
