package com.fan.leet15.v2;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (nums[i] + nums[j] + nums[k] > 0 && k > j) {
                    k--;
                }
                if (j == k) {
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        nums = new int[]{0, 1, 1};
//        nums = new int[]{0, 0, 0};
//        nums = new int[]{0, 0, 0, 0};
        var res = solu.threeSum(nums);
        System.out.println(res);
    }
}
