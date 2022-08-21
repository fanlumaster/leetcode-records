package com.fan.leet104;

import java.util.Arrays;

import com.fan.utils.BinaryTreeUtils;
import com.fan.utils.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        int res = getDepth(root);
        return res;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getDepth(root.left) + 1;
        int rightDepth = getDepth(root.right) + 1;

        return Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        var solu = new Solution();
        var data = Arrays.asList(1, 2, 3, 4, null, 5, null, 6, 7, 8, 9, 10);
        var root = BinaryTreeUtils.buildBinTreeFromLevelOrder(data);
        BinaryTreeUtils.printBinTree(root);
        var res = solu.maxDepth(root);
        System.out.println(res);
    }
}
