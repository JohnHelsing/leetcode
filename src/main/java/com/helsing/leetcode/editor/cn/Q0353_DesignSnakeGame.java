//请你设计一个 贪吃蛇游戏，该游戏将会在一个 屏幕尺寸 = 宽度 x 高度 的屏幕上运行。如果你不熟悉这个游戏，可以 点击这里 在线试玩。 
//
// 起初时，蛇在左上角的 (0, 0) 位置，身体长度为 1 个单位。 
//
// 你将会被给出一个数组形式的食物位置序列 food ，其中 food[i] = (ri, ci) 。当蛇吃到食物时，身子的长度会增加 1 个单位，得分也会 
//+1 。 
//
// 食物不会同时出现，会按列表的顺序逐一显示在屏幕上。比方讲，第一个食物被蛇吃掉后，第二个食物才会出现。 
//
// 当一个食物在屏幕上出现时，保证 不会 出现在被蛇身体占据的格子里。 
//
// 如果蛇越界（与边界相撞）或者头与 移动后 的身体相撞（即，身长为 4 的蛇无法与自己相撞），游戏结束。 
//
// 实现 SnakeGame 类： 
//
// 
// SnakeGame(int width, int height, int[][] food) 初始化对象，屏幕大小为 height x width ，食物
//位置序列为 food 
// int move(String direction) 返回蛇在方向 direction 上移动后的得分。如果游戏结束，返回 -1 。 
// 
// 
//
// 示例 1： 
//
// 
//输入：
//["SnakeGame", "move", "move", "move", "move", "move", "move"]
//[[3, 2, [[1, 2], [0, 1]]], ["R"], ["D"], ["R"], ["U"], ["L"], ["U"]]
//输出：
//[null, 0, 0, 1, 1, 2, -1]
//
//解释：
//SnakeGame snakeGame = new SnakeGame(3, 2, [[1, 2], [0, 1]]);
//snakeGame.move("R"); // 返回 0
//snakeGame.move("D"); // 返回 0
//snakeGame.move("R"); // 返回 1 ，蛇吃掉了第一个食物，同时第二个食物出现在 (0, 1)
//snakeGame.move("U"); // 返回 1
//snakeGame.move("L"); // 返回 2 ，蛇吃掉了第二个食物，没有出现更多食物
//snakeGame.move("U"); // 返回 -1 ，蛇与边界相撞，游戏结束
// 
//
// 
//
// 提示： 
//
// 
// 1 <= width, height <= 104 
// 1 <= food.length <= 50 
// food[i].length == 2 
// 0 <= ri < height 
// 0 <= ci < width 
// direction.length == 1 
// direction is 'U', 'D', 'L', or 'R'. 
// 最多调用 104 次 move 方法 
// 
// Related Topics 设计 队列 数组 矩阵 
// 👍 59 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0353_DesignSnakeGame {

    public static void main(String[] args) {
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class SnakeGame {

        private int width, height, foodId, score;

        private int[][] food;

        private Deque<Integer> snack;

        /**
         * Initialize your data structure here.
         *
         * @param width  - screen width
         * @param height - screen height
         * @param food   - A list of food positions
         *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
         */
        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            this.food = food;
            this.foodId = 0;
            this.score = 0;
            this.snack = new ArrayDeque<>();
            snack.addLast(0);
        }

        /**
         * Moves the snake.
         *
         * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         * @return The game's score after the move. Return -1 if game over.
         * Game over when snake crosses the screen boundary or bites its body.
         */
        public int move(String direction) {
            Integer head = snack.peekLast();
            int row = head / width;
            int column = head % width;
            if (direction.equals("U")) {
                row--;
            } else if (direction.equals("L")) {
                column--;
            } else if (direction.equals("R")) {
                column++;
            } else {
                row++;
            }
            // 1.第一种情况，是否超出边界
            if (row < 0 || row >= height || column < 0 || column >= width) {
                return -1;
            }

            // 2. 第二种情况，吃到食物加头
            if (foodId < food.length && row == food[foodId][0] && column == food[foodId][1]) {
                snack.addLast(row * width + column);
                foodId++;
                return ++score;
            }

            // 3. 去尾
            snack.pollFirst();
            // 4. 检查是否与自身相撞
            if (snack.contains(row * width + column)) {
                return -1;
            } else {
                // 5. 加头
                snack.addLast(row * width + column);
                return score;
            }
        }
    }

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
//leetcode submit region end(Prohibit modification and deletion)

}