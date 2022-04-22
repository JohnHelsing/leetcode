//幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
//  输入： nums = [1,2,3]
// 输出：
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// 
// Related Topics 位运算 数组 回溯 👍 91 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class QM0804_PowerSetLcci {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            backtrack(list, new ArrayList<>(), nums, 0);
            return list;
        }

        private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
            //走过的所有路径都是子集的一部分，所以都要加入到集合中
            list.add(new ArrayList<>(tempList));
            for (int i = start; i < nums.length; i++) {
                //做出选择
                tempList.add(nums[i]);
                //递归
                backtrack(list, tempList, nums, i + 1);
                //撤销选择
                tempList.remove(tempList.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
