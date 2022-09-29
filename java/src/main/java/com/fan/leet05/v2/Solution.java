package com.fan.leet05.v2;

public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String curSubString = s.substring(i, i + 1);
            int leftP = i - 1;
            int rightP = i + 1;
            while (leftP >= 0 && rightP <= s.length() - 1 && s.charAt(leftP) == s.charAt(rightP)) {
                curSubString = s.charAt(leftP) + curSubString + s.charAt(rightP);
                leftP -= 1;
                rightP += 1;
            }
            if (curSubString.length() > res.length()) {
                res = curSubString;
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                continue;
            }
            String curSubString = s.substring(i, i + 2);
            int leftP = i - 1;
            int rightP = i + 2;
            while (leftP >= 0 && rightP <= s.length() - 1 && s.charAt(leftP) == s.charAt(rightP)) {
                curSubString = s.charAt(leftP) + curSubString + s.charAt(rightP);
                leftP -= 1;
                rightP += 1;
            }
            if (curSubString.length() > res.length()) {
                res = curSubString;
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
