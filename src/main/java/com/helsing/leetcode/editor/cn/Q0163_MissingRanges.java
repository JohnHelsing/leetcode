//给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，
// 返回不包含在数组中的缺失区间。
//
// 示例： 
//
// 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
//输出: ["2", "4->49", "51->74", "76->99"]
// 
// Related Topics 数组 👍 71 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0163_MissingRanges {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            List<String> res = new ArrayList<>();
            int low = lower - 1;
            int[] newNums = Arrays.copyOf(nums, nums.length + 1);
            newNums[nums.length] = upper + 1;
            for (int i = 0; i < newNums.length; i++) {
                int diff = newNums[i] - low;
                if (diff == 2) {
                    res.add(String.valueOf(low + 1));
                } else if (diff > 2) {
                    res.add(String.valueOf(low + 1) + "->"
                            + String.valueOf(newNums[i] - 1));
                }
                low = newNums[i];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
