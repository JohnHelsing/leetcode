//你和朋友玩一个叫做「翻转游戏」的游戏。游戏规则如下： 
//
// 给你一个字符串 currentState ，其中只含 '+' 和 '-' 。
// 你和朋友轮流将 连续 的两个 "++" 反转成 "--" 。当一方无法进行有效
//的翻转时便意味着游戏结束，则另一方获胜。 
//
// 计算并返回 一次有效操作 后，字符串 currentState 所有的可能状态，返回结果可以按 任意顺序 排列。
// 如果不存在可能的有效操作，请返回一个空列表
// [] 。 
//
// 
//
// 示例 1： 
//
// 
//输入：currentState = "++++"
//输出：["--++","+--+","++--"]
// 
//
// 示例 2： 
//
// 
//输入：currentState = "+"
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= currentState.length <= 500 
// currentState[i] 不是 '+' 就是 '-' 
// 
// Related Topics 字符串 👍 32 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q0293_FlipGame {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generatePossibleNextMoves(String currentState) {
            List<String> list = new ArrayList<>();
            if (currentState == null || currentState.length() == 0) {
                return list;
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i < currentState.length(); i++) {
                if (currentState.charAt(i) == '+' &&
                        currentState.charAt(i - 1) == currentState.charAt(i)) {
                    builder.append(currentState);
                    builder.replace(i - 1, i + 1, "--");
                    list.add(builder.toString());
                    builder.setLength(0);
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
