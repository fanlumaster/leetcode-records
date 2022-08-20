package com.fan.leet206.v1;

import com.fan.utils.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode res = recurse(head, head.next);
        head.next = null;

        return res;
    }

    private ListNode recurse(ListNode cur, ListNode next) {
        if (next == null) {
            return cur;
        }
        ListNode tmp = next.next;
        next.next = cur;
        return recurse(next, tmp);
    }

    public static void main(String[] args) {
        var solu = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        var res = solu.reverseList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
