package com.fan.leet62.v2;

/**
 * dp will be so fast
 * for this problem, it is quite simple to apply dp
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int m = 3;
        int n = 7;
//        m = 2;
//        n = 3;
//        m = 7;
//        n = 3;
//        m = 3;
//        n = 3;
        var res = solu.uniquePaths(m, n);
        System.out.println(res);
    }
}
