package com.fan.leet101;

import java.util.Arrays;

import com.fan.utils.BinaryTreeUtils;
import com.fan.utils.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean res = recurse(root.left, root.right);
        return res;
    }

    /**
     * @param leftNode  Not leftChild, notice.
     * @param rightNode Same as above.
     * @return
     */
    private boolean recurse(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        } else if (leftNode == null && rightNode != null) {
            return false;
        } else if (leftNode != null && rightNode == null) {
            return false;
        } else if (leftNode.val != rightNode.val) {
            return false;
        }

        boolean outsideRes = recurse(leftNode.left, rightNode.right);
        boolean insideRes = recurse(leftNode.right, rightNode.left);
        boolean res = outsideRes && insideRes;

        return res;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        var data = Arrays.asList(1, 2, 2, 3, 4, 4, 3);
        data = Arrays.asList(1, 2, 2, 3, 4, 5, 4, 3);
        var root = BinaryTreeUtils.buildBinTreeFromLevelOrder(data);
        BinaryTreeUtils.printBinTree(root);
        var res = solu.isSymmetric(root);
        System.out.println(res);
    }
}
