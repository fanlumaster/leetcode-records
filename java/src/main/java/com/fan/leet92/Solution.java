package com.fan.leet92;

import com.fan.utils.ListNode;
import com.fan.utils.ListNodeUtils;

import java.util.Arrays;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode();
        ListNode preLeftNode, leftNode, rightNode, nextRightNode;
        preLeftNode = leftNode = rightNode = nextRightNode = dummyHead;
        dummyHead.next = head;
        ListNode p = dummyHead;
        int count = 0;
        while (p.next != null) {
            count += 1;
            if (count == left) {
                preLeftNode = p;
                leftNode = p.next;
            }
            if (count == right) {
                rightNode = p.next;
                nextRightNode = p.next.next;
            }
            p = p.next;
        }
        rightNode.next = null;
        ListNode reversedPartHead = reverse(leftNode);
        preLeftNode.next = reversedPartHead;
        leftNode.next = nextRightNode;

        return dummyHead.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        var head = ListNodeUtils.generateFromList(Arrays.asList(1, 2, 3, 4, 5));
        int left = 2, right = 4;
        var res = solu.reverseBetween(head, left, right);
        ListNodeUtils.printList(res);
    }
}
