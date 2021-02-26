package top100;

import java.util.HashSet;

/**
 * @author: zhangchen
 * @date: 2021/2/26
 * @description: 最长连续序列
 */

public class Solution13 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>(nums.length);
        for (int num : nums) {
            numSet.add(num);
        }

        int result = 0;

        for (Integer currNum : numSet) {
            if (!numSet.contains(currNum - 1)) {
                int currResult = 1;

                while (numSet.contains(currNum + 1)) {
                    currNum++;
                    currResult++;
                }

                result = Math.max(result, currResult);
            }
        }

        return result;
    }
}
