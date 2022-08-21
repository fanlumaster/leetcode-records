package com.fan.leet102;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.fan.utils.BinaryTreeUtils;
import com.fan.utils.TreeNode;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.offer(root);

        while (myQueue.size() != 0) {
            int curLevelSize = myQueue.size();
            List<Integer> curLevelRes = new ArrayList<>();
            for (int i = 0; i < curLevelSize; i++) {
                TreeNode curNode = myQueue.poll();
                curLevelRes.add(curNode.val);
                if (curNode.left != null) {
                    myQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    myQueue.offer(curNode.right);
                }
            }
            res.add(curLevelRes);
        }

        return res;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        var data = Arrays.asList(1, 2, 3, 4, 5, null, 6);
        System.out.println(data);
        var root = BinaryTreeUtils.buildBinTreeFromLevelOrder(data);
        BinaryTreeUtils.printBinTree(root);
        var res = solu.levelOrder(root);
        System.out.println(res);
    }
}
