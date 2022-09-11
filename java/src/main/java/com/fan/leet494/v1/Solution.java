package com.fan.leet494.v1;

/**
 * recursion, not content with the time limit
 */
public class Solution {
    private int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        int start = 0;
        int curSum = 0;
        backtrace(nums, target, start, curSum);

        return this.count;
    }

    private void backtrace(int[] nums, int target, int start, int curSum) {
        if (start >= nums.length) {
            if (curSum == target) {
                this.count += 1;
            }
            return;
        }
        backtrace(nums, target, start + 1, curSum + nums[start]);
        backtrace(nums, target, start + 1, curSum - nums[start]);
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        var res = solu.findTargetSumWays(nums, target);
        System.out.println(res);
    }
}
