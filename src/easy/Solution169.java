package easy;

import java.util.HashMap;

/**
 * @author: zhangchen
 * @date: 2021/1/6
 * @description: 多数元素
 */

public class Solution169 {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);
        int result = 0;
        //依次放入hashmap中
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                hashMap.put(num, hashMap.get(num) + 1);
                if (hashMap.get(num) > nums.length / 2) {
                    result = num;
                    break;

                }
            }
        }
        return result;
    }
}
