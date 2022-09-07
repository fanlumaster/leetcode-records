package com.fan.leet1593.v1;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private Set<String> res = new HashSet<>();

    public int maxUniqueSplit(String s) {
        Set<String> res = new HashSet<>();
        int start = 0;
        backtrace(s, res, start);
        System.out.println(this.res);
        return this.res.size();
    }

    private void backtrace(String s, Set<String> curRes, int start) {
        int n = s.length();
        if (start >= n) {
            if (curRes.size() > this.res.size()) {
                this.res = new HashSet<>(curRes);
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
