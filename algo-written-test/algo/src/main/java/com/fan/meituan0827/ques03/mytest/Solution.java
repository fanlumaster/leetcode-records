package com.fan.meituan0827.ques03.mytest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    private int count = 0;

    /**
     * 直接用 dfs
     *
     * @param n
     * @param m
     * @param S
     * @param x
     * @param s String array, the length of s[i] is x[i]
     * @return
     */
    public int getRes(int n, int m, String S, int[] x, String[] s) {
        List<String> sList = Arrays.stream(s).collect(Collectors.toList());
        dfs(S, sList);

        return this.count;
    }

    private void dfs(String S, List<String> sList) {
        if (S.length() == 0) {
            this.count++;
        }
        for (int i = 0; i < sList.size(); i++) {
            if (S.startsWith(sList.get(i))) {
                String cur = sList.get(i);
                sList.remove(i);
                dfs(S.substring(cur.length()), sList);
                sList.add(i, cur);
            }
        }
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int n = 6;
        int m = 2;
        String S = "aaaaaa";
        int[] x = new int[]{4, 2};
        String[] s = new String[]{"aaaa", "aa"};
        int res = solu.getRes(n, m, S, x, s);
        System.out.println(res);
    }

}
