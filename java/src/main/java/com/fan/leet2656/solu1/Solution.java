package com.fan.leet2656.solu1;

public class Solution {
  public int maximizeSum(int[] nums, int k) {
    int maxVal = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > maxVal) {
        maxVal = nums[i];
      }
    }

    return maxVal * k + k * (k - 1) / 2;
  }

  public static void main(String[] args) {
    /*
     * 示例 1：
     * 输入：nums = [1,2,3,4,5], k = 3
     * 输出：18
     * 解释：我们需要从 nums 中恰好选择 3 个元素并最大化得分。
     * 第一次选择 5 。和为 5 ，nums = [1,2,3,4,6] 。
     * 第二次选择 6 。和为 6 ，nums = [1,2,3,4,7] 。
     * 第三次选择 7 。和为 5 + 6 + 7 = 18 ，nums = [1,2,3,4,8] 。
     * 所以我们返回 18 。
     * 18 是可以得到的最大答案。
     *
     * 示例 2：
     * 输入：nums = [5,5,5], k = 2
     * 输出：11
     * 解释：我们需要从 nums 中恰好选择 2 个元素并最大化得分。
     * 第一次选择 5 。和为 5 ，nums = [5,5,6] 。
     * 第二次选择 6 。和为 6 ，nums = [5,5,7] 。
     * 所以我们返回 11 。
     * 11 是可以得到的最大答案。
     */
    var solu = new Solution();
    int[] nums = new int[] { 1, 2, 3, 4, 5 };
    int k = 3;
    int ans = solu.maximizeSum(nums, k);
    System.out.println(ans);

    nums = new int[] { 5, 5, 5 };
    k = 2;
    ans = solu.maximizeSum(nums, k);
    System.out.println(ans);
  }
}
