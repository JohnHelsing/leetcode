//给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。 
//
// 实现 MovingAverage 类： 
//
// 
// MovingAverage(int size) 用窗口大小 size 初始化对象。 
// double next(int val) 计算并返回数据流中最后 size 个值的移动平均值。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MovingAverage", "next", "next", "next", "next"]
//[[3], [1], [10], [3], [5]]
//输出：
//[null, 1.0, 5.5, 4.66667, 6.0]
//
//解释：
//MovingAverage movingAverage = new MovingAverage(3);
//movingAverage.next(1); // 返回 1.0 = 1 / 1
//movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
//movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
//movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= size <= 1000 
// -105 <= val <= 105 
// 最多调用 next 方法 104 次 
// 
// Related Topics 设计 队列 数组 数据流 
// 👍 71 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0346_MovingAverageFromDataStream {

    public static void main(String[] args) {
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class MovingAverage {
        int size, windowSum = 0, count = 0;
        Deque queue = new ArrayDeque<Integer>();

        public MovingAverage(int size) {
            this.size = size;
        }

        public double next(int val) {
            count++;
            // calculate the new sum by shifting the window
            queue.add(val);
            int tail = count > size ? (int) queue.poll() : 0;

            windowSum = windowSum - tail + val;

            return windowSum * 1.0 / Math.min(size, count);
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

}