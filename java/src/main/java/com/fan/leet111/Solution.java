package com.fan.leet111;

import java.util.Arrays;

import com.fan.utils.BinaryTreeUtils;
import com.fan.utils.TreeNode;

public class Solution {
    public int minDepth(TreeNode root) {
        int res = getDepth(root);
        return res;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if (root.left == null && root.right != null) {
            return rightDepth + 1;
        } else if (root.left != null && root.right == null) {
            return leftDepth + 1;
        }

        return Math.min(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        var data = Arrays.asList(1, 2, 3, 4, null, 5, null, 6, 7, 8, 9, 10);
        var root = BinaryTreeUtils.buildBinTreeFromLevelOrder(data);
        BinaryTreeUtils.printBinTree(root);
        var res = solu.minDepth(root);
        System.out.println(res);
    }
}
