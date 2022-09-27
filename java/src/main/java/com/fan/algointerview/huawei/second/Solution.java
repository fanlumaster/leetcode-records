package com.fan.algointerview.huawei.second;

// huawei second interview algo problem
// 某地突发火灾，消防车需要从起点 S 尽快赶到事故点 E，请你找出最短距离
// 用二维矩阵 fireMap 来存储路况信息；矩阵行列 [row,col] 标识某一路段，fireMap[row][col] 的值表示该段路况：0 表示通畅，1 代表拥堵（拥堵路段不可通行），
// 相邻路段距离为 1；起点 S 使用矩阵行列 [startRow,startCol] 表示，事故点使用矩阵行列 [endRow,endCol] 表示；
// 消防车只可能往上、往下、往左、往右行驶；
// 如果无法到达，请返回 -1。
//
// 示例 1：
// 输入：fireMap = [[0,0,1,0],[1,0, 0,0]], startRow = 0, startCol = 0, endRow = 0, endCol = 3
// 输出：5
public class Solution {
    private final int myMaxValue = 1000000;

    public int findMinPath(int[][] fireMap, int[] S, int[] E) {
        int[][] pathSet = new int[fireMap.length + 10][fireMap[0].length + 10];
        int res = recursion(fireMap, S[0], S[1], E, pathSet);
        return res;
    }

    private int recursion(int[][] fireMap, int startX, int startY, int[] E, int[][] pathSet) {
        if (startX < 0 || startX > fireMap.length - 1 || startY < 0 || startY > fireMap[0].length - 1) {
            return myMaxValue;
        }
        if (fireMap[startX][startY] != 0) {
            return myMaxValue;
        }
        if (startX == E[0] && startY == E[1]) {
            return 0;
        }

        // left
        int leftValue = myMaxValue;
        if (checkValid(fireMap, startX - 1, startY) && pathSet[startX - 1][startY] == 0) {
            pathSet[startX - 1][startY] = 1;
            leftValue = recursion(fireMap, startX - 1, startY, E, pathSet) + 1;
            pathSet[startX - 1][startY] = 0;
        }
        // right
        int rightValue = myMaxValue;
        if (checkValid(fireMap, startX + 1, startY) && pathSet[startX + 1][startY] == 0) {
            pathSet[startX + 1][startY] = 1;
            rightValue = recursion(fireMap, startX + 1, startY, E, pathSet) + 1;
            pathSet[startX + 1][startY] = 0;
        }
        // up
        int upValue = myMaxValue;
        if (checkValid(fireMap, startX, startY - 1) && pathSet[startX][startY - 1] == 0) {
            pathSet[startX][startY - 1] = 1;
            upValue = recursion(fireMap, startX, startY - 1, E, pathSet) + 1;
            pathSet[startX][startY - 1] = 0;
        }
        // down
        int downValue = myMaxValue;
        if (checkValid(fireMap, startX, startY + 1) && pathSet[startX][startY + 1] == 0) {
            pathSet[startX][startY + 1] = 1;
            downValue = recursion(fireMap, startX, startY + 1, E, pathSet) + 1;
            pathSet[startX][startY + 1] = 0;
        }

        int resX = Math.min(leftValue, rightValue);
        int resY = Math.min(upValue, downValue);
        int res = Math.min(resX, resY);
        return res;
    }

    private boolean checkValid(int[][] fireMap, int startX, int startY) {
        return startX >= 0 && startX <= fireMap.length - 1 && startY >= 0 && startY <= fireMap[0].length - 1;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int[][] fireMap = new int[][] { { 0, 0, 1, 0 }, { 1, 0, 0, 0 } };
        int[] S = new int[] { 0, 0 };
        int[] E = new int[] { 0, 3 };
        var res = solu.findMinPath(fireMap, S, E);
        System.out.println(res);
    }
}
