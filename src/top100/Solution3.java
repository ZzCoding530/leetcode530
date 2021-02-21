package top100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhangchen
 * @date: 2021/2/21
 * @description: 无重复字符的最长子串
 */

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        Map<Character, Integer> map = new HashMap<>(s.length());

        int left = -1;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {

            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)));
            }

            map.put(s.charAt(right), right);
            result = Math.max(result, right - left);

        }

        return result;
    }
}
