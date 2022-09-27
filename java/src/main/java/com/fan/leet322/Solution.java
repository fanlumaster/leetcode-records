package com.fan.leet322;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return 1000000; // notice here
        }
        if (amount == 0) {
            return 0;
        }
        int res = amount + 1;
        for (int i = 0; i < coins.length; i++) {
            res = Math.min(coinChange(coins, amount - coins[i]) + 1, res);
        }
        return res;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        var res = solu.coinChange(coins, amount);
        System.out.println(res);
    }
}
