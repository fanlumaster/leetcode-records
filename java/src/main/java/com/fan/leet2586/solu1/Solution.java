package com.fan.leet2586.solu1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  public int vowelStrings(String[] words, int left, int right) {
    int ans = 0;
    List<Character> vowelList = Arrays.asList('a', 'e', 'i', 'o', 'u');
    Set<Character> vowelSet = new HashSet<>(vowelList);
    for (int i = left; i <= right; i++) {
      char firstChar = words[i].charAt(0);
      char lastChar = words[i].charAt(words[i].length() - 1);
      if (vowelSet.contains(firstChar) && vowelSet.contains(lastChar)) {
        ans += 1;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    // Test 1
    String[] words = new String[] { "are", "amy", "u" };
    int left = 0;
    int right = 2;
    Solution solu = new Solution();
    int ans = solu.vowelStrings(words, left, right);
    System.out.println(ans);

    // Test 2
    words = new String[] { "hey", "aeo", "mu", "ooo", "artro" };
    left = 1;
    right = 4;
    ans = solu.vowelStrings(words, left, right);
    System.out.println(ans);
  }
}
