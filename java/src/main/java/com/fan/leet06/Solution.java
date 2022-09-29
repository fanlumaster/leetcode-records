package com.fan.leet06;

import java.util.Arrays;

public class Solution {
    public String convert(String s, int numRows) {
        int T = numRows + (numRows - 2);
        int TNums = s.length() / T + 1;
        char[][] trans = new char[numRows][TNums * (numRows - 2 + 1)];
        StringBuilder res = new StringBuilder("");

        int index = 0;
        int row = 0;
        int col = 0;
        for (int i = 0; i < TNums; i++) {
            if (index >= s.length()) {
                break;
            }
            for (int j = 0; j < numRows; j++) {
                if (index >= s.length()) {
                    break;
                }
                trans[row][col] = s.charAt(index);
                index++;
                row += 1;
            }
            if (index >= s.length()) {
                break;
            }
            row -= 2;
            col += 1;
            for (int j = 0; j < numRows - 2; j++) {
                if (index >= s.length()) {
                    break;
                }
                trans[row][col] = s.charAt(index);
                index++;
                row -= 1;
                col += 1;
            }
        }
        for (int i = 0; i < trans.length; i++) {
            for (int j = 0; j < trans[i].length; j++) {
                if (trans[i][j] != '\u0000') {
                    res.append(trans[i][j]);
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        var solu = new Solution();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        s = "PAYPALISHIRING";
        numRows = 4;
        var res = solu.convert(s, numRows);
        System.out.println(res);
    }
}
