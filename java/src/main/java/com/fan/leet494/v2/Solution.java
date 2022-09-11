package com.fan.leet494.v2;

/**
 * dp
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // (sum - neg) - neg = target
        if ((sum - target) % 2 == 1 || sum < target) { // here, fuck the test cases
            return 0;
        }
        int neg = (sum - target) / 2;
        int N = nums.length;
        int W = neg;
        int[][] dp = new int[N + 1][W + 1];
        dp[0][0] = 1; // here need to notice
        for (int n = 1; n <= N; n++) {
            for (int w = 0; w <= W; w++) {
                if (nums[n - 1] > w) {
                    dp[n][w] = dp[n - 1][w];
                } else {
                    dp[n][w] = dp[n - 1][w] + dp[n - 1][w - nums[n - 1]];
                }
            }
        }

        return dp[N][W];
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int[] nums = new int[] { 1, 1, 1, 1, 1 };
        int target = 3;
        var res = solu.findTargetSumWays(nums, target);
        System.out.println(res);
    }
}