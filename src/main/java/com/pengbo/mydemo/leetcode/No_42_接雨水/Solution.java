package com.pengbo.mydemo.leetcode.No_42_接雨水;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
class Solution {
    public int trap(int[] height) {
        // special judge
        int len = height.length;
        if (len < 3) return 0;

        // set sentinel at begin&end
        int[] newHeiht = new int[len + 2];
        System.arraycopy(height, 0, newHeiht, 1, len);
        newHeiht[0] = Integer.MAX_VALUE;
        newHeiht[len + 1] = Integer.MAX_VALUE;
        height = newHeiht;

        // decrease stack
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(0);

        // calculate
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            while (height[i] >= height[stack.peekLast()]) {
                int topIndex = stack.pollLast();
                if (stack.peekLast() != 0) {
                    int bottomHeight = height[topIndex];
                    int twoSideMinHeight = Math.min(height[i], height[stack.peekLast()]);
                    int weight = i - stack.peekLast() - 1;
                    sum += (twoSideMinHeight - bottomHeight) * weight;
                }
            }
            stack.addLast(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{4, 3, 1, 1, 3, 4}));
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new Solution().trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}

