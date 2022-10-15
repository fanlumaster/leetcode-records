package com.fan.leet12.v1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> myMap = new HashMap<>() {{
            put(1, "I");
            put(2, "II");
            put(3, "III");
            put(4, "IV");
            put(5, "V");
            put(6, "VI");
            put(7, "VII");
            put(8, "VIII");
            put(9, "IX");
            put(10, "X");
            put(20, "XX");
            put(30, "XXX");
            put(40, "XL");
            put(50, "L");
            put(60, "LX");
            put(70, "LXX");
            put(80, "LXXX");
            put(90, "XC");
            put(100, "C");
            put(200, "CC");
            put(300, "CCC");
            put(400, "CD");
            put(500, "D");
            put(600, "DC");
            put(700, "DCC");
            put(800, "DCCC");
            put(900, "CM");
            put(1000, "M");
            put(2000, "MM");
            put(3000, "MMM");
        }};

        if (myMap.containsKey(num)) {
            return myMap.get(num);
        }

        StringBuilder sb = new StringBuilder();
        int times = 1;
        while (num != 0) {
            int mod = num % 10;
            if (mod != 0) {
                sb.insert(0, myMap.get(mod * times));
            }
            num /= 10;
            times *= 10;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int num = 3;
        num = 4;
        num = 58;
        num = 1994;
        String res = solu.intToRoman(num);
        System.out.println(res);
    }
}
