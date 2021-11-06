//给定一个整数数组 A，以及一个整数 target 作为目标值，返回满足 i < j < k 且 A[i] + A[j] + A[k] == target 的
//元组 i, j, k 的数量。 
//
// 由于结果会非常大，请返回 结果除以 10^9 + 7 的余数。 
//
// 
//
// 示例 1： 
//
// 输入：A = [1,1,2,2,3,3,4,4,5,5], target = 8
//输出：20
//解释：
//按值枚举（A[i]，A[j]，A[k]）：
//(1, 2, 5) 出现 8 次；
//(1, 3, 4) 出现 8 次；
//(2, 2, 4) 出现 2 次；
//(2, 3, 3) 出现 2 次。
// 
//
// 示例 2： 
//
// 输入：A = [1,1,2,2,2,2], target = 5
//输出：12
//解释：
//A[i] = 1，A[j] = A[k] = 2 出现 12 次：
//我们从 [1,1] 中选择一个 1，有 2 种情况，
//从 [2,2,2,2] 中选出两个 2，有 6 种情况。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= A.length <= 3000 
// 0 <= A[i] <= 100 
// 0 <= target <= 300 
// 
// Related Topics 数组 哈希表 双指针 计数 排序 
// 👍 83 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.Arrays;

public class Q0923_ThreeSumWithMultiplicity {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumMulti(int[] arr, int target) {
            int MOD = 1_000_000_007;
            long ans = 0;
            Arrays.sort(arr);

            for (int i = 0; i < arr.length; ++i) {
                // We'll try to find the number of i < j < k
                // with arr[j] + arr[k] == T, where T = target - arr[i].

                // The below is a "two sum with multiplicity".
                int T = target - arr[i];
                int j = i + 1, k = arr.length - 1;

                while (j < k) {
                    // These steps proceed as in a typical two-sum.
                    if (arr[j] + arr[k] < T)
                        j++;
                    else if (arr[j] + arr[k] > T)
                        k--;
                    else if (arr[j] != arr[k]) {  // We have arr[j] + arr[k] == T.
                        // Let's count "left": the number of arr[j] == arr[j+1] == arr[j+2] == ...
                        // arrnd similarly for "right".
                        int left = 1, right = 1;
                        while (j + 1 < k && arr[j] == arr[j + 1]) {
                            left++;
                            j++;
                        }
                        while (k - 1 > j && arr[k] == arr[k - 1]) {
                            right++;
                            k--;
                        }

                        ans += left * right;
                        ans %= MOD;
                        j++;
                        k--;
                    } else {
                        // M = k - j + 1
                        // We contributed M * (M-1) / 2 pairs.
                        ans += (k - j + 1) * (k - j) / 2;
                        ans %= MOD;
                        break;
                    }
                }
            }

            return (int) ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}