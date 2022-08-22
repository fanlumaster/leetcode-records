package com.fan.leet257;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.fan.utils.BinaryTreeUtils;
import com.fan.utils.TreeNode;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        Deque<Integer> path = new LinkedList<>();
        List<String> res = new ArrayList<>();
        recurseAndBacktrace(root, path, res);

        return res;
    }

    private void recurseAndBacktrace(TreeNode root, Deque<Integer> path, List<String> res) {
        if (root == null) {
            return;
        }
        path.push(root.val);
        if (root.left == null && root.right == null) {
            List<String> tmpStrList = path.stream().map(a -> a.toString()).collect(Collectors.toList());
            Collections.reverse(tmpStrList);
            String tmpRes = String.join("->", tmpStrList);
            res.add(tmpRes);
            path.pop();
            return;
        }
        if (root.left != null) {
            recurseAndBacktrace(root.left, path, res);
        }
        if (root.right != null) {
            recurseAndBacktrace(root.right, path, res);
        }
        path.pop();
    }

    public static void main(String[] args) {
        var solu = new Solution();
        var data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, null, 8, 9, null, 10);
        var root = BinaryTreeUtils.buildBinTreeFromLevelOrder(data);
        BinaryTreeUtils.printBinTree(root);
        var res = solu.binaryTreePaths(root);
        System.out.println(res);
    }
}
