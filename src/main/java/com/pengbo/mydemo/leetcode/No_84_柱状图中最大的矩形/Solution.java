package com.pengbo.mydemo.leetcode.No_84_柱状图中最大的矩形;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        if (len == 1) return heights[0];

        List<Pair<Integer, Integer>> newHeights = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            newHeights.add(new Pair<>(i + 1, heights[i]));
        }
        // 首尾加哨兵
        newHeights.add(0, new Pair<>(0, 0));
        newHeights.add(len + 1, new Pair<>(len + 1, 0));

        Deque<Pair<Integer, Integer>> stack = new LinkedList<>();
        stack.addLast(newHeights.get(0));

        int maxResult = 0;
        for (int i = 0; i < newHeights.size(); i++) {
            // 如果待入栈元素 小于 栈顶元素值
            while (newHeights.get(i).getValue() < stack.peekLast().getValue()) {
                int height = stack.pollLast().getValue();
                int weight = i - stack.peekLast().getKey() - 1;
                maxResult = Math.max(maxResult, height * weight);
            }
            stack.addLast(newHeights.get(i));
        }

        return maxResult;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}

