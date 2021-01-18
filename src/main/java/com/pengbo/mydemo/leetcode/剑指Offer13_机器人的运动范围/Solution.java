package com.pengbo.mydemo.leetcode.剑指Offer13_机器人的运动范围;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
0 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int movingCount(int m, int n, int k) {
        int[][] arrays = new int[m][n];

        return dfs(arrays, 0, 0, m, n, k);
    }

    private int dfs(int[][] visited, int i, int j, int m, int n, int k) {
        // if outOfBound or visited
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || visited[i][j] == 1) return 0;

        // if exceed k limit
        int sum = 0;
        String s = String.valueOf(i) + String.valueOf(j);
        for (char c : s.toCharArray()) sum += c - '0';
        if (sum > k) return 0;

        // dfs
        visited[i][j] = 1;
        return 1 + dfs(visited, i - 1, j, m, n, k)
                + dfs(visited, i + 1, j, m, n, k)
                + dfs(visited, i, j - 1, m, n, k)
                + dfs(visited, i, j + 1, m, n, k);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(2, 3, 1));
        System.out.println(solution.movingCount(3, 1, 0));
    }
}
