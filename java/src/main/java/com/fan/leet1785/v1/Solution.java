package com.fan.leet1785.v1;

/*
 * This method just use long data type to avoid overflow problem, not the optimized solution.
 */
public class Solution {
  public int minElements(int[] nums, int limit, int goal) {
    long prevSum = 0;
    for (int i = 0; i < nums.length; i++) {
      prevSum += nums[i];
    }
    long newGoal = Math.abs(goal - prevSum);

    if (newGoal % limit == 0) {
      return (int) (newGoal / limit);
    }

    return (int) (newGoal / limit + 1);
  }

  public static void main(String[] args) {
    var solu = new Solution();
    int[] nums = new int[] { 1, -1, 1 };
    int limit = 3;
    int goal = -4;

    nums = new int[] { 1, -10, 9, 1 };
    limit = 100;
    goal = 0;

    nums = new int[83328];
    for (int i = 0; i < 83328; i++) {
      nums[i] = 1000000;
    }
    limit = 1000000;
    goal = -1000000000;

    var res = solu.minElements(nums, limit, goal);
    System.out.println(res);
  }
}
