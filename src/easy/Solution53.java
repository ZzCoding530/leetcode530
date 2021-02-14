package easy;

/**
 * @author: zhangchen
 * @date: 2021/2/14
 * @description: 最大子序和
 */

public class Solution53 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

}
