package com.fan.leet13;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> myMap = new HashMap<>() {{
            put("I", 1);
            put("II", 2);
            put("III", 3);
            put("IV", 4);
            put("V", 5);
            put("VI", 6);
            put("VII", 7);
            put("VIII", 8);
            put("IX", 9);
            put("X", 10);
            put("XX", 20);
            put("XXX", 30);
            put("XL", 40);
            put("L", 50);
            put("LX", 60);
            put("LXX", 70);
            put("LXXX", 80);
            put("XC", 90);
            put("C", 100);
            put("CC", 200);
            put("CCC", 300);
            put("CD", 400);
            put("D", 500);
            put("DC", 600);
            put("DCC", 700);
            put("DCCC", 800);
            put("CM", 900);
            put("M", 1000);
            put("MM", 2000);
            put("MMM", 3000);
        }};

        if (myMap.containsKey(s)) {
            return myMap.get(s);
        }

        int res = 0;
        int usedChars = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (myMap.get(s.substring(i, i + 1)) < myMap.get(s.substring(i + 1, i + 2))) {
                res += myMap.get(s.substring(i, i + 2));
                i += 1;
                usedChars += 2;
            } else {
                res += myMap.get(s.substring(i, i + 1));
                usedChars += 1;
            }
        }
        if (usedChars < s.length()) {
            res += myMap.get(s.substring(s.length() - 1));
        }

        return res;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        String s = "III";
        s = "IV";
        s = "IX";
        s = "LVIII";
        s = "MCMXCIV";
        int res = solu.romanToInt(s);
        System.out.println(res);
    }
}
