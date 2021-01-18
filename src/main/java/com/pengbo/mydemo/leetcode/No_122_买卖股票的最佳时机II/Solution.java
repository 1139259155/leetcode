package com.pengbo.mydemo.leetcode.No_122_买卖股票的最佳时机II;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        // 单调递增栈
        Deque<Integer> stack = new LinkedList<>();

        int sum = 0;
        for (int price : prices) {
            if (!stack.isEmpty() && price <= stack.peekLast()) {
                sum += stack.peekLast() - stack.peekFirst();
                stack.clear();
            }
            stack.addLast(price);
        }
        if (stack.size() > 1) sum += stack.peekLast() - stack.peekFirst();

        return sum;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
    }
}
