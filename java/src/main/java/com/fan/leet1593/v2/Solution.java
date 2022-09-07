package com.fan.leet1593.v2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> res = new ArrayList<>();

    public int maxUniqueSplit(String s) {
        List<String> res = new ArrayList<>();
        int start = 0;
        backtrace(s, res, start);
        System.out.println(this.res);
        return this.res.size();
    }

    private void backtrace(String s, List<String> curRes, int start) {
        int n = s.length();
        if (start >= n) {
            if (curRes.size() > this.res.size()) {
                this.res = new ArrayList<>(curRes);
            }
            return;
        }
        for (int i = start; i < n; i++) {
            String curStr = s.substring(start, i + 1);
            if (!curRes.contains(curStr)) {
                curRes.add(curStr);
                backtrace(s, curRes, i + 1);
                curRes.remove(curStr);
            }
        }
    }

    public static void main(String[] args) {
        var solu = new Solution();
        String s = "wwwzfvedwfvhsww";
        var res = solu.maxUniqueSplit(s);
        System.out.println(res);
    }
}
