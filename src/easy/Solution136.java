package easy;

/**
 * @author: zhangchen
 * @date: 2021/1/6
 * @description: 只出现一次的数字
 */

class Solution136 {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}

