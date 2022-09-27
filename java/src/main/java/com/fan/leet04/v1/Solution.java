package com.fan.leet04.v1;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if ((m + n) % 2 == 1) {
            int k = (m + n + 1) / 2;
            return findKthSortedArrays(nums1, nums2, k);
        } else {
            int k = (m + n) / 2;
            return (findKthSortedArrays(nums1, nums2, k) + findKthSortedArrays(nums1, nums2, k + 1)) / 2.0;
        }
    }

    private int findKthSortedArrays(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int index1 = 0;
        int index2 = 0;

        while (true) {
            // edge situation
            if (index1 == m) {
                return nums2[index2 + k - 1];
            }
            if (index2 == n) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // normal situation
            int newIndex1 = Math.min(index1 + k / 2 - 1, m - 1);
            int newIndex2 = Math.min(index2 + k / 2 - 1, n - 1);
            if (nums1[newIndex1] < nums2[newIndex2]) {
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else if (nums1[newIndex1] > nums2[newIndex2]) {
                k = k - (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            } else {
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }
        }
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};

        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        var res = solu.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
