//给你两个整数数组 nums1 和 nums2 ，请你返回根据以下规则形成的三元组的数目（类型 1 和类型 2 ）： 
//
// 
// 类型 1：三元组 (i, j, k) ，如果 nums1[i]2 == nums2[j] * nums2[k] 其中 0 <= i < nums1.len
//gth 且 0 <= j < k < nums2.length 
// 类型 2：三元组 (i, j, k) ，如果 nums2[i]2 == nums1[j] * nums1[k] 其中 0 <= i < nums2.len
//gth 且 0 <= j < k < nums1.length 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [7,4], nums2 = [5,2,8,9]
//输出：1
//解释：类型 1：(1,1,2), nums1[1]^2 = nums2[1] * nums2[2] (4^2 = 2 * 8) 
//
// 示例 2： 
//
// 输入：nums1 = [1,1], nums2 = [1,1,1]
//输出：9
//解释：所有三元组都符合题目要求，因为 1^2 = 1 * 1
//类型 1：(0,0,1), (0,0,2), (0,1,2), (1,0,1), (1,0,2), (1,1,2), nums1[i]^2 = nums2[
//j] * nums2[k]
//类型 2：(0,0,1), (1,0,1), (2,0,1), nums2[i]^2 = nums1[j] * nums1[k]
// 
//
// 示例 3： 
//
// 输入：nums1 = [7,7,8,3], nums2 = [1,2,9,7]
//输出：2
//解释：有两个符合题目要求的三元组
//类型 1：(3,0,2), nums1[3]^2 = nums2[0] * nums2[2]
//类型 2：(3,0,1), nums2[3]^2 = nums1[0] * nums1[1]
// 
//
// 示例 4： 
//
// 输入：nums1 = [4,7,9,11,23], nums2 = [3,5,1024,12,18]
//输出：0
//解释：不存在符合题目要求的三元组
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 1 <= nums1[i], nums2[i] <= 10^5 
// 
// Related Topics 数组 哈希表 数学 双指针 
// 👍 11 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Q1577_NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbers {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTriplets(int[] nums1, int[] nums2) {
            // 哈希表
//            return hash(nums1, nums2);

            // 双指针
            return doublePoint(nums1, nums2);
        }

        public int doublePoint(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            return count(nums1, nums2) + count(nums2, nums1);
        }

        public int count(int[] nums1, int[] nums2) {
            int res = 0;
            for (int i = 0; i < nums1.length; i++) {
                long sum = (long) nums1[i] * nums1[i];
                int m = 0, n = nums2.length - 1;
                //nums2中最小的数的平方，都比sum大，所以，不可能存在解，跳过
                if ((long) nums2[m] * nums2[m] > sum) continue;
                //nums2中最大的数的平方，都比sum小，所以，不可能存在解，跳过
                //并且，nums1[i + 1] >= nums1[i]，所以，直接break即可
                if ((long) nums2[n] * nums2[n] < sum) break;
                while (m < n) {
                    if ((long) nums2[m] * nums2[n] < sum) m++;
                    else if ((long) nums2[m] * nums2[n] > sum) n--;
                    else {
                        //nums2[m..n]，这里面的数完全相同
                        //从里面抽2个数，求组合数即可。
                        //组合数就是(n - m + 1) * (n - m) / 2
                        if (nums2[m] == nums2[n]) {
                            int total = (n - m + 1) * (n - m) / 2;
                            res += total;
                            //直接break即可。
                            break;
                        } else {
                            //nums2[m..j)、nums2(k..n]，这两个子数组里的数都相同
                            //从这两个子数组分别抽1个数出来，求组合数即可。
                            //组合数就是(j - m) * (n - k)
                            int j = m + 1, k = n - 1;
                            while (nums2[j] == nums2[m]) {
                                j++;
                            }
                            while (nums2[k] == nums2[n]) {
                                k--;
                            }
                            res += (j - m) * (n - k);
                            m = j;
                            n = k;
                            //不break,nums2[j..k]之间可能还存在解
                            //比如sum为24时，[3,3,4,5,6,8,8],经过上述操作,剩余子数组[4,5,6]，
                            //即nums2[j..k]，仍存在解(4,6)
                        }
                    }
                }
            }
            return res;
        }

        public int hash(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
            Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
            for (int num : nums1) {
                int count = map1.getOrDefault(num, 0) + 1;
                map1.put(num, count);
            }
            for (int num : nums2) {
                int count = map2.getOrDefault(num, 0) + 1;
                map2.put(num, count);
            }
            return getTriplets(map1, map2) + getTriplets(map2, map1);
        }

        public int getTriplets(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
            int triplets = 0;
            Set<Integer> set1 = map1.keySet();
            Set<Integer> set2 = map2.keySet();
            for (int num1 : set1) {
                int count1 = map1.get(num1);
                long square = (long) num1 * num1;
                for (int num2 : set2) {
                    if (square % num2 == 0 && square / num2 <= Integer.MAX_VALUE) {
                        int num3 = (int) (square / num2);
                        if (num2 == num3) {
                            int count2 = map2.get(num2);
                            int curTriplets = count1 * count2 * (count2 - 1) / 2;
                            triplets += curTriplets;
                        } else if (num2 < num3 && set2.contains(num3)) {
                            int count2 = map2.get(num2), count3 = map2.get(num3);
                            int curTriplets = count1 * count2 * count3;
                            triplets += curTriplets;
                        }
                    }
                }
            }
            return triplets;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}