package com.fan.leet206.v3;

import com.fan.utils.ListNode;
import com.fan.utils.ListNodeUtils;

import java.util.Arrays;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        var head = ListNodeUtils.generateFromList(Arrays.asList(1, 2, 3, 4, 5));
        var res = solu.reverseList(head);
        ListNodeUtils.printList(res);
    }
}
