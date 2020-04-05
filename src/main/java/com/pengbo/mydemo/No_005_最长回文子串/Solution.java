package com.pengbo.mydemo.No_005_最长回文子串;

import org.apache.commons.lang3.Streams;

import java.util.stream.Stream;

public class Solution {

    /**
     * dynamic plan
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int length = 0;
        if (s == null || (length = s.length()) == 1)
            return s;


        // use status array and init
        int[][] status = new int[length][length];
        for (int i = 0; i < length; i++) {
            status[i][i] = 1;
        }

        // fill status
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {

            }
        }


        return "";
    }

    /**
     * longest common substring
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        return "";
    }

    public String longestPalindrome2(String s) {
        return "";
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("123"));
        System.out.println(solution.longestPalindrome1("123"));
        System.out.println(solution.longestPalindrome2("123"));

    }
}

