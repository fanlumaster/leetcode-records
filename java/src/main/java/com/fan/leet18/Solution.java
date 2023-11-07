package com.fan.leet18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        long longTarget = target;

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int m = j + 1, n = nums.length - 1;
                long curTarget = longTarget - nums[i] - nums[j];
                while (m < n) {
                    if (m > j + 1 && nums[m] == nums[m - 1]) {
                        m++;
                        continue;
                    }
                    if (nums[m] + nums[n] < curTarget) {
                        m++;
                    } else if (nums[m] + nums[n] > curTarget) {
                        n--;
                    } else {
                        List<Integer> curRes = Arrays.asList(nums[i], nums[j], nums[m], nums[n]);
                        res.add(curRes);
                        m++;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        nums = new int[]{2, 2, 2, 2, 2};
        target = 8;
        nums = new int[]{-1000000000, -1000000000, 1000000000, -1000000000, -1000000000};
        target = 294967296;
        var res = solu.fourSum(nums, target);
        System.out.println(res);
    }
}
