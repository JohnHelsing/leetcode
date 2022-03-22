//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
// Related Topics 数组 二分查找 矩阵 👍 603 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0074_SearchA2dMatrix {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{0, 1, 2}, {3, 4, 5}};
        solution.searchMatrix(matrix, 1);
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // 1 <= m, n <= 100
            int m = matrix.length;
            int n = matrix[0].length;

            // 先用二分法定位行
            int left = 0, right = m - 1;
            int mid = 0;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (matrix[mid][0] == target || matrix[mid][n - 1] == target) {
                    return true;
                }
                if (matrix[mid][0] < target && matrix[mid][n - 1] > target) {
                    break;
                } else if (mid - 1 > 0 && matrix[mid - 1][0] < target
                        && matrix[mid][0] > target) {
                    mid = mid - 1;
                    break;
                } else if (matrix[mid][0] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 在用二分法查找当前行
            left = 0;
            right = n - 1;
            int line = mid;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (matrix[line][mid] == target) {
                    return true;
                } else if (matrix[line][mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
