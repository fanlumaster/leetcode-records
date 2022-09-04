package com.fan.leet62.v1;

/**
 * 直接递归会超时
 */
public class Solution {
    private int count = 0;

    public int uniquePaths(int m, int n) {
        recurse(m, n, 0, 0);
        return this.count;
    }

    private void recurse(int m, int n, int r, int c) {
        if (r == m - 1 && c == n - 1) {
            this.count += 1;
            return;
        }
        if (r >= m || c >= n) {
            return;
        }
        recurse(m, n, r + 1, c);
        recurse(m, n, r, c + 1);
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int m = 3;
        int n = 7;
        m = 2;
        n = 3;
        m = 7;
        n = 3;
        m = 3;
        n = 3;
        var res = solu.uniquePaths(m, n);
        System.out.println(res);
    }
}
