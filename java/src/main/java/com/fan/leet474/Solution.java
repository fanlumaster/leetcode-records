package com.fan.leet474;

/**
 * 01 pack, dp problem, just has some changes
 * cannot influence much
 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int N = strs.length;
        int[][][] dp = new int[N + 1][m + 1][n + 1];

        for (int ni = 1; ni <= N; ni++) {
            int[] zerosOnes = getZerosAndOnes(strs[ni - 1]);
            int zeros = zerosOnes[0];
            int ones = zerosOnes[1];
            for (int mj = 0; mj <= m; mj++) { // notice here, from 0 to start
                for (int nj = 0; nj <= n; nj++) { // also here, from 0 to start
                    if (zeros > mj || ones > nj) {
                        dp[ni][mj][nj] = dp[ni - 1][mj][nj];
                    } else {
                        dp[ni][mj][nj] = Math.max(dp[ni - 1][mj][nj], dp[ni - 1][mj - zeros][nj - ones] + 1);
                    }
                }
            }
        }

        return dp[N][m][n];
    }

    private int[] getZerosAndOnes(String s) {
        int[] zerosOnes = new int[2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zerosOnes[0] += 1;
            } else {
                zerosOnes[1] += 1;
            }
        }
        return zerosOnes;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        String[] strs = new String[] { "10", "0001", "111001", "1", "0" };
        int m = 5;
        int n = 3;
        strs = new String[] { "10", "0", "1" };
        m = 1;
        n = 1;
        var res = solu.findMaxForm(strs, m, n);
        System.out.println(res);
    }
}
