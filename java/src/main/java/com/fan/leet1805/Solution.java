package com.fan.leet1805;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int numDifferentIntegers(String word) {
    Set<String> mySet = new HashSet<>();
    String cur = "";
    int i = 0;
    boolean flag = false;
    while (i < word.length()) {
      if (word.charAt(i) >= '0' && word.charAt(i) <= '9') {
        cur = "";
        while (i < word.length() && word.charAt(i) >= '0' && word.charAt(i) <= '9') {
          cur += word.charAt(i);
          i++;
        }

        int splitIndex = 0;
        while (cur.charAt(splitIndex) == '0' && splitIndex != cur.length() - 1) {
          splitIndex++;
        }
        cur = cur.substring(splitIndex);

        mySet.add(cur);
      }
      i++;
    }

    // System.out.println(mySet);
    int res = mySet.size();

    return res;
  }

  public static void main(String[] args) {
    var solu = new Solution();
    var word = "a123bc34d8ef34";
    word = "leet1234code234";
    word = "a1b01c001";
    word = "a1b01c001d000";
    // word = "167278959591294";
    var res = solu.numDifferentIntegers(word);
    System.out.println(res);
  }
}
