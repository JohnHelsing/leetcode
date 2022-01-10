//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。
// 你可以按 任意顺序 返回答案。
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 973 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.*;

public class Q0347_TopKFrequentElements {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            // 优先队列
//            return priorityQue(nums, k);

            // 快速排序
            return quickSort(nums, k);
        }

        public int[] quickSort(int[] nums, int k) {
            Map<Integer, Integer> occurrences = new HashMap<>();
            for (int num : nums) {
                occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
            }

            List<int[]> values = new ArrayList<int[]>();
            for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
                int num = entry.getKey(), count = entry.getValue();
                values.add(new int[]{num, count});
            }
            int[] ret = new int[k];
            qsort(values, 0, values.size() - 1, ret, 0, k);
            return ret;
        }

        public void qsort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
            int picked = (int) (Math.random() * (end - start + 1)) + start;
            Collections.swap(values, picked, start);

            int pivot = values.get(start)[1];
            int index = start;
            for (int i = start + 1; i <= end; i++) {
                if (values.get(i)[1] >= pivot) {
                    Collections.swap(values, index + 1, i);
                    index++;
                }
            }
            Collections.swap(values, start, index);

            if (k <= index - start) {
                qsort(values, start, index - 1, ret, retIndex, k);
            } else {
                for (int i = start; i <= index; i++) {
                    ret[retIndex++] = values.get(i)[0];
                }
                if (k > index - start + 1) {
                    qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
                }
            }
        }

        public int[] priorityQue(int[] nums, int k) {
            int[] res = new int[k];
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<Map.Entry<Integer, Integer>> queue
                    = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                queue.offer(entry);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            for (int i = k - 1; i >= 0; i--) {
                res[i] = queue.poll().getKey();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
