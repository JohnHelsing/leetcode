package com.helsing.leetcode.note.algorithm;

import com.helsing.leetcode.common.bean.ListNode;

/**
 * 双指针算法
 * 双指针一般包括左右指针，快慢指针等
 * 常用在链表、二分等算法题中
 *
 * @author HelSing
 * @date 2021/11/9
 */
public class TwoPointers {


    /**
     * 左右双指针
     */
    public void leftAndRight(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            boolean leftCondition = false, rightCondition = false;
            if (leftCondition) {
                left++;
            }
            if (rightCondition) {
                right--;
            }
        }
    }

    /**
     * 先后双指针
     * 找倒数第N个之类的
     */
    public void preAndCur(ListNode head) {
        // 定义哑结点
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = head;
        while (cur != null) {
            // 满足某个条件时同时移动
            boolean someCondition = false;
            if (someCondition) {
                pre = pre.next;
            }
            // 否则前指针先移动
            cur = cur.next;
        }
        // 便于理解还可以分两次循环
        // for(someCondition){cur++}
        // for(someCondition){pre++}
    }

    /**
     * 快慢指针
     * 读写双指针，找环之类的
     *
     * @param nums
     */
    public void fastAndSlow(int[] nums) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            // 满足某个条件时，慢指针才移动
            boolean someCondition = false;
            if (someCondition) {
                slow++;
            }
            fast++;
        }
    }

    /**
     * 滑动窗口
     */
    public void slideWindow() {
        String template = """
                int left = 0, right = 0;
                while (right < s.size()) {
                    // 增大窗口
                    window.add(s[right]);
                    right++;
                    
                    while (window needs shrink) {
                        // 缩小窗口
                        window.remove(s[left]);
                        left++;
                    }
                }
                """;

        String commonTemplate = """
                /* 滑动窗口算法框架 */
                void slidingWindow(string s, string t) {
                    unordered_map<char, int> need, window;
                    for (char c : t) need[c]++;
                    
                    int left = 0, right = 0;
                    int valid = 0;\s
                    while (right < s.size()) {
                        // c 是将移入窗口的字符
                        char c = s[right];
                        // 右移窗口
                        right++;
                        // 进行窗口内数据的一系列更新
                        ...
                                
                        /*** debug 输出的位置 ***/
                        printf("window: [%d, %d)\\n", left, right);
                        /********************/
                        
                        // 判断左侧窗口是否要收缩
                        while (window needs shrink) {
                            // d 是将移出窗口的字符
                            char d = s[left];
                            // 左移窗口
                            left++;
                            // 进行窗口内数据的一系列更新
                            ...
                        }
                    }
                }
                """;
    }
}
