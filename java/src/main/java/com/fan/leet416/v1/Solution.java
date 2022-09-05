package com.fan.leet416.v1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * hard recursion, will take much time, not suitable
 */
public class Solution {
    private boolean flag = false;

    public boolean canPartition(int[] nums) {
        int numsSum = 0;
        for (int i = 0; i < nums.length; i++) {
            numsSum += nums[i];
        }
        if (numsSum % 2 == 1) {
            return false;
        }
        int target = numsSum / 2;
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int index = 0;
        int curSum = 0;
        recursion(numsList, index, curSum, target);
        return this.flag;
    }

    private void recursion(List<Integer> numsList, int index, int curSum, int target) {
        if (curSum == target) {
            this.flag = true;
        }
        if (index >= numsList.size()) {
            return;
        }
        int oneCurSum = curSum + numsList.get(index);
        int zeroCurSum = curSum;
        index += 1;
        recursion(numsList, index, oneCurSum, target);
        recursion(numsList, index, zeroCurSum, target);
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int[] nums = new int[]{1, 5, 11, 5};
        nums = new int[]{1, 2, 3, 5};
        var res = solu.canPartition(nums);
        System.out.println(res);
    }
}
