package com.helsing.leetcode.note.algorithm;

import com.helsing.leetcode.editor.cn.Q0003_LongestSubstringWithoutRepeatingCharacters;
import com.helsing.leetcode.editor.cn.Q0076_MinimumWindowSubstring;
import com.helsing.leetcode.editor.cn.Q0438_FindAllAnagramsInAString;
import com.helsing.leetcode.editor.cn.Q0567_PermutationInString;

/**
 * 滑动窗口
 * 其实也是双指针
 * 重点在于什么时候增大窗口什么时候缩小窗口
 * 然后右节点走到头窗口就结束了
 *
 * @author HelSing
 * @date 2022/3/4
 */
public class SlideWindow {

    public static void main(String[] args) {

    }

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
                    HashMap<Character, Integer> need, window;
                    for (char c : t) need[c]++;
                    
                    int left = 0, right = 0;
                    int valid = 0;
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

    private void etc() {
        // 最小覆盖子串
        Q0076_MinimumWindowSubstring.main(null);

        // 字符串排列
        Q0567_PermutationInString.main(null);

        // 找所有字母异位词
        Q0438_FindAllAnagramsInAString.main(null);

        // 最长无重复子串
        Q0003_LongestSubstringWithoutRepeatingCharacters.main(null);
    }
}
