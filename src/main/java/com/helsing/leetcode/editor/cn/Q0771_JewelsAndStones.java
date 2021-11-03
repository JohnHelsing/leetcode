//给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。 
//
// J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。 
//
// 示例 1: 
//
// 输入: J = "aA", S = "aAAbbbb"
//输出: 3
// 
//
// 示例 2: 
//
// 输入: J = "z", S = "ZZ"
//输出: 0
// 
//
// 注意: 
//
// 
// S 和 J 最多含有50个字母。 
// J 中的字符不重复。 
// 
// Related Topics 哈希表 字符串 
// 👍 667 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Q0771_JewelsAndStones {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numJewelsInStones(String jewels, String stones) {
            int jewelsCount = 0;
            Set<Character> jewelsSet = new HashSet<Character>();
            int jewelsLength = jewels.length(), stonesLength = stones.length();
            for (int i = 0; i < jewelsLength; i++) {
                char jewel = jewels.charAt(i);
                jewelsSet.add(jewel);
            }
            for (int i = 0; i < stonesLength; i++) {
                char stone = stones.charAt(i);
                if (jewelsSet.contains(stone)) {
                    jewelsCount++;
                }
            }
            return jewelsCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}