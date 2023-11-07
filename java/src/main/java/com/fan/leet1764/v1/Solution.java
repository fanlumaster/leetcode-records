package com.fan.leet1764.v1;

import java.util.Arrays;

public class Solution {
  private int[] generateNext(int[] needle) {
    int[] next = new int[needle.length];
    next[0] = 0;
    int i = 1;
    int j = 0;
    while (i < needle.length) {
      while (j > 0 && needle[i] != needle[j]) {
        j = next[j - 1];
      }
      if (needle[i] == needle[j]) {
        j += 1;
      }
      next[i] = j;
      i += 1;
    }

    return next;
  }

  private int kmp(int[] haystack, int[] needle) {
    int[] next = generateNext(needle);
    int i = 0;
    int j = 0;
    while (i < haystack.length) {
      while (j > 0 && haystack[i] != needle[j]) {
        j = next[j - 1];
      }
      if (haystack[i] == needle[j]) {
        j += 1;
      }
      if (j == needle.length) {
        return i - j + 1;
      }
      i += 1;
    }

    return -1;
  }

  public boolean canChoose(int[][] groups, int[] nums) {
    for (int i = 0; i < groups.length; i++) {
      int[] curNeedle = groups[i];
      int curIndex = kmp(nums, curNeedle);
      if (curIndex == -1) {
        return false;
      }
      nums = Arrays.copyOfRange(nums, curIndex + curNeedle.length, nums.length);
    }

    return true;
  }

  public static void main(String[] args) {
    var solu = new Solution();
    int[][] groups = new int[][] { { 1, -1, -1 }, { 3, -2, 0 } };
    int[] nums = new int[] { 1, -1, 0, 1, -1, -1, 3, -2, 0 };
    var res = solu.canChoose(groups, nums);
    System.out.println(res);
  }
}
