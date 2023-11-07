package com.fan.leet1832.v1;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public boolean checkIfPangram(String sentence) {
    Set<Character> mySet = new HashSet<>();
    for (int i = 0; i < sentence.length(); i++) {
      if (sentence.charAt(i) >= 'a' && sentence.charAt(i) <= 'z') {
        mySet.add(sentence.charAt(i));
        if (mySet.size() == 26) {
          return true;
        }
      } else {
        return false;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    var solu = new Solution();
    String sentence = "thequickbrownfoxjumpsoverthelazydog";
    sentence = "leetcode";
    var res = solu.checkIfPangram(sentence);
    System.out.println(res);
  }
}
