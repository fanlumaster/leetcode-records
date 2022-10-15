package com.fan.leet09;

public class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int i = 0;
        int j = s.length() - 1;
        while (i < s.length() / 2 + 1) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int x = 121;
        boolean res = solu.isPalindrome(x);
        System.out.println(res);
    }
}
