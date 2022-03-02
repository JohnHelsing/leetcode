package com.helsing.leetcode.note.algorithm;

/**
 * 二分查找算法
 * <p>
 * 核心在于到底要给 mid 加一还是减一，while 里到底用 <= 还是 <。
 *
 * @author HelSing
 * @date 2021/11/15
 */
public class BinaryFind {

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
    }
}
