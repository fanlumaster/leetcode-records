package com.fan.leet746;

public class Solution {
    private int minCost = Integer.MAX_VALUE;

    public int minCostClimbingStairs(int[] cost) {
        getMax(cost, 0, -1);
        int res = this.minCost;
        return res;
    }

    /**
     * 
     * @param cost
     * @param curRes
     * @param curIndex start from -1
     */
    private void getMax(int[] cost, int curRes, int curIndex) {
        if (curIndex >= cost.length) {
            if (curRes < this.minCost) {
                this.minCost = curRes;
            }
            return;
        }

        int curCost = 0;
        if (curIndex != -1) {
            curCost = cost[curIndex];
        }
        getMax(cost, curRes + curCost, curIndex + 1);
        getMax(cost, curRes + curCost, curIndex + 2);
    }

    public static void main(String[] args) {
        var solu = new Solution();
        var cost = new int[] { 10, 15, 20 };
        cost = new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        var res = solu.minCostClimbingStairs(cost);
        System.out.println(res);
    }
}
