package com.fan.leet17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private String[] numString = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.equals("")) {
            return res;
        }
        dfs(digits, "", res);
        return res;
    }

    private void dfs(String digits, String curStr, List<String> res) {
        if (digits.length() == 0) {
            res.add(curStr);
            return;
        }

        String curDigitStr = numString[digits.charAt(0) - '0'];
        String nextDigits = digits.substring(1);
        for (int i = 0; i < curDigitStr.length(); i++) {
            dfs(nextDigits, curStr + curDigitStr.charAt(i), res);
        }
    }

    public static void main(String[] args) {
        var solu = new Solution();
        String digits = "23";
        digits = "";
        digits = "2";
        var res = solu.letterCombinations(digits);
        System.out.println(res);
    }
}
