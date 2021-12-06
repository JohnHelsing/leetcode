//N 辆车沿着一条车道驶向位于 target 英里之外的共同目的地。 
//
// 每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。 
//
// 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。 
//
// 此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。 
//
// 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。 
//
// 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。 
//
// 
//
// 会有多少车队到达目的地? 
//
// 
//
// 示例： 
//
// 输入：target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
//输出：3
//解释：
//从 10 和 8 开始的车会组成一个车队，它们在 12 处相遇。
//从 0 处开始的车无法追上其它车，所以它自己就是一个车队。
//从 5 和 3 开始的车会组成一个车队，它们在 6 处相遇。
//请注意，在到达目的地之前没有其它车会遇到这些车队，所以答案是 3。
// 
//
// 
//提示： 
//
// 
// 0 <= N <= 10 ^ 4 
// 0 < target <= 10 ^ 6 
// 0 < speed[i] <= 10 ^ 6 
// 0 <= position[i] < target 
// 所有车的初始位置各不相同。 
// 
// Related Topics 栈 数组 排序 单调栈 👍 125 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.*;

public class Q0853_CarFleet {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            // 单调栈
            return stackMonotone(target, position, speed);
        }

        public int stackMonotone(int target, int[] position, int[] speed) {
            int N = position.length;
            if (N <= 1) {
                return N;
            }
            double[][] cars = new double[N][2];
            for (int i = 0; i < N; i++) {
                cars[i][0] = position[i];
                cars[i][1] = (double) (target - position[i]) / speed[i];
            }
            Arrays.sort(cars, Comparator.comparingDouble(a -> a[0])); // 以初始位置排序，离出发点近的在前
            int ans = 0;
            for (int i = N - 1; i >= 1; i--) { // 从最靠近终点的车往出发点看（从终点往后看）
                if (cars[i][1] < cars[i - 1][1]) {
                    ans++; // 如果比后一辆车到达终点的耗时短，那么后车一定追不上，所以当前车独立为一个车队
                } else {
                    cars[i - 1] = cars[i]; // 如果比后一辆车慢或同时到达终点，那么将后车到达终点的时间置为本车到达终点的时间。（被当前车阻碍）
                }
            }
            return ans + 1; // 最后一个车队
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
