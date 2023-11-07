package com.fan.leet19;

import com.fan.utils.ListNode;
import com.fan.utils.ListNodeUtils;

import java.util.Arrays;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode p2 = dummyHead;
        while (n > 0) {
            p = p.next;
            n--;
        }
        while (p.next != null) {
            p = p.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        var data = Arrays.asList(1, 2, 3, 4, 5);
        var head = ListNodeUtils.generateFromList(data);
        int n = 2;
        var res = solu.removeNthFromEnd(head, n);
        ListNodeUtils.printList(res);
    }
}
