//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。 
//
// 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。 
//
// 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,4,2,2]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,3,4,2]
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1]
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：nums = [1,1,2]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 105 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次 
// 
//
// 
//
// 进阶： 
//
// 
// 如何证明 nums 中至少存在一个重复的数字? 
// 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？ 
// 
// Related Topics 位运算 数组 双指针 二分查找 
// 👍 1451 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0287_FindTheDuplicateNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findDuplicate(int[] nums) {
            // 二分查找
//            return binary(nums);

            // 二进制展开
            return bit(nums);

            // 快慢指针
//            return slowFast(nums);
        }

        public int bit(int[] nums) {
            int n = nums.length, ans = 0;
            int bit_max = 31;
            while (((n - 1) >> bit_max) == 0) {
                bit_max -= 1;
            }
            for (int bit = 0; bit <= bit_max; ++bit) {
                int x = 0, y = 0;
                for (int i = 0; i < n; ++i) {
                    if ((nums[i] & (1 << bit)) != 0) {
                        x += 1;
                    }
                    if (i >= 1 && ((i & (1 << bit)) != 0)) {
                        y += 1;
                    }
                }
                if (x > y) {
                    ans |= 1 << bit;
                }
            }
            return ans;
        }

        public int binary(int[] nums) {
            int n = nums.length;
            int l = 1, r = n - 1, ans = -1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                int cnt = 0;
                for (int i = 0; i < n; ++i) {
                    if (nums[i] <= mid) {
                        cnt++;
                    }
                }
                if (cnt <= mid) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                    ans = mid;
                }
            }
            return ans;
        }

        public int slowFast(int[] nums) {
            int slow = 0, fast = 0;
            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);
            slow = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}