//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 
// 👍 1574 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q0017_LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.letterCombinations("23");
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> ans = new ArrayList<>();
            // 特判
            if(digits.length() == 0){
                return ans;
            }

            // 先制作哈希表
            Map<Character, String> phoneMap = new HashMap<>();
            phoneMap.put('2', "abc");
            phoneMap.put('3', "def");
            phoneMap.put('4', "ghi");
            phoneMap.put('5', "jkl");
            phoneMap.put('6', "mno");
            phoneMap.put('7', "pqrs");
            phoneMap.put('8', "tuv");
            phoneMap.put('9', "wxyz");

            // 回溯算法
            backtrack(ans, phoneMap, digits, 0, new StringBuilder());

            return ans;
        }

        public void backtrack(List<String> ans, Map<Character, String> phoneMap,
                              String digits, int index, StringBuilder sb) {
            if (index == digits.length()) {
                ans.add(sb.toString());
            } else {
                String letters = phoneMap.get(digits.charAt(index));
                for (int i = 0; i < letters.length(); i++) {
                    sb.append(letters.charAt(i));
                    backtrack(ans, phoneMap, digits, index + 1, sb);
                    sb.deleteCharAt(index);
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}