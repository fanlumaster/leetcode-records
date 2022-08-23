package com.fan.leet105;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fan.utils.BinaryTreeUtils;
import com.fan.utils.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preorderList = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        List<Integer> inorderList = Arrays.stream(inorder).boxed().collect(Collectors.toList());

        TreeNode root = recurse(preorderList, inorderList);

        return root;
    }

    private TreeNode recurse(List<Integer> preorderList, List<Integer> inorderList) {
        if (preorderList.size() == 0) {
            return null;
        }

        int curValue = preorderList.get(0);
        TreeNode root = new TreeNode(curValue);

        int i = 0;
        for (; i < preorderList.size(); i++) {
            if (inorderList.get(i) == curValue) {
                break;
            }
        }

        List<Integer> leftPreorderList = preorderList.subList(1, 1 + i);
        List<Integer> leftInorderList = inorderList.subList(0, i);
        List<Integer> rightPreorderList = preorderList.subList(1 + i, preorderList.size());
        List<Integer> rightInorderList = inorderList.subList(i + 1, inorderList.size());
        TreeNode leftChild = recurse(leftPreorderList, leftInorderList);
        TreeNode rightChild = recurse(rightPreorderList, rightInorderList);

        root.left = leftChild;
        root.right = rightChild;

        return root;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        var preorder = new int[] { 3, 9, 20, 15, 7 };
        var inorder = new int[] { 9, 3, 15, 20, 7 };
        TreeNode root = solu.buildTree(preorder, inorder);
        BinaryTreeUtils.printBinTree(root);
    }
}
