package top100;

/**
 * @author: zhangchen
 * @date: 2021/2/21
 * @description: 爬楼梯
 */

public class Solution8 {
    /**
     * 动态规划 太简单了不知道写啥
     *
     * @param n 楼梯数
     * @return 方法总数
     */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
