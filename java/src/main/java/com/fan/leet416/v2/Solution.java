package com.fan.leet416.v2;

public class Solution {
    public boolean canPartition(int[] nums) {
        int numsSum = 0;
        for (int i = 0; i < nums.length; i++) {
            numsSum += nums[i];
        }
        if (numsSum % 2 == 1) {
            return false;
        }
        int halfNumsSum = numsSum / 2;
        int[][] dp = new int[nums.length + 1][halfNumsSum + 1];
        for (int n = 1; n <= nums.length; n++) {
            for (int w = 1; w <= halfNumsSum; w++) {
                if (w - nums[n - 1] < 0) {
                    dp[n][w] = dp[n - 1][w];
                } else {
                    dp[n][w] = Math.max(dp[n - 1][w - nums[n - 1]] + nums[n - 1], dp[n - 1][w]);
                }
            }
        }

        return dp[nums.length][halfNumsSum] == halfNumsSum;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int[] nums = new int[]{1, 5, 11, 5};
        nums = new int[]{1, 2, 3, 5};
        var res = solu.canPartition(nums);
        System.out.println(res);
    }
}
