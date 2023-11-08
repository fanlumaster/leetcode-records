package com.fan.leet318.solu1;

public class Solution {
  public int maxProduct(String[] words) {
    int wordsLen = words.length;
    int[] masks = new int[wordsLen];
    for (int i = 0; i < wordsLen; i++) {
      String curWord = words[i];
      for (int j = 0; j < curWord.length(); j++) {
        masks[i] = masks[i] | (1 << (curWord.charAt(j) - 'a'));
      }
    }
    int ans = 0;
    for (int i = 0; i < wordsLen; i++) {
      for (int j = i + 1; j < wordsLen; j++) {
        if ((masks[i] & masks[j]) == 0) {
          if (words[i].length() * words[j].length() > ans) {
            ans = words[i].length() * words[j].length();
          }
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    /*
     * 示例 1：
     *
     * 输入：words = ["abcw","baz","foo","bar","xtfn","abcdef"]
     * 输出：16
     * 解释：这两个单词为 "abcw", "xtfn"。
     *
     * 示例 2：
     *
     * 输入：words = ["a","ab","abc","d","cd","bcd","abcd"]
     * 输出：4
     * 解释：这两个单词为 "ab", "cd"。
     * 示例 3：
     *
     * 输入：words = ["a","aa","aaa","aaaa"]
     * 输出：0
     * 解释：不存在这样的两个单词。
     */
    // Test1
    Solution solu = new Solution();
    String[] words = new String[] { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
    int ans = solu.maxProduct(words);
    System.out.println(ans);

    // Test2
    words = new String[] { "a", "ab", "abc", "d", "cd", "bcd", "abcd" };
    ans = solu.maxProduct(words);
    System.out.println(ans);

    // Test2
    words = new String[] { "a", "aa", "aaa", "aaaa" };
    ans = solu.maxProduct(words);
    System.out.println(ans);
  }
}
