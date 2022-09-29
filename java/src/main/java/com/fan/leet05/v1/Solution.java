package com.fan.leet05.v1;

public class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (dp[i][i + 1]) {
                res = s.substring(i, i + 2);
            }
        }

        for (int L = 3; L <= s.length(); L++) {
            for (int j = 0; j < s.length(); j++) {
                if (j + L > s.length()) { // notice here, edge condition
                    break;
                }

                dp[j][j + L - 1] = s.charAt(j) == s.charAt(j + L - 1) && dp[j + 1][j + L - 1 - 1];
                if (dp[j][j + L - 1] && L > res.length()) {
                    res = s.substring(j, j + L);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        String s = "babad";
        s = "cbbd";
        s = "ccc";
        var res = solu.longestPalindrome(s);
        System.out.println(res);
    }
}
