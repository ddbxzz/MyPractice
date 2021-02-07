package BestTimeStock;


public class Solution {

    //动态规划
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] -= prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }


    public int maxProfit2(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int maxp = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > maxp) {
                maxp = prices[i] - min;
            }
        }

        return maxp;
    }


}
