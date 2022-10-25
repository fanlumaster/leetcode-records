package com.fan.leet16;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
//                int diff = Math.abs(res - target);
                while (nums[i] + nums[j] + nums[k] > target && k > j) {
                    k--;
                }
                if (k == j) {
                    if (Math.abs(nums[i] + nums[j] + nums[k + 1] - target) < Math.abs(res - target)) {
                        res = nums[i] + nums[j] + nums[k + 1];
                    }
                    break;
                } else {
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < Math.abs(res - target)) {
                        res = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
        nums = new int[]{0, 0, 0};
        target = 1;
        nums = new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5};
        target = -2;
        int res = solu.threeSumClosest(nums, target);
        System.out.println(res);
    }
}
