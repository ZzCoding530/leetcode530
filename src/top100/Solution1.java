package top100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhangchen
 * @date: 2021/2/21
 * @description: 两数之和
 */

public class Solution1 {

    /**
     * 将 target-nums[index] 的值存在map里，key是target-nums[index] ，value是index，如果map里有，那就找到这俩数了
     * <p>
     * !!!!!一定要养成先判断边界条件的习惯!!!!!
     *
     * @param nums   给定数组
     * @param target 两数和
     * @return 返回两数的索引
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0 || nums.length == 1) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int index = 0; index < nums.length; index++) {
            if (map.containsKey(target - nums[index])) {
                return new int[]{index, map.get(target - nums[index])};
            }

            map.put(nums[index], index);
        }

        return null;
    }
}
