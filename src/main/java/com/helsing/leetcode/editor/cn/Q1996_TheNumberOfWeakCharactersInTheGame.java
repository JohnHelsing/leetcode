//你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。
// 给你一个二维整数数组 properties ，其中 properties[i] = [attacki, defensei] 表示游戏中第 i 个角色的属性。
//
// 如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，
// 则认为该角色为 弱角色 。更正式地，如果认为角色 i 弱于 存在的另一个角色
//j ，那么 attackj > attacki 且 defensej > defensei 。 
//
// 返回 弱角色 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：properties = [[5,5],[6,3],[3,6]]
//输出：0
//解释：不存在攻击和防御都严格高于其他角色的角色。
// 
//
// 示例 2： 
//
// 
//输入：properties = [[2,2],[3,3]]
//输出：1
//解释：第一个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
// 
//
// 示例 3： 
//
// 
//输入：properties = [[1,5],[10,4],[4,3]]
//输出：1
//解释：第三个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= properties.length <= 10⁵ 
// properties[i].length == 2 
// 1 <= attacki, defensei <= 10⁵ 
// 
// Related Topics 栈 贪心 数组 排序 单调栈 👍 34 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.*;

public class Q1996_TheNumberOfWeakCharactersInTheGame {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfWeakCharacters(int[][] properties) {
            // 单调栈
            return stackMonotone(properties);
        }

        public int stackMonotone(int[][] properties) {
            Arrays.sort(properties, (a, b) -> {
                if (b[0] != a[0]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            });
            int maxOf2 = 0;
            Map<Integer, Integer> map = new HashMap<>();
            int pre = -1;
            for (int i = properties.length - 1; i >= 0; i--) {
                if (pre == -1) {
                    maxOf2 = properties[i][1];
                    pre = properties[i][0];
                    map.put(properties[i][0], 0);
                } else if (pre != properties[i][0]) {
                    map.put(properties[i][0], maxOf2);//此处只能存上一个（攻击力）数字的最大(防御)值
                    pre = properties[i][0];
                    maxOf2 = Math.max(maxOf2, properties[i][1]);
                }
            }
            int result = 0;
            for (int i = 0; i < properties.length; i++) {
                if (map.get(properties[i][0]) > properties[i][1]) result++;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
