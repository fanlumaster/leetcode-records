package com.fan.leet829.v1;

/**
 * O(sqrt(2n)), a little bit slow
 */
public class Solution {
    public int consecutiveNumbersSum(int n) {
        int count = 0;

        int bound = (int) Math.sqrt(2 * n);
        bound = Math.min(n, bound);
        for (int i = 1; i <= bound; i++) {
            double temp = 2.0 * n / i - i;
            if (temp % 2 == 1) {
                count += 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int n = 5895313;
        int res = solu.consecutiveNumbersSum(n);
        System.out.println(res);
    }
}
