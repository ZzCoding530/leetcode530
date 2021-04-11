package medium;

import java.util.HashMap;

/**
 * @author: zhangchen
 * @date: 2021/2/8
 * @description: 无重复的最长子串
 */

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        //特殊情况
        if (s.length() == 0) {
            return 0;
        }

        //用hashmap记录是否出现过这个字母
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        int max = 0;
        //双指针，左右指针都从0开始,左指针记录的是不重复的左边界，右指针是遍历每个字符
        int left = 0;
        for (int right = 0; right < s.length(); right++) {

            //如果map里有这个字母表示之前有重复的，那么就更新一下左边界到这个重复字母的下一位
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }

            //map里没有就加进去，然后更新max
            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;

    }


}
