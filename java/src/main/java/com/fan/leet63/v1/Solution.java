package com.fan.leet63.v1;

/**
 * pure recursion
 */
public class Solution {
    private int count;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        recurse(obstacleGrid, 0, 0);
        return this.count;
    }

    private void recurse(int[][] obstacleGrid, int r, int c) {
        if (r == obstacleGrid.length - 1 && c == obstacleGrid[0].length) {
            this.count += 1;
            return;
        }
        if (r >= obstacleGrid.length || c >= obstacleGrid[0].length) {
            return;
        }
        if (obstacleGrid[r][c] == 1) {
            return;
        }
        recurse(obstacleGrid, r + 1, c);
        recurse(obstacleGrid, r, c + 1);
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int[][] obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        obstacleGrid = new int[][]{{0, 1}, {0, 0}};
        var res = solu.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(res);
    }
}
