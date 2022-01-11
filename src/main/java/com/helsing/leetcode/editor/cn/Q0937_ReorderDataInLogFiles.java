//给你一个日志数组 logs。每条日志都是以空格分隔的字串，
// 其第一个字为字母与数字混合的 标识符 。
//
// 有两种不同类型的日志： 
//
// 
// 字母日志：除标识符之外，所有字均由小写字母组成 
// 数字日志：除标识符之外，所有字均由数字组成 
// 
//
// 请按下述规则将日志重新排序： 
//
// 
// 所有 字母日志 都排在 数字日志 之前。 
// 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。 
// 数字日志 应该保留原来的相对顺序。 
// 
//
// 返回日志的最终顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 
//art zero"]
//输出：["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6
//"]
//解释：
//字母日志的内容都不同，所以顺序为 "art can", "art zero", "own kit dig" 。
//数字日志保留原来的相对顺序 "dig1 8 1 5 1", "dig2 3 6" 。
// 
//
// 示例 2： 
//
// 
//输入：logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
//
//输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= logs.length <= 100 
// 3 <= logs[i].length <= 100 
// logs[i] 中，字与字之间都用 单个 空格分隔 
// 题目数据保证 logs[i] 都有一个标识符，并且在标识符之后至少存在一个字 
// 
// Related Topics 数组 字符串 排序 👍 95 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q0937_ReorderDataInLogFiles {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] reorderLogFiles(String[] logs) {
            // 排序
//            return sort(logs);

            // 优先队列
            return priorityQue(logs);
        }

        public String[] sort(String[] logs) {
            Arrays.sort(logs, (log1, log2) -> {
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                if (!isDigit1 && !isDigit2) {
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0) return cmp;
                    return split1[0].compareTo(split2[0]);
                }
                return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
            });
            return logs;
        }

        public String[] priorityQue(String[] logs) {
            PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> {
                int aIdx = a.indexOf(" ");
                int bIdx = b.indexOf(" ");
                String a1 = a.substring(aIdx);
                String b1 = b.substring(bIdx);
                int order = a1.compareTo(b1);
                if (order != 0) {
                    return order;
                } else {
                    a1 = a.substring(0, aIdx);
                    b1 = b.substring(0, bIdx);
                    return a1.compareTo(b1);
                }
            });
            List<String> digs = new ArrayList<>();
            for (String log : logs) {
                char ch = log.charAt(log.indexOf(" ") + 1);
                if (ch >= '0' && ch <= '9') {
                    digs.add(log);
                } else {
                    queue.offer(log);
                }
            }
            String[] res = new String[logs.length];
            int i = 0;
            while (queue.size() != 0) {
                res[i++] = queue.poll();
            }
            for (String dig : digs) {
                res[i++] = dig;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
