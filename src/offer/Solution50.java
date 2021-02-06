package offer;

import java.util.HashMap;

/**
 * @author: zhangchen
 * @date: 2021/2/6
 * @description:
 */

public class Solution50 {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            map.put(c, !map.containsKey(c));
        }
        for (char c : sc) {
            if (map.get(c)) {
                return c;
            }
        }
        return ' ';
    }
}
