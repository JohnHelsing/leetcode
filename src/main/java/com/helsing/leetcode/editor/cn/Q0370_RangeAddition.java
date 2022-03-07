//假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k 个更新的操作。 
//
// 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，
// 你需要将子数组 A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加 inc。
//
// 请你返回 k 次操作后的数组。 
//
// 示例: 
//
// 输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
//输出: [-2,0,3,5,3]
// 
//
// 解释: 
//
// 初始状态:
//[0,0,0,0,0]
//
//进行了操作 [1,3,2] 后的状态:
//[0,2,2,2,0]
//
//进行了操作 [2,4,3] 后的状态:
//[0,2,5,5,3]
//
//进行了操作 [0,2,-2] 后的状态:
//[-2,0,3,5,3]
// 
// Related Topics 数组 前缀和 👍 114 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0370_RangeAddition {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getModifiedArray(int length, int[][] updates) {
            int[] diff = new int[length];
            for (int[] update : updates) {
                int i = update[0];
                int j = update[1];
                int val = update[2];
                // 差分数组更新
                diff[i] += val;
                if (j + 1 < diff.length) {
                    diff[j + 1] -= val;
                }
            }
            // 计算终值
            for (int i = 1; i < diff.length; i++) {
                diff[i] = diff[i - 1] + diff[i];
            }
            return diff;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
