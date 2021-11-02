//设计一个接收整数流的数据结构，该数据结构支持检查是否存在两数之和等于特定值。 
//
// 实现 TwoSum 类： 
//
// 
// TwoSum() 使用空数组初始化 TwoSum 对象 
// void add(int number) 向数据结构添加一个数 number 
// boolean find(int value) 寻找数据结构中是否存在一对整数，使得两数之和与给定的值相等。如果存在，返回 true ；否则，返回 fal
//se 。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["TwoSum", "add", "add", "add", "find", "find"]
//[[], [1], [3], [5], [4], [7]]
//输出：
//[null, null, null, null, true, false]
//
//解释：
//TwoSum twoSum = new TwoSum();
//twoSum.add(1);   // [] --> [1]
//twoSum.add(3);   // [1] --> [1,3]
//twoSum.add(5);   // [1,3] --> [1,3,5]
//twoSum.find(4);  // 1 + 3 = 4，返回 true
//twoSum.find(7);  // 没有两个整数加起来等于 7 ，返回 false 
//
// 
//
// 提示： 
//
// 
// -105 <= number <= 105 
// -231 <= value <= 231 - 1 
// 最多调用 5 * 104 次 add 和 find 
// 
// Related Topics 设计 数组 哈希表 双指针 数据流 
// 👍 60 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Q0170_TwoSumIiiDataStructureDesign {

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        solution.add(3);
        solution.add(1);
        solution.add(2);
        solution.find(3);
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class TwoSum {

        private List<Integer> array;
        private boolean isSorted;

        private HashMap<Integer, Integer> numsMap;

        public TwoSum() {
            // 有序数组法
            array = new ArrayList<>();
            isSorted = false;

            // 哈希表法
            numsMap = new HashMap<>();
        }

        public void add(int number) {
            // 有序数组法
            array.add(number);
            isSorted = false;

            // 哈希表法
            numsMap.put(number, 0);
        }

        public boolean find(int value) {
            // 有序数组法
            if (!isSorted) {
                Collections.sort(array);
                isSorted = true;
            }
            // 双指针
            int left = 0, right = array.size() - 1;
            while (left < right) {
                int sum = array.get(left) + array.get(right);
                if (sum < value) {
                    left++;
                } else if (sum > value) {
                    right--;
                } else {
                    return true;
                }
            }
            return false;

        }
    }

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}