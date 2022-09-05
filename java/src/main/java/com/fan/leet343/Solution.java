package com.fan.leet343;

public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int n = 2;
        n = 10;
        var res = solu.integerBreak(n);
        System.out.println(res);
    }
}
