//在一条单车道上有 n 辆车，它们朝着同样的方向行驶。给你一个长度为 n 的数组 cars ，其中 cars[i] = [positioni, speedi]
// ，它表示： 
//
// 
// positioni 是第 i 辆车和道路起点之间的距离（单位：米）。题目保证 positioni < positioni+1 。 
// speedi 是第 i 辆车的初始速度（单位：米/秒）。 
// 
//
// 简单起见，所有车子可以视为在数轴上移动的点。当两辆车占据同一个位置时，我们称它们相遇了。一旦两辆车相遇，它们会合并成一个车队，这个车队里的车有着同样的位置
//和相同的速度，速度为这个车队里 最慢 一辆车的速度。 
//
// 请你返回一个数组 answer ，其中 answer[i] 是第 i 辆车与下一辆车相遇的时间（单位：秒），如果这辆车不会与下一辆车相遇，则 
//answer[i] 为 -1 。答案精度误差需在 10⁻⁵ 以内。 
//
// 
//
// 示例 1： 
//
// 
//输入：cars = [[1,2],[2,1],[4,3],[7,2]]
//输出：[1.00000,-1.00000,3.00000,-1.00000]
//解释：经过恰好 1 秒以后，第一辆车会与第二辆车相遇，并形成一个 1 m/s 的车队。经过恰好 3 秒以后，第三辆车会与第四辆车相遇，并形成一个 2 m/
//s 的车队。
// 
//
// 示例 2： 
//
// 
//输入：cars = [[3,4],[5,4],[6,3],[9,1]]
//输出：[2.00000,1.00000,1.50000,-1.00000]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= cars.length <= 10⁵ 
// 1 <= positioni, speedi <= 10⁶ 
// positioni < positioni+1 
// 
// Related Topics 栈 数组 数学 单调栈 堆（优先队列） 👍 55 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q1776_CarFleetIi {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] getCollisionTimes(int[][] cars) {
            // 单调栈
            return stackMonotone(cars);
        }

        public double[] stackMonotone(int[][] cars) {
            int n = cars.length;
            double[] ans = new double[n];
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = n - 1; i >= 0; i--) {
                //栈不为空，需要比较当前车速与栈顶车速
                while (!stack.isEmpty()) {
                    //栈顶车速大于当前车速，则当前车追不上栈顶车，但是有可能追上栈顶元素的前一辆车
                    if (cars[stack.peek()][1] >= cars[i][1]) {
                        stack.pop();
                    } else {//当前车速大于栈顶车速
                        //栈顶车撞不上它前面的车，因此，当前车一定可以撞上栈顶车
                        if (ans[stack.peek()] < 0) {
                            break;
                        } else {//栈顶车能撞上前面的车，需要分情况讨论
                            //如果当前车能在栈顶车撞上前面车之前就能够撞上栈顶车，则直接撞上去
                            if (((double) (cars[stack.peek()][0] - cars[i][0])) / ((double) (cars[i][1] - cars[stack.peek()][1])) <= ans[stack.peek()]) {
                                break;
                            } else {//否则的话，当前车就只能撞到栈顶车前面的车了
                                stack.pop();
                            }
                        }
                    }
                }
                //初始时，栈为空，前面没车可撞
                if (stack.isEmpty()) {
                    ans[i] = -1;
                } else {//栈不为空，则撞上栈顶车
                    ans[i] = ((double) (cars[stack.peek()][0] - cars[i][0])) / ((double) (cars[i][1] - cars[stack.peek()][1]));
                }
                //当前车结果求出后，入栈
                stack.push(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
