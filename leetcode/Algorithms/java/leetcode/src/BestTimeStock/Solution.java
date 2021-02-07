package BestTimeStock;


public class Solution {

    //动态规划
    /*
    推导状态转移方程：

dp[i][0]：规定了今天不持股，有以下两种情况：

昨天不持股，今天什么都不做；
昨天持股，今天卖出股票（现金数增加），
dp[i][1]：规定了今天持股，有以下两种情况：

昨天持股，今天什么都不做（现金数与昨天一样）；
昨天不持股，今天买入股票（注意：只允许交易一次，因此手上的现金数就是当天的股价的相反数）。
     */
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
