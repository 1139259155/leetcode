package com.pengbo.mydemo.leetcode.No_121_买卖股票的最佳时机;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) return 0;

        // profit[i]:前i个的最大利润
        int[] profits = new int[prices.length];
        profits[0] = 0;

        // 前i-1个的最小值
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            profits[i] = Math.max(profits[i - 1], prices[i] - min);
            min = Math.min(prices[i], min);
        }

        return profits[profits.length - 1];
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
    }
}
