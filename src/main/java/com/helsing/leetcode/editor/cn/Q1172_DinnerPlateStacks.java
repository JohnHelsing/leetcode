//我们把无限数量 ∞ 的栈排成一行，按从左到右的次序从 0 开始编号
// 每个栈的的最大容量 capacity 都相同。
//
// 实现一个叫「餐盘」的类 DinnerPlates： 
//
// 
// DinnerPlates(int capacity) - 给出栈的最大容量 capacity。 
// void push(int val) - 将给出的正整数 val 推入 从左往右第一个 没有满的栈。 
// int pop() - 返回 从右往左第一个 非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回 -1。 
// int popAtStack(int index) - 返回编号 index 的栈顶部的值，并将其从栈中删除；如果编号 index 的栈是空的，请返回 -
//1。 
// 
//
// 
//
// 示例： 
//
// 输入： 
//["DinnerPlates","push","push","push","push","push","popAtStack","push","push",
//"popAtStack","popAtStack","pop","pop","pop","pop","pop"]
//[[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
//输出：
//[null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]
//
//解释：
//DinnerPlates D = DinnerPlates(2);  // 初始化，栈最大容量 capacity = 2
//D.push(1);
//D.push(2);
//D.push(3);
//D.push(4);
//D.push(5);         // 栈的现状为：    2  4
//                                    1  3  5
//                                    ﹈ ﹈ ﹈
//D.popAtStack(0);   // 返回 2。栈的现状为：      4
//                                          1  3  5
//                                          ﹈ ﹈ ﹈
//D.push(20);        // 栈的现状为：  20  4
//                                   1  3  5
//                                   ﹈ ﹈ ﹈
//D.push(21);        // 栈的现状为：  20  4 21
//                                   1  3  5
//                                   ﹈ ﹈ ﹈
//D.popAtStack(0);   // 返回 20。栈的现状为：       4 21
//                                            1  3  5
//                                            ﹈ ﹈ ﹈
//D.popAtStack(2);   // 返回 21。栈的现状为：       4
//                                            1  3  5
//                                            ﹈ ﹈ ﹈ 
//D.pop()            // 返回 5。栈的现状为：        4
//                                            1  3 
//                                            ﹈ ﹈  
//D.pop()            // 返回 4。栈的现状为：    1  3 
//                                           ﹈ ﹈   
//D.pop()            // 返回 3。栈的现状为：    1 
//                                           ﹈   
//D.pop()            // 返回 1。现在没有栈。
//D.pop()            // 返回 -1。仍然没有栈。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 20000 
// 1 <= val <= 20000 
// 0 <= index <= 100000 
// 最多会对 push，pop，和 popAtStack 进行 200000 次调用。 
// 
// Related Topics 栈 设计 哈希表 堆（优先队列） 👍 33 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.*;

public class Q1172_DinnerPlateStacks {

    public static void main(String[] args) {
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class DinnerPlates {
        int mm;
        int capacity;
        ArrayList<Deque<Integer>> list;

        public DinnerPlates(int capacity) {
            this.mm = 0;
            this.capacity = capacity;
            this.list = new ArrayList<>();
        }

        public void push(int val) {
            // 如果最大容量小于等于0，直接结束
            if (capacity <= 0) {
                return;
            }
            // 如果list为空，则创建一个空栈，add到list中
            if (list.isEmpty()) {
                list.add(new ArrayDeque<>());
            }
            // 如果获得的栈是满的，则递归重复获取(从左往右)
            mm = list.size() > mm ? mm : list.size() - 1;
            Deque<Integer> stack = list.get(mm);
            int index = mm;
            while (stack.size() == capacity && index < list.size() - 1) {
                index++;
                stack = list.get(index);
            }
            // 如果都是满的，则新建一个栈并加入到list中
            if (stack.size() == capacity) {
                stack = new ArrayDeque<>();
                list.add(stack);
            }
            // 插入动作
            stack.push(val);
            mm = list.size() - 1;
        }

        public int pop() {
            // 如果list为空，则返回-1
            if (list.isEmpty()) {
                return -1;
            }
            // 从右往左获得一个非空的栈
            Deque<Integer> stack = list.get(list.size() - 1);
            int index = list.size() - 1;
            while (stack.isEmpty() && index > 0) {
                list.remove(index);
                index--;
                stack = list.get(index);
            }
            if (stack.isEmpty()) {
                return -1;
            }
            // 弹出操作
            int res = stack.pop();
            // 如果弹出后栈为空，则删除该栈
            if (stack.isEmpty()) {
                list.remove(index);
            }
            return res;
        }

        public int popAtStack(int index) {
            // 如果list为空，则返回-1
            if (list.isEmpty()) {
                return -1;
            }
            // 如果index越界，返回-1
            if (index >= list.size() || index < 0) {
                return -1;
            }
            // 获得编号为index的栈
            Deque<Integer> stack = list.get(index);
            if (stack.isEmpty()) {
                return -1;
            }
            // 弹出操作
            int res = stack.pop();
            // 如果弹出后栈为空，则删除该栈
            mm = index;
            return res;
        }
    }

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
