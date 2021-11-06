//给定一个整数数组和一个整数 k，你需要在数组里找到 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。 
//
// 这里将 k-diff 数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件： 
//
// 
// 0 <= i < j < nums.length 
// |nums[i] - nums[j]| == k 
// 
//
// 注意，|val| 表示 val 的绝对值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3, 1, 4, 1, 5], k = 2
//输出：2
//解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
//尽管数组中有两个1，但我们只应返回不同的数对的数量。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1, 2, 3, 4, 5], k = 1
//输出：4
//解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1, 3, 1, 5, 4], k = 0
//输出：1
//解释：数组中只有一个 0-diff 数对，(1, 1)。
// 
//
// 示例 4： 
//
// 
//输入：nums = [1,2,4,4,3,3,0,9,2,3], k = 3
//输出：2
// 
//
// 示例 5： 
//
// 
//输入：nums = [-1,-2,-3], k = 1
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -107 <= nums[i] <= 107 
// 0 <= k <= 107 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 
// 👍 145 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Q0532_KDiffPairsInAnArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6};
        solution.findPairs(nums, 1);
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPairs(int[] nums, int k) {
            int ans = 0;
            //先对数组从小到大排序；
            Arrays.sort(nums);
            //定义一个map，用来存放k-diff对
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            //set用来存放已经访问过的数组元素
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < nums.length; i++) {
                //用pre表示nums[j]，因为已经排过序，所以如果存在，那么nums[j]一定在set中
                int pre = nums[i] - k;
                if (set.contains(pre)) {
                    map.put(nums[i], pre);
                }
                //将访问过的nums[i]放入set;
                set.add(nums[i]);
            }
            //keySet的大小即为答案;
            return map.keySet().size();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}