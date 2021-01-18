package com.pengbo.mydemo.leetcode.No_739_每日温度;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        if (len == 1) return new int[]{0};

        int[] results = new int[len];

        // 递减栈
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(0);
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peekLast()]) {
                int index = stack.pollLast();
                results[index] = i - index;
            }
            stack.addLast(i);
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }
}

