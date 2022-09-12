package com.fan.leet377;

/**
 * dp, complete backpack?
 * no need though, just climb the stairs
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n = 0; n < nums.length; n++) {
                if (nums[n] <= i) {
                    dp[i] += dp[i - nums[n]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int[] nums = new int[]{1, 2, 3};
        int target = 4;
        var res = solu.combinationSum4(nums, target);
        System.out.println(res);
    }
}
