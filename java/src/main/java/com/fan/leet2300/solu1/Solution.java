package com.fan.leet2300.solu1;

import java.util.Arrays;

public class Solution {

  /**
   * 二分查找
   * 查找最左边的第一个大于 needle 的数
   * 返回其位置
   */
  private int findFirstPotion(int[] potions, long needle) {
    int res = potions.length;
    int left = 0;
    int right = potions.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (potions[mid] > needle) {
        res = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return res;
  }

  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    int[] pairs = new int[spells.length];
    Arrays.sort(potions);
    for (int i = 0; i < spells.length; i++) {
      long needle = (success + spells[i] - 1) / spells[i] - 1;
      int cur = findFirstPotion(potions, needle);
      if (potions.length != cur) {
        pairs[i] = potions.length - cur;
      }
    }

    return pairs;
  }

  public static void main(String[] args) {

    /*
     * 示例 1：
     * 输入：spells = [5,1,3], potions = [1,2,3,4,5], success = 7
     * 输出：[4,0,3]
     * 解释：
     * - 第 0 个咒语：5 * [1,2,3,4,5] = [5,10,15,20,25] 。总共 4 个成功组合。
     * - 第 1 个咒语：1 * [1,2,3,4,5] = [1,2,3,4,5] 。总共 0 个成功组合。
     * - 第 2 个咒语：3 * [1,2,3,4,5] = [3,6,9,12,15] 。总共 3 个成功组合。
     * 所以返回 [4,0,3] 。
     *
     * 示例 2：
     * 输入：spells = [3,1,2], potions = [8,5,8], success = 16
     * 输出：[2,0,2]
     * 解释：
     * - 第 0 个咒语：3 * [8,5,8] = [24,15,24] 。总共 2 个成功组合。
     * - 第 1 个咒语：1 * [8,5,8] = [8,5,8] 。总共 0 个成功组合。
     * - 第 2 个咒语：2 * [8,5,8] = [16,10,16] 。总共 2 个成功组合。
     * 所以返回 [2,0,2] 。
     */
    Solution solu = new Solution();
    int[] spells = new int[] { 5, 1, 3 };
    int[] portions = new int[] { 1, 2, 3, 4, 5 };
    long success = 7;
    int[] pairs = solu.successfulPairs(spells, portions, success);
    System.out.println(Arrays.toString(pairs));

    spells = new int[] {3,1,2};
    portions = new int[] {8,5,8};
    success = 16;
    pairs = solu.successfulPairs(spells, portions, success);
    System.out.println(Arrays.toString(pairs));
  }
}
