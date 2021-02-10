package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhangchen
 * @date: 2021/2/6
 * @description: 最长不重复子串
 */

public class Solution48 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (dic.containsKey(s.charAt(j))) {
                // 更新左指针 i
                i = Math.max(i, dic.get(s.charAt(j)));
            }
            // 哈希表记录
            dic.put(s.charAt(j), j);
            // 更新结果
            res = Math.max(res, j - i);
        }
        return res;
    }




}
