package com.fan.leet1049;

/**
 * classic dp, 01 pack problem
 */
public class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int half = sum / 2;
        int N = stones.length;
        int W = half;
        int[][] dp = new int[N + 1][W + 1];
        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= W; w++) {
                if (w - stones[n - 1] < 0) {
                    dp[n][w] = dp[n - 1][w];
                } else {
                    dp[n][w] = Math.max(dp[n - 1][w], dp[n - 1][w - stones[n - 1]] + stones[n - 1]);
                }
            }
        }
        int res = sum - 2 * dp[N][W];
        return res;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        var res = solu.lastStoneWeightII(stones);
        System.out.println(res);
    }
}
