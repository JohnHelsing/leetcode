//我们对 0 到 255 之间的整数进行采样，并将结果存储在数组 count 中：count[k] 就是整数 k 的采样个数。 
//
// 我们以 浮点数 数组的形式，分别返回样本的最小值、最大值、平均值、中位数和众数。其中，众数是保证唯一的。 
//
// 我们先来回顾一下中位数的知识： 
//
// 
// 如果样本中的元素有序，并且元素数量为奇数时，中位数为最中间的那个元素； 
// 如果样本中的元素有序，并且元素数量为偶数时，中位数为中间的两个元素的平均值。 
// 
//
// 
//
// 示例 1： 
//
// 输入：count = [0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
//,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
//,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
//,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
//,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
//,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
//,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
//输出：[1.00000,3.00000,2.37500,2.50000,3.00000]
// 
//
// 示例 2： 
//
// 输入：count = [0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
//,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
//,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
//,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
//,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
//,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
//,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
//输出：[1.00000,4.00000,2.18182,2.00000,1.00000]
// 
//
// 
//
// 提示： 
//
// 
// count.length == 256 
// 1 <= sum(count) <= 10^9 
// 计数表示的众数是唯一的 
// 答案与真实值误差在 10^-5 以内就会被视为正确答案 
// 
// Related Topics 数学 双指针 概率与统计 
// 👍 22 👎 0

package com.helsing.leetcode.editor.cn;

public class Q1093_StatisticsFromALargeSample {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] sampleStats(int[] count) {
            return doublePoint(count);
        }

        public double[] doublePoint(int[] count) {
            double[] result = new double[5];//最小值、最大值、平均值、中位数和众数
            double max = 0;
            double min = 0;
            long sum = 0;
            double mid = 0;
            double maxN = 0;
            double total = 0;
            int maxNCount = 0;

            for (int i = 0; i < count.length; i++) {
                sum += i * 1.0 * count[i];
                if (count[i] > maxNCount) {
                    maxN = i;
                    maxNCount = count[i];
                }
                if (count[i] != 0) {
                    max = i;
                    total += count[i];
                }
                if (count[count.length - i - 1] != 0) {
                    min = count.length - i - 1;
                }
            }

            int tmp = 0;
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    tmp += count[i];
                    if (tmp == total / 2) {
                        int j = i + 1;
                        while (count[j] == 0) {
                            j++;
                        }
                        mid = (i + j) / 2.0;
                        break;
                    }
                    if (tmp > total / 2) {
                        mid = i;
                        break;
                    }
                }
            }
            result[0] = min;
            result[1] = max;
            result[2] = sum / total;
            result[3] = mid;
            result[4] = maxN;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}