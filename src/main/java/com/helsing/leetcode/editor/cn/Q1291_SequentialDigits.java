//我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。 
//
// 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。 
//
// 
//
// 示例 1： 
//
// 输出：low = 100, high = 300
//输出：[123,234]
// 
//
// 示例 2： 
//
// 输出：low = 1000, high = 13000
//输出：[1234,2345,3456,4567,5678,6789,12345]
// 
//
// 
//
// 提示： 
//
// 
// 10 <= low <= high <= 10^9 
// 
// Related Topics 枚举 
// 👍 33 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q1291_SequentialDigits {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> sequentialDigits(int low, int high) {
            List<Integer> res = new LinkedList<>();
            //顺次数第一位(1~9);遍历以i开头的所有顺次数
            for (int i = 1; i <= 9; i++) {
                int num = i;
                //顺次数其他位;其他位都比上一位多1,使用j++
                for (int j = i + 1; j <= 9; j++) {
                    //因为是尾部添加，所以之前的数字要扩大十倍
                    num = num * 10 + j;
                    //如果这个顺次数在范围内，加入结果集
                    if (num >= low && num <= high) {
                        res.add(num);
                    }
                }
            }
            //调用集合工具包排序方法进行排序
            Collections.sort(res);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}