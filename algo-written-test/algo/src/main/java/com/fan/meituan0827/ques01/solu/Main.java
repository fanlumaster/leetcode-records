package com.fan.meituan0827.ques01.solu;

import java.util.Scanner;

public class Main {

    private int getAllCount(String S, String s, int n, int m) {
        int res = 0;

        for (int i = 0; i <= n - m; i++) {
            res += isEqual(s, S.substring(i, i + m));
        }

        return res;
    }

    private int isEqual(String str1, String str2) {
        int n = str1.length();
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) != '*' && str1.charAt(i) != str2.charAt(i)) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String S = sc.next();
            String s = sc.next();

            int res = main.getAllCount(S, s, n, m);
            System.out.println(res);
        }
    }

}
