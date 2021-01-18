package com.pengbo.mydemo.leetcode.No_901_股票价格跨度;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/online-stock-span/
 */
class StockSpanner {
    // 单调递减栈
    public Deque<Pair<Integer, Integer>> stack;
    private int index = 0;

    public StockSpanner() {
        stack = new LinkedList<>();
        stack.addLast(new Pair<>(index++, Integer.MAX_VALUE));
    }

    public int next(int price) {
        while (price >= stack.peekLast().getValue()) {
            stack.pollLast();
        }
        int weight = index - stack.peekLast().getKey();
        stack.addLast(new Pair<>(index++, price));
        return weight;
    }
    public static void main(String[] args) {
        //System.out.println(new StockSpanner().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }
}

