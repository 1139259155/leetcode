package com.pengbo.mydemo.leetcode.No_188_买卖股票的最佳时机IV;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k < 1 || len < 2) return 0;

        // k+1避免空指针
        int[][][] dp = new int[len][k + 1][2];
        for (int j = 0; j <= k; j++) {
            dp[0][j][0] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                // 第i天已第j次买入
                dp[i][j][0] = Math.max(dp[i - 1][j - 1][1] - prices[i], dp[i - 1][j][0]);
                // 第i天已第j次卖出
                dp[i][j][1] = Math.max(dp[i - 1][j][0] + prices[i], dp[i - 1][j][1]);
            }
        }

        return dp[len - 1][k][1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(solution.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}
