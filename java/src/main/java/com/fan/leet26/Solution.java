package com.fan.leet26;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int p1 = 0, p2 = 1;
        for (; p2 < nums.length; p2++) {
            if (nums[p2] != nums[p2 - 1]) {
                nums[++p1] = nums[p2];
            }
        }
        return p1 + 1;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int[] nums = new int[]{1, 1, 2};
        int res = solu.removeDuplicates(nums);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }
}
