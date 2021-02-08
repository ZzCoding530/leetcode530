package hard;

import java.util.HashMap;

/**
 * @author: zhangchen
 * @date: 2021/2/8
 * @description: 最小覆盖子串
 */

public class Solution76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<Character, Integer>();
        //window这个hashmap记录的是在窗口中包含那些字符串 多少次
        HashMap<Character, Integer> window = new HashMap<>();

        //把t中所有的字符都放进need这个hashmap里 key：char   value：frequency
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //定义双指针 和 已经在窗口中集齐的t中的字符个数
        int left = 0, right = 0;
        int count = 0;


        // 记录最小覆盖字串的起始索引及长度
        int start = 0, len = s.length() + 1;


        while (right < s.length()) {
            char c = s.charAt(right);

            // 判断right指针指向的字符是否在t字串中，即是否被t所需要
            //然后把
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    count++;
                }
            }
            right++;


            // 判断是否需要收缩（已经找到合适的覆盖串）
            while (count == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char c1 = s.charAt(left);

                if (need.containsKey(c1)) {
                    if (window.get(c1).equals(need.get(c1))) {
                        count--;
                    }
                    window.put(c1, window.getOrDefault(c1, 0) - 1);
                }
                left++;

            }
        }

        return len == s.length() + 1 ? "" : s.substring(start, start + len);
    }

}
