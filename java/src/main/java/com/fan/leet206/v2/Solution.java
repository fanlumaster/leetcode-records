package com.fan.leet206.v2;

import com.fan.utils.ListNode;
import com.fan.utils.ListNodeUtils;

import java.util.Arrays;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode res = recursion(head);
        p.next = null;
        return res;
    }

    private ListNode recursion(ListNode head) {
        if (head.next.next == null) {
            ListNode res = head.next;
            res.next = head;
            return res;
        }
        ListNode res = reverseList(head.next);
        head.next.next = head;
        return res;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        var head = ListNodeUtils.generateFromList(Arrays.asList(1, 2, 3, 4, 5));
        var res = solu.reverseList(head);
        ListNodeUtils.printList(res);
    }
}
