package com.fan.leet07;

public class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        x = Math.abs(x);
        String xStr = String.valueOf(x);
        String reversedXStr = new StringBuilder(xStr).reverse().toString();
        String res;
        if (isNegative) {
            res = "-" + reversedXStr;
            if (isLessThanMinInteger(res)) {
                res = "0";
            }
        } else {
            res = reversedXStr;
            if (isGreaterThanMaxInteger(res)) {
                res = "0";
            }
        }

        return Integer.parseInt(res);
    }

    private boolean isGreaterThanMaxInteger(String s) {
        String maxIntegerStr = String.valueOf(Integer.MAX_VALUE);
        if (s.length() < maxIntegerStr.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < maxIntegerStr.charAt(i)) {
                return false;
            } else if (s.charAt(i) > maxIntegerStr.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isLessThanMinInteger(String s) {
        String maxIntegerStr = String.valueOf(Integer.MIN_VALUE);
        if (s.length() < maxIntegerStr.length()) {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < maxIntegerStr.charAt(i)) {
                return false;
            } else if (s.charAt(i) > maxIntegerStr.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int x = 123;
        x = -2147483412;
        x = 1534236469;
        int res = solu.reverse(x);
        System.out.println(res);
    }
}
