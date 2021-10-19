//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？ 
// Related Topics 数组 哈希表 
// 👍 12373 👎 0
package com.helsing.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q0001_TwoSum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1, 2, 3};
        System.out.println(
                Arrays.toString(
                        solution.twoSum(test, 4)));
    }

    static

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            // 性能优化
            if (nums == null || nums.length < 2) {
                return new int[]{};
            }

            // 暴力枚举法
//        return enums(nums, target);

            // 哈希表
//        return hash(nums, target);

            // 两个方向进行哈希表查询
            return dicHash(nums, target);
        }

        public int[] enums(int[] nums, int target) {
            int[] res = new int[2];
            for (int i = 0; i < nums.length; i++) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[i] + nums[j] == target) {
                        res[0] = i;
                        res[1] = j;
                    }
                }
            }
            return res;
        }

        public int[] hash(int[] nums, int target) {
            Map<Integer, Integer> hashtable = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; ++i) {
                if (hashtable.containsKey(target - nums[i])) {
                    return new int[]{hashtable.get(target - nums[i]), i};
                }
                hashtable.put(nums[i], i);
            }
            return new int[0];
        }

        public int[] dicHash(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int ln0 = nums[left];
                int ln1 = target - ln0;
                if (map.containsKey(ln1)) {
                    return new int[]{left, map.get(ln1)};
                } else {
                    map.put(ln0, left++);
                }
                int rn0 = nums[right];
                int rn1 = target - rn0;
                if (map.containsKey(rn1)) {
                    return new int[]{right, map.get(rn1)};
                } else {
                    map.put(rn0, right--);
                }
            }
            return new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}