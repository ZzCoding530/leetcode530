package easy;

import java.util.HashMap;

/**
 * @author: zhangchen
 * @date: 2021/1/27
 * @description: 两数相加
 */

public class Solution1 {

    public int[] twoSum(int[] nums, int target) {

        if (nums.length == 0 || nums.length == 1) {
            return null;
        }
        // key 是 target-nums[i]  value 是 索引i
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {

            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{i, hashMap.get(target - nums[i])};
            }

            hashMap.put(nums[i], i);

        }

        return null;
    }
}
