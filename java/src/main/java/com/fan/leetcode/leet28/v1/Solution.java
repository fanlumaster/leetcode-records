package com.fan.leetcode.leet28.v1;

public class Solution {
    public int strStr(String haystack, String needle) {
        int[] next = generateNext(needle);
        int j = 0;
        int i = 0;
        while (i < haystack.length()) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = next[j - 1];
            }
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }
            if (j == needle.length()) {
                return (i - j + 1);
            }
            i++;
        }

        return -1;
    }

    public int[] generateNext(String s) {
        int j = 0;
        int[] next = new int[s.length()];
        next[0] = j;
        int i = 1;
        while (i < s.length()) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
            i++;
        }

        return next;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        String haystack = "aabaabaafa";
        String needle = "aabaaf";
        int res = solu.strStr(haystack, needle);
        System.out.println(res);
    }
}
