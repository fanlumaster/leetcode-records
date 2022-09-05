package com.fan.leet96;

/**
 * dp, simple
 */
public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int n = 3;
        var res = solu.numTrees(n);
        System.out.println(res);
    }
}
