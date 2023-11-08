package com.fan.leet2609.solu1;

public class Solution {
  public int findTheLongestBalancedSubstring(String s) {
    int ans = 0;
    int sLen = s.length();
    int[] count = new int[2];
    for (int i = 0; i < sLen; i++) {
      if (s.charAt(i) == '1') {
        count[1] += 1;
        ans = Math.max(ans, 2 * Math.min(count[0], count[1]));
      } else if (i == 0 || s.charAt(i - 1) == '1') { // 如果 s[i] == '0'
        count[0] = 1;
        count[1] = 0;
      } else {
        count[0] += 1;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    /*
     * 示例 1：
     * 输入：s = "01000111"
     * 输出：6
     * 解释：最长的平衡子字符串是 "000111" ，长度为 6 。
     *
     * 示例 2：
     * 输入：s = "00111"
     * 输出：4
     * 解释：最长的平衡子字符串是 "0011" ，长度为 4 。
     *
     * 示例 3：
     * 输入：s = "111"
     * 输出：0
     * 解释：除了空子字符串之外不存在其他平衡子字符串，所以答案为 0 。
     */
    Solution solu = new Solution();
    String s = "01000111";
    int ans = solu.findTheLongestBalancedSubstring(s);
    System.out.println(ans);

    s = "00111";
    ans = solu.findTheLongestBalancedSubstring(s);
    System.out.println(ans);

    s = "111";
    ans = solu.findTheLongestBalancedSubstring(s);
    System.out.println(ans);
  }
}
