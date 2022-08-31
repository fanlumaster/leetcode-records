package com.fan.leet509;

public class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int n = 3;
        var res = solu.fib(n);
        System.out.println(res);
        System.out.println();
        for (int i = 0; i < 20; i++) {
            System.out.print(solu.fib(i));
            System.out.print(", ");
        }
        System.out.println();
    }
}
