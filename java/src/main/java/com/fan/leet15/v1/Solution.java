package com.fan.leet15.v1;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int curTrial = -nums[i] - nums[j];
                if (map.containsKey(curTrial) && map.get(curTrial) > j) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[map.get(curTrial)]));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        nums = new int[]{0, 1, 1};
        nums = new int[]{0, 0, 0};
        nums = new int[]{0, 0, 0, 0};
        var res = solu.threeSum(nums);
        System.out.println(res);
    }
}
