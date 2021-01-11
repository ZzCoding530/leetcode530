package offer;

import java.util.HashMap;

/**
 * @author: zhangchen
 * @date: 2021/1/11
 * @description:
 */

public class Solution03 {
    public int findRepeatNumber(int[] nums) {
        int res = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);
        for (int num : nums) {

            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                res = num;
                break;
            }
        }
        return res;
    }
}
