package com.fan.leet226.v1;

import java.util.Arrays;

import com.fan.utils.BinaryTreeUtils;
import com.fan.utils.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        recurse(root);

        return root;
    }

    private void recurse(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        recurse(root.right);
        recurse(root.left);
    }

    public static void main(String[] args) {
        var solu = new Solution();
        var data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(data);
        var root = BinaryTreeUtils.buildBinTreeFromLevelOrder(data);
        BinaryTreeUtils.printBinTree(root);
        var resRoot = solu.invertTree(root);
        BinaryTreeUtils.printBinTree(resRoot);
    }
}
