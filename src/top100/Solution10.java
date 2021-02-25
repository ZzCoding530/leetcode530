package top100;

/**
 * @author: zhangchen
 * @date: 2021/2/25
 * @description: 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */

public class Solution10 {
    public int maxSubArray(int[] nums) {

        int resMax = nums[0];
        int sum = 0;

        for (int eachNum : nums) {
            if (sum > 0) {
                sum += eachNum;
            } else {
                sum = eachNum;
            }

            resMax = Math.max(sum, resMax);
        }

        return resMax;
    }
}
