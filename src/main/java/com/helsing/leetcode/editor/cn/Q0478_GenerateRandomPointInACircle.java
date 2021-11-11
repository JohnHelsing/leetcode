//给定圆的半径和圆心的 x、y 坐标，写一个在圆中产生均匀随机点的函数 randPoint 。 
//
// 说明: 
//
// 
// 输入值和输出值都将是浮点数。 
// 圆的半径和圆心的 x、y 坐标将作为参数传递给类的构造函数。 
// 圆周上的点也认为是在圆中。 
// randPoint 返回一个包含随机点的x坐标和y坐标的大小为2的数组。 
// 
//
// 示例 1： 
//
// 
//输入: 
//["Solution","randPoint","randPoint","randPoint"]
//[[1,0,0],[],[],[]]
//输出: [null,[-0.72939,-0.65505],[-0.78502,-0.28626],[-0.83119,-0.19803]]
// 
//
// 示例 2： 
//
// 
//输入: 
//["Solution","randPoint","randPoint","randPoint"]
//[[10,5,-7.5],[],[],[]]
//输出: [null,[11.52438,-8.33273],[2.46992,-16.21705],[11.13430,-12.42337]] 
//
// 输入语法说明： 
//
// 输入是两个列表：调用成员函数名和调用的参数。Solution 的构造函数有三个参数，圆的半径、圆心的 x 坐标、圆心的 y 坐标。randPoint 没有
//参数。输入参数是一个列表，即使参数为空，也会输入一个 [] 空列表。 
// Related Topics 几何 数学 拒绝采样 随机化 
// 👍 68 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0478_GenerateRandomPointInACircle {

    public static void main(String[] args) {
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        double rad, xc, yc;

        public Solution(double radius, double x_center, double y_center) {
            rad = radius;
            xc = x_center;
            yc = y_center;
        }

        public double[] randPoint() {
            double x0 = xc - rad;
            double y0 = yc - rad;
            while (true) {
                double xg = x0 + Math.random() * rad * 2;
                double yg = y0 + Math.random() * rad * 2;
                if (Math.sqrt(Math.pow((xg - xc), 2) + Math.pow((yg - yc), 2)) <= rad) {
                    return new double[]{xg, yg};
                }
            }
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
//leetcode submit region end(Prohibit modification and deletion)

}