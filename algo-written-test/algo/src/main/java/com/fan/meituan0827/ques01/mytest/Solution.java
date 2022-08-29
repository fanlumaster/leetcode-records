package com.fan.meituan0827.ques01.mytest;

public class Solution {

    private int getAllCount(String S, String s, int n, int m) {
        int res = 0;

        for (int i = 0; i <= n - m; i++) {
            res += isEqual(s, S.substring(i, i + m));
        }

        return res;
    }

    private int isEqual(String str1, String str2) {
        int n = str1.length();
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) != '*' && str1.charAt(i) != str2.charAt(i)) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int n = 7;
        int m = 3;
        String S = "abcaacc";
        String s = "a*c";
        var res = solu.getAllCount(S, s, n, m);
        System.out.println(res);
    }

}
