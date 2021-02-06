package offer;

/**
 * @author: zhangchen
 * @date: 2021/1/31
 * @description: 动态规划
 */

public class Solution42 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }


}
