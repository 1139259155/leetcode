package com.pengbo.mydemo.leetcode.No_496_下一个更大元素I;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/next-greater-element-i/
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 == 0) return new int[0];
        if (len1 == 1) return new int[]{-1};

        int[] newNum2 = new int[len2 + 2];
        for (int i = 0; i < len2; i++) {
            newNum2[i + 1] = nums2[i];
        }
        newNum2[0] = Integer.MAX_VALUE;
        newNum2[len2 + 1] = Integer.MAX_VALUE;

        // 单调递减栈
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(newNum2[0]);

        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 1; i < newNum2.length; i++) {
            while (newNum2[i] > stack.peekLast()) {
                resultMap.put(stack.pollLast(), newNum2[i]);
            }
            stack.addLast(newNum2[i]);
        }

        int[] result = new int[len1];
        for (int i = 0; i < len1; i++) {
            result[i] = resultMap.get(nums1[i]) == Integer.MAX_VALUE ? -1 : resultMap.get(nums1[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));
    }
}

