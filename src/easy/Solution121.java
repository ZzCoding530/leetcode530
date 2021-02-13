package easy;

/**
 * @author: zhangchen
 * @date: 2021/2/13
 * @description: 买卖股票的最佳时机
 */

public class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][2];
        //边界条件
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            //递推公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        //毋庸置疑，最后肯定是手里没持有股票利润才会最大，也就是卖出去了
        return dp[length - 1][0];
    }

}
