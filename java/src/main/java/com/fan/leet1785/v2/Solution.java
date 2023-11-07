package com.fan.leet1785.v2;

/**
 * This solution is WA. I won't try in recent times. Maybe it is not worth that.
 */
public class Solution {
  public int minElements(int[] nums, int limit, int goal) {
    int numsLimitCount = 0;
    int curNumsSum = 0;
    for (int i = 0; i < nums.length; i++) {
      curNumsSum += nums[i];
      if (curNumsSum / limit != 0) {
        numsLimitCount += curNumsSum / limit;
        curNumsSum = curNumsSum % limit;
      }
    }
    int newGoal = goal - curNumsSum;
    int newGoalLimit = (newGoal % limit == 0) ? (newGoal / limit) : (newGoal / limit + 1);

    if ((numsLimitCount > 0 && newGoalLimit > 0) || (numsLimitCount < 0 && newGoalLimit < 0)) {
      return Math.abs(numsLimitCount - newGoalLimit);
    }

    return Math.abs(numsLimitCount + newGoalLimit);
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
