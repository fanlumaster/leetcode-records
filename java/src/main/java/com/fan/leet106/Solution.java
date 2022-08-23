package com.fan.leet106;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fan.utils.BinaryTreeUtils;
import com.fan.utils.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> inorderList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        List<Integer> postorderList = Arrays.stream(postorder).boxed().collect(Collectors.toList());

        TreeNode root = recurse(inorderList, postorderList);

        return root;
    }

    public TreeNode recurse(List<Integer> inorderList, List<Integer> postorderList) {
        if (inorderList.size() == 0) {
            return null;
        }

        int curValue = postorderList.get(postorderList.size() - 1);
        TreeNode root = new TreeNode(curValue);

        int i = 0;
        for (; i < inorderList.size(); i++) {
            if (inorderList.get(i) == curValue) {
                break;
            }
        }

        List<Integer> leftInorderList = inorderList.subList(0, i);
        List<Integer> leftPostorderList = postorderList.subList(0, i);
        List<Integer> rightInorderList = inorderList.subList(i + 1, inorderList.size());
        List<Integer> rightPostorderList = postorderList.subList(i, postorderList.size() - 1);

        TreeNode leftChild = recurse(leftInorderList, leftPostorderList);
        TreeNode rightChild = recurse(rightInorderList, rightPostorderList);

        root.left = leftChild;
        root.right = rightChild;

        return root;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        var inorder = new int[] { 9, 3, 15, 20, 7 };
        var postorder = new int[] { 9, 15, 7, 20, 3 };
        var root = solu.buildTree(inorder, postorder);
        BinaryTreeUtils.printBinTree(root);
    }
}
