//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
// 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
//
// 
//
// 示例 1: 
//
// 
//输入：s = "egg", t = "add"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "foo", t = "bar"
//输出：false 
//
// 示例 3： 
//
// 
//输入：s = "paper", t = "title"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 可以假设 s 和 t 长度相同。 
// 
// Related Topics 哈希表 字符串 👍 418 👎 0

package com.helsing.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q0205_IsomorphicStrings {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            //用数组，因为数组比哈希表要快
            char[] map=new char[128], st=s.toCharArray(), ts=t.toCharArray();
            boolean[] check=new boolean[128];
            int n=st.length;
            for(int i=0;i<n;i++){
                char a=st[i],b=ts[i];
                if(map[a]==0){
                    if(check[b]) return false;
                    map[a]=b;
                    check[b]=true;
                }else if(map[a]!=b){
                    return false;
                }
            }
            return true;


//            Map<Character, Character> s1 = new HashMap<>();
//            Map<Character, Character> t1 = new HashMap<>();
//            int len = s.length();
//            for (int i = 0; i < len; ++i) {
//                char x = s.charAt(i), y = t.charAt(i);
//                if ((s1.containsKey(x) && s1.get(x) != y)
//                        || (t1.containsKey(y) && t1.get(y) != x)) {
//                    return false;
//                }
//                s1.put(x, y);
//                t1.put(y, x);
//            }
//            return true;


//            if (s.length() != t.length()) {
//                return false;
//            }
//            if (s.equals(t) || s.length() == 1) {
//                return true;
//            }
//            for (int i = 0; i < s.length(); i++) {
//                if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
//                    return false;
//                }
//            }
//            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
