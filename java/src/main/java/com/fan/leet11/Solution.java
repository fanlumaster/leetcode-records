package com.fan.leet11;

public class Solution {
    public int maxArea(int[] height) {
        int leftP = 0;
        int rightP = height.length - 1;
        int res = (rightP - leftP) * Math.min(height[leftP], height[rightP]);

        while (leftP < rightP) {
            if (height[leftP] < height[rightP]) {
                leftP += 1;
                int tmp = (rightP - leftP) * Math.min(height[leftP], height[rightP]);
                if (tmp > res) {
                    res = tmp;
                }
            } else {
                rightP -= 1;
                int tmp = (rightP - leftP) * Math.min(height[leftP], height[rightP]);
                if (tmp > res) {
                    res = tmp;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
//        height = new int[]{1, 1};
//        height = new int[]{2, 3, 4, 5, 18, 17, 6};
        int res = solu.maxArea(height);
        System.out.println(res);
    }
}
