package com.fan.leet14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        int minStrLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minStrLen) {
                minStrLen = strs[i].length();
            }
        }

        for (int i = 0; i < minStrLen; i++) {
            char curChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != curChar) {
                    return sb.toString();
                }
            }
            sb.append(curChar);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        var solu = new Solution();
        String[] strs = new String[]{"flower", "flow", "flight"};
        strs = new String[]{"dog", "racecar", "car"};
        String res = solu.longestCommonPrefix(strs);
        System.out.println(res);
    }
}
