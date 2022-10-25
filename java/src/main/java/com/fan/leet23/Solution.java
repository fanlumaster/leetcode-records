package com.fan.leet23;

import com.fan.utils.ListNode;
import com.fan.utils.ListNodeUtils;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }

        ListNode res = new ListNode();
        ListNode p = res;
        ListNode curNode = null;
        while (pq.size() != 0) {
            curNode = pq.poll();
            if (curNode != null) {
                p.next = curNode;
                p = p.next;
                curNode = curNode.next;
                if (curNode != null) {
                    pq.offer(curNode);
                }
            }
        }

        return res.next;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        var lists = new ListNode[]{ListNodeUtils.generateFromList(Arrays.asList(1, 4, 5)), ListNodeUtils.generateFromList(Arrays.asList(1, 3, 4)), ListNodeUtils.generateFromList(Arrays.asList(2, 6))};
        var res = solu.mergeKLists(lists);
        ListNodeUtils.printList(res);
    }
}
