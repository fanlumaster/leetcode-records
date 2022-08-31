package com.fan.meituan0827.ques03.solu;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private int count = 0;

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
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String S = sc.next();
            int[] x = new int[m];
            for (int i = 0; i < m; i++) {
                x[i] = sc.nextInt();
            }
            String[] s = new String[m];
            for (int i = 0; i < m; i++) {
                s[i] = sc.next();
            }

            Main solu = new Main();
            int res = solu.getRes(n, m, S, x, s);
            System.out.println(res);
        }
    }

}
