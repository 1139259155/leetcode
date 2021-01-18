package com.pengbo.mydemo.leetcode.剑指Offer56_I数组中数字出现的次数;

import java.util.Arrays;

public class Solution {
    public int[] singleNumbers(int[] nums) {
        int begin = 0, end = nums.length - 1;
        int temp;
        while (begin < end) {
            while (begin < end && nums[begin] < nums[end]) {
                begin++;
            }
            while (begin < end && nums[end] > nums[begin]) {
                end--;
            }
            temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;

        }

        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 10, 4, 1, 4, 3, 3};
        System.out.println(Arrays.toString(solution.singleNumbers(nums)));
    }
}
