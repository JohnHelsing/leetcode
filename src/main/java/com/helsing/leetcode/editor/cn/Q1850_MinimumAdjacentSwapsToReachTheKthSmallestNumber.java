//给你一个表示大整数的字符串 num ，和一个整数 k 。 
//
// 如果某个整数是 num 中各位数字的一个 排列 且它的 值大于 num ，则称这个整数为 妙数 。可能存在很多妙数，但是只需要关注 值最小 的那些。 
//
// 
// 例如，num = "5489355142" ：
//
// 
// 第 1 个最小妙数是 "5489355214" 
// 第 2 个最小妙数是 "5489355241" 
// 第 3 个最小妙数是 "5489355412" 
// 第 4 个最小妙数是 "5489355421" 
// 
// 
// 
//
// 返回要得到第 k 个 最小妙数 需要对 num 执行的 相邻位数字交换的最小次数 。 
//
// 测试用例是按存在第 k 个最小妙数而生成的。 
//
// 
//
// 示例 1： 
//
// 输入：num = "5489355142", k = 4
//输出：2
//解释：第 4 个最小妙数是 "5489355421" ，要想得到这个数字：
//- 交换下标 7 和下标 8 对应的位："5489355142" -> "5489355412"
//- 交换下标 8 和下标 9 对应的位："5489355412" -> "5489355421"
// 
//
// 示例 2： 
//
// 输入：num = "11112", k = 4
//输出：4
//解释：第 4 个最小妙数是 "21111" ，要想得到这个数字：
//- 交换下标 3 和下标 4 对应的位："11112" -> "11121"
//- 交换下标 2 和下标 3 对应的位："11121" -> "11211"
//- 交换下标 1 和下标 2 对应的位："11211" -> "12111"
//- 交换下标 0 和下标 1 对应的位："12111" -> "21111"
// 
//
// 示例 3： 
//
// 输入：num = "00123", k = 1
//输出：1
//解释：第 1 个最小妙数是 "00132" ，要想得到这个数字：
//- 交换下标 3 和下标 4 对应的位："00123" -> "00132"
// 
//
// 
//
// 提示： 
//
// 
// 2 <= num.length <= 1000 
// 1 <= k <= 1000 
// num 仅由数字组成 
// 
// Related Topics 贪心 双指针 字符串 
// 👍 30 👎 0

package com.helsing.leetcode.editor.cn;

public class Q1850_MinimumAdjacentSwapsToReachTheKthSmallestNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int result = 0;

        public int getMinSwaps(String num, int k) {
            int len = num.length();
            int[] intnum = new int[len];
            int[] beginnum = new int[len];//起始数据
            for (int i = 0; i < num.length(); i++) {
                intnum[i] = num.charAt(i) - '0';
                beginnum[i] = num.charAt(i) - '0';
            }
            for (int i = 0; i < k; i++) {
                intnum = nextPermutation(intnum);
            }
            int[] knum = intnum;//第k个妙数
            for (int i = 0; i < len; i++) {
                if (beginnum[i] != knum[i]) {
                    int j = i + 1;
                    while (beginnum[j] != knum[i]) {
                        j++;
                    }//找到相同数据，开始交换
                    while (j != i) {
                        swap(beginnum, j - 1, j);//只能两两交换
                        result++;
                        j--;
                    }
                }
            }
            return result;
        }

        //寻找下一个妙数
        public int[] nextPermutation(int[] nums) {
            int len = nums.length;
            for (int i = len - 1; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {//nums[i-1]处的元素要进行位置调换
                    int j = len - 1;
                    while (nums[j] <= nums[i - 1]) {
                        j--;
                    }
                    //从i到j都比nums[i-1]大
                    //nums[i-1]和nums[j]先调换位置
                    swap(nums, i - 1, j);
                    //反转nums[i-1]之后的所有元素
                    j = len - 1;
                    while (i < j) {
                        swap(nums, i++, j--);
                    }
                    break;
                }
            }
            return nums;
        }

        //交换nums数组第i和第j处的元素
        public void swap(int[] nums, int i, int j) {
            int m = nums[i];
            nums[i] = nums[j];
            nums[j] = m;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}