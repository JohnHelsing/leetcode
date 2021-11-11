//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 队列 哈希表 字符串 计数 
// 👍 459 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Q0387_FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            // 队列
            return queue(s);
        }

        public int queue(String s) {
            Map<Integer, Integer> position = new HashMap<>();
            Queue<int[]> queue = new ArrayDeque<>();
            int n = s.length();
            for (int i = 0; i < n; ++i) {
                int ch = s.charAt(i);
                if (!position.containsKey(ch)) {
                    position.put(ch, i);
                    int[] temp = new int[2];
                    temp[0] = ch;
                    temp[1] = i;
                    queue.offer(temp);
                } else {
                    position.put(ch, -1);
                    while (!queue.isEmpty() && queue.peek() != null && position.get(queue.peek()[0]) == -1) {
                        queue.poll();
                    }
                }
            }
            return queue.isEmpty() ? -1 : queue.poll()[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}