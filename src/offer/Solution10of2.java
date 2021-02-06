package offer;

/**
 * @author: zhangchen
 * @date: 2021/2/6
 * @description:
 */

public class Solution10of2 {
    public int numWays(int n) {
        int[] dp = new int[n + 1];

        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000_000_007;
        }

        return dp[n];

    }

    public static void main(String[] args) {
        System.out.println(new Solution10of2().numWays(7));
    }

}
