package com.fan.leet08;

public class Solution {
    public int myAtoi(String s) {
        StringBuilder resSb = new StringBuilder();
        String s1 = "";
        boolean isPositive = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            s1 = s.substring(i);
            break;
        }
        if (s1.length() == 0) {
            return 0;
        }
        if (s1.charAt(0) == '-') {
            isPositive = false;
            s1 = s1.substring(1);
        } else if (s1.charAt(0) == '+') {
            s1 = s1.substring(1);
        }
        for (int i = 0; i < s1.length(); i++) {
            if (isDigit(s1.charAt(i))) {
                resSb.append(s1.charAt(i));
                continue;
            }
            break;
        }
        if (resSb.length() == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < resSb.length(); i++) {
            if (resSb.charAt(i) == '0' && res == 0) {
                continue;
            }
            if (res > Integer.MAX_VALUE / 10) {
                if (isPositive) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            if (res == Integer.MAX_VALUE / 10) {
                if (isPositive) {
                    if (resSb.charAt(i) >= '7') {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    if (resSb.charAt(i) >= '8') {
                        return Integer.MIN_VALUE;
                    }
                }
            }
            res *= 10;
            res += resSb.charAt(i) - '0';
        }

        return isPositive ? res : -res;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        var solu = new Solution();
        String s = "42";
        s = "    -42";
        s = "4193 with words";
        s = "+1";
        s = "010";
        s = "2147483646";
        int res = solu.myAtoi(s);
        System.out.println(res);
    }
}
