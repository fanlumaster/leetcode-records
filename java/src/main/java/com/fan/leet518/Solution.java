package com.fan.leet518;

/**
 * complete backpack
 */
public class Solution {
    public int change(int amount, int[] coins) {
        int N = coins.length;
        int[][] dp = new int[N + 1][amount + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }
        for (int n = 1; n <= N; n++) {
            for (int a = 1; a <= amount; a++) {
                if (coins[n - 1] > a) {
                    dp[n][a] = dp[n - 1][a];
                } else {
                    dp[n][a] = dp[n - 1][a] + dp[n][a - coins[n - 1]];
                }
            }
        }
        return dp[N][amount];
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int amount = 5;
        int[] coins = new int[]{1, 2, 5};
        var res = solu.change(amount, coins);
        System.out.println(res);
    }
}
