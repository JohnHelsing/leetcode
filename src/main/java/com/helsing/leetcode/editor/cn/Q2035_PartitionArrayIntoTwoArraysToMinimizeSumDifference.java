//给你一个长度为 2 * n 的整数数组。你需要将 nums 分成 两个 长度为 n 的数组，分别求出两个数组的和，并 最小化 两个数组和之 差的绝对值 。n
//ums 中每个元素都需要放入两个数组之一。 
//
// 请你返回 最小 的数组和之差。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：nums = [3,9,7,3]
//输出：2
//解释：最优分组方案是分成 [3,9] 和 [7,3] 。
//数组和之差的绝对值为 abs((3 + 9) - (7 + 3)) = 2 。
// 
//
// 示例 2： 
//
// 输入：nums = [-36,36]
//输出：72
//解释：最优分组方案是分成 [-36] 和 [36] 。
//数组和之差的绝对值为 abs((-36) - (36)) = 72 。
// 
//
// 示例 3： 
//
// 
//
// 输入：nums = [2,-1,0,4,-2,-9]
//输出：0
//解释：最优分组方案是分成 [2,4,-9] 和 [-1,0,-2] 。
//数组和之差的绝对值为 abs((2 + 4 + -9) - (-1 + 0 + -2)) = 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 15 
// nums.length == 2 * n 
// -107 <= nums[i] <= 107 
// 
// Related Topics 位运算 数组 双指针 二分查找 动态规划 状态压缩 有序集合 
// 👍 25 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q2035_PartitionArrayIntoTwoArraysToMinimizeSumDifference {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDifference(int[] nums) {
            int n = nums.length / 2;
            List<List<Integer>> bitn_presum = new ArrayList<>();
            for (int i = 0; i < 16; i++) {
                bitn_presum.add(new ArrayList<>());
            }
            //----前n个数字。二进制枚举，状态压缩
            for (int state = 0; state < (1 << n); state++) {
                int bitn = 0;
                int presum = 0;
                for (int i = 0; i < n; i++) {
                    if (((state >> i) & 1) == 1) {
                        presum += nums[i];
                        bitn++;
                    } else {
                        presum -= nums[i];
                    }
                }
                bitn_presum.get(bitn).add(presum);
            }

            //----对每个bitn，可以组成的和，进行排序。为后面二分查找做好准备
            for (int bitn = 0; bitn < 16; bitn++) {
                Collections.sort(bitn_presum.get(bitn));
            }

            int res = Integer.MAX_VALUE;

            //----后n个数字，二进制枚举，状压压缩
            for (int state = 0; state < (1 << n); state++) {
                int bitn = 0;
                int sufsum = 0;
                for (int i = 0; i < n; i++) {
                    if (((state >> i) & 1) == 1) {
                        sufsum += nums[n + i];
                        bitn++;
                    } else {
                        sufsum -= nums[n + i];
                    }
                }

                //----二分最左框架
                int lo = 0;
                int hi = bitn_presum.get(n - bitn).size();
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if (bitn_presum.get(n - bitn).get(mid) >= -1 * sufsum) {
                        hi = mid;
                    } else {
                        lo = mid + 1;
                    }
                }
                if (lo != bitn_presum.get(n - bitn).size()) {
                    res = Math.min(res, bitn_presum.get(n - bitn).get(lo) + sufsum);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}