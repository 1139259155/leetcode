package com.pengbo.mydemo.leetcode.No_123_买卖股票的最佳时机III;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;

        /**
         * 状态数组
         * i : 第i天
         * j : 第i天的操作：不操作/已第一次买入/已第一次卖出/已第二次买入/已第二次卖出， 取值0,1,2,3,4
         */
        int[][] dp = new int[len][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;

        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][0];
            // 第i天第一次买入，或者前一天已第一次买入
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            // 第i天第一次卖出，或者前一天已第一次卖出
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
            // 第i天第二次买入，或者前一天已第二次买入
            dp[i][3] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][3]);;
            // 第i天第二次卖出，或者前一天已第二次卖出
            dp[i][4] = Math.max(dp[i - 1][3] + prices[i], dp[i - 1][4]);;
        }

        return dp[len-1][4];
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
    }

}
