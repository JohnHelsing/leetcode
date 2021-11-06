//请设计并实现一个能够展开二维向量的迭代器。该迭代器需要支持 next 和 hasNext 两种操作。 
//
// 
//
// 示例： 
//
// 
//Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
//
//iterator.next(); // 返回 1
//iterator.next(); // 返回 2
//iterator.next(); // 返回 3
//iterator.hasNext(); // 返回 true
//iterator.hasNext(); // 返回 true
//iterator.next(); // 返回 4
//iterator.hasNext(); // 返回 false
// 
//
// 
//
// 注意： 
//
// 
// 请记得 重置 在 Vector2D 中声明的类变量（静态变量），因为类变量会 在多个测试用例中保持不变，影响判题准确。请 查阅 这里。 
// 你可以假定 next() 的调用总是合法的，即当 next() 被调用时，二维向量总是存在至少一个后续元素。 
// 
//
// 
//
// 进阶：尝试在代码中仅使用 C++ 提供的迭代器 或 Java 提供的迭代器。 
// Related Topics 设计 数组 双指针 迭代器 
// 👍 46 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0251_Flatten2dVector {

    public static void main(String[] args) {
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Vector2D {

        private int[][] vector;
        private int inner = 0;
        private int outer = 0;

        public Vector2D(int[][] vec) {
            // We need to store a *reference* to the input vector.
            vector = vec;
        }

        private void advanceToNext() {
            // While outer is still within the vector, but inner is over the
            // end of the inner list pointed to by outer, we want to move
            // forward to the start of the next inner vector.
            while (outer < vector.length && inner == vector[outer].length) {
                inner = 0;
                outer++;
            }
        }

        public int next() {
            // Return current element and move inner so that is after the current
            // element.
            return vector[outer][inner++];
        }

        public boolean hasNext() {
            // Ensure the position pointers are moved such they point to an integer,
            // or put outer = vector.length.
            advanceToNext();
            // If outer = vector.length then there are no integers left, otherwise
            // we've stopped at an integer and so there's an integer left.
            return outer < vector.length;
        }
    }

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)

}