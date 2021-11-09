//给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。 
//
// 一个子数组指的是原数组中连续的一个子序列。 
//
// 请你返回满足题目要求的最短子数组的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,10,4,2,3,5]
//输出：3
//解释：我们需要删除的最短子数组是 [10,4,2] ，长度为 3 。剩余元素形成非递减数组 [1,2,3,3,5] 。
//另一个正确的解为删除子数组 [3,10,4] 。 
//
// 示例 2： 
//
// 
//输入：arr = [5,4,3,2,1]
//输出：4
//解释：由于数组是严格递减的，我们只能保留一个元素。所以我们需要删除长度为 4 的子数组，要么删除 [5,4,3,2]，要么删除 [4,3,2,1]。
// 
//
// 示例 3： 
//
// 
//输入：arr = [1,2,3]
//输出：0
//解释：数组已经是非递减的了，我们不需要删除任何元素。
// 
//
// 示例 4： 
//
// 
//输入：arr = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// 0 <= arr[i] <= 10^9 
// 
// Related Topics 栈 数组 双指针 二分查找 单调栈 
// 👍 57 👎 0

package com.helsing.leetcode.editor.cn;

public class Q1574_ShortestSubarrayToBeRemovedToMakeArraySorted {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLengthOfShortestSubarray(int[] arr) {
            int len = arr.length;

            // leftEnd作为左边区域 结束位置的指针,rightStart作为右边区域 起始位置的指针
            int leftEnd = 0, rightStart = len - 1;

            // 计算左边区域 能到的最右的位置
            for (; leftEnd < len - 1; leftEnd++) {
                if (arr[leftEnd] > arr[leftEnd + 1]) {
                    break;
                }
            }

            // 如果最右的位置超过了数组空间，说明整个数组都是递增的，不用删除子数组
            if (leftEnd == len - 1) {
                return 0;
            }

            // 计算右边区域 能到的最左边的位置
            for (; rightStart > 1; rightStart--) {
                if (arr[rightStart] < arr[rightStart - 1]) {
                    break;
                }
            }

            // 既然leftEnd和rightStart两处位置符合递增的大小关系，那也就是说 左边全部 + 右边全部 是递增的，
            // 那自然也是最长的，所以要删除的也是最短的。例子：{1，4，6，2，3，7，6，7，8，9}
            if (arr[leftEnd] <= arr[rightStart]) {
                return rightStart - leftEnd - 1;
            }

            // 执行到这一步，说明上面的情况都不符合，需要从三个区域中找删除最短的情况

            // 保留当前删除子数组最短的情况，和后面计算里，综合取最短！当前已知能删除的情况有：
            //    ① 保留左边区域， 删除之后的子数组
            //    ② 保留右边区域， 删除之前的子数组       二者取最短的
            int deleteMinLen = Math.min(len - leftEnd - 1, rightStart);

            // 然后计算 左边部分+右边部分 的情况。
            // 到这里因为已经排除了：左边全部 + 右边全部的情况，例子：{1,3,5,8,2,3,5,3,4,5,6,7,8,9}
            // 所以我们现在取最大化的结果，最少删除 左边和右边的长度
            // 最干脆的方式就是从左边区域的第一个起，找每一个元素（下标i）在 右边区域第一个大于等于他的元素（下标j）
            // 取 j - i - 1最小的情况！
            // 二分查找的实现方式：
            for (int i = 0; i <= leftEnd; i++) {
                deleteMinLen = Math.min(deleteMinLen, binarySearch(arr, rightStart, arr[i]) - i - 1);
            }

            return deleteMinLen;
        }

        // 二分查找
        public int binarySearch(int[] arr, int start, int target) {
            int left = start, right = arr.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] < target) {
                    left = mid + 1;
                } else { // arr[mid] >= num
                    // 如果已经是最左边的值或者当前位置的前一个小于num，说明当前位置就是第一个大于等于的元素
                    if (mid == start || arr[mid - 1] < target) {
                        return mid;
                    }
                    right = mid - 1;
                }
            }
            return Integer.MAX_VALUE;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}