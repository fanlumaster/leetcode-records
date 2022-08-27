package com.fan.leet538;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.fan.utils.BinaryTreeUtils;
import com.fan.utils.TreeNode;

public class Solution {
    public TreeNode convertBST(TreeNode root) {
        List<Integer> numsList = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();
        recurseGet(root, numsList);
        Collections.reverse(numsList);
        stack.push(numsList.get(0));
        for (int i = 1; i < numsList.size(); i++) {
            int curVal = numsList.get(i) + numsList.get(i - 1);
            numsList.set(i, curVal);
            stack.push(curVal);
        }
        recurseSet(root, stack);

        return root;
    }

    private void recurseGet(TreeNode root, List<Integer> numsList) {
        if (root == null) {
            return;
        }

        recurseGet(root.left, numsList);
        numsList.add(root.val);
        recurseGet(root.right, numsList);
    }

    private void recurseSet(TreeNode root, Deque<Integer> stack) {
        if (root == null) {
            return;
        }
        recurseSet(root.left, stack);
        root.val = stack.pop();
        recurseSet(root.right, stack);
    }

    public static void main(String[] args) {
        var solu = new Solution();
        var data = Arrays.asList(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8);
        var root = BinaryTreeUtils.buildBinTreeFromLevelOrder(data);
        BinaryTreeUtils.printBinTree(root);
        var res = solu.convertBST(root);
        BinaryTreeUtils.printBinTree(res);
    }
}
