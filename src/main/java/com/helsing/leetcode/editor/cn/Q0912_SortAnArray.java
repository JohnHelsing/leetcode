//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 
// 👍 421 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q0912_SortAnArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {7, -3};
        solution.sortArray(nums);
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            if (nums.length < 2) {
                return nums;
            }
            // 基数排序
            return radixSort(nums);
        }

        /**
         * 十个桶 每次取数的（个十百）...位 放入桶中 重复这个过程
         *
         * @param nums
         * @return
         */
        public int[] radixSort(int[] nums) {
            int n = nums.length;
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int i = 0; i < n; ++i) {
                if (nums[i] > max) {
                    max = nums[i];
                }
                if (nums[i] < min) {
                    min = nums[i];
                }
            }
            //考虑到负数影响最大值和最小值的位数,选取绝对值最大的数
            max = max > (-min) ? max : -min;
            int digit = 0;
            while (max > 0) {
                max /= 10;
                digit++;
            }
            List<List<Integer>> bucket = new ArrayList<>(19);
            for (int i = 0; i < 19; i++) {
                bucket.add(new ArrayList<>());
            }
            int pos;
            int cur;
            for (int i = 0, mod = 1; i < digit; ++i, mod *= 10) {
                for (int j = 0; j < n; j++) {
                    pos = (nums[j] / mod) % 10;
                    bucket.get(pos + 9).add(nums[j]);
                }
                cur = 0;
                for (int j = 0; j < 19; ++j) {
                    for (int k = 0; k < bucket.get(j).size(); k++) {
                        nums[cur++] = bucket.get(j).get(k);
                    }
                    bucket.get(j).clear();
                }
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}