package com.helsing.leetcode.note.algorithm;

import com.helsing.leetcode.editor.cn.Q0034_FindFirstAndLastPositionOfElementInSortedArray;
import com.helsing.leetcode.editor.cn.Q0704_BinarySearch;

/**
 * 二分查找算法
 * <p>
 * 核心在于到底要给 mid 加一还是减一，while 里到底用 <= 还是 <。
 *
 * @author HelSing
 * @date 2021/11/15
 */
public class BinaryFind {

    public static void main(String[] args) {

    }

    private void template() {
        String template = """
                int left = 0, right = ...;
                    while(...) {
                        // 防溢出
                        int mid = left + (right - left) / 2;
                        if (nums[mid] == target) {
                            ...
                        } else if (nums[mid] < target) {
                            left = ...
                        } else if (nums[mid] > target) {
                            right = ...
                        }
                    }
                    return ...;
                """;
        // 统一写法
        template = """
                int binary_search(int[] nums, int target) {
                    int left = 0, right = nums.length - 1;
                    while(left <= right) {
                        int mid = left + (right - left) / 2;
                        if (nums[mid] < target) {
                            left = mid + 1;
                        } else if (nums[mid] > target) {
                            right = mid - 1;
                        } else if(nums[mid] == target) {
                            // 直接返回
                            return mid;
                        }
                    }
                    // 直接返回
                    return -1;
                }
                                
                int left_bound(int[] nums, int target) {
                    int left = 0, right = nums.length - 1;
                    while (left <= right) {
                        int mid = left + (right - left) / 2;
                        if (nums[mid] < target) {
                            left = mid + 1;
                        } else if (nums[mid] > target) {
                            right = mid - 1;
                        } else if (nums[mid] == target) {
                            // 别返回，锁定左侧边界
                            right = mid - 1;
                        }
                    }
                    // 最后要检查 left 越界的情况
                    if (left >= nums.length || nums[left] != target) {
                        return -1;
                    }
                    return left;
                }
                                
                int right_bound(int[] nums, int target) {
                    int left = 0, right = nums.length - 1;
                    while (left <= right) {
                        int mid = left + (right - left) / 2;
                        if (nums[mid] < target) {
                            left = mid + 1;
                        } else if (nums[mid] > target) {
                            right = mid - 1;
                        } else if (nums[mid] == target) {
                            // 别返回，锁定右侧边界
                            left = mid + 1;
                        }
                    }
                    // 最后要检查 right 越界的情况
                    if (right < 0 || nums[right] != target) {
                        return -1;
                    }
                    return right;
                }
                """;
    }

    private void etc() {
        // 寻找一个数（基本的二分搜索）
        Q0704_BinarySearch.main(null);

        // 寻找左侧边界的二分搜索
        // 当 nums[mid] == target 时，不要立即返回，
        // 而是缩小「搜索区间」的上界 right，使得区间不断向左收缩，达到锁定左侧边界的目的。

        // 寻找右侧边界的二分查找
        // 当 nums[mid] == target 时，不要立即返回，
        // 而是增大「搜索区间」的下界 left，使得区间不断向右收缩，达到锁定右侧边界的目的。
        Q0034_FindFirstAndLastPositionOfElementInSortedArray.main(null);
    }

}
