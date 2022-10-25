package com.fan.leet86;

import com.fan.utils.ListNode;
import com.fan.utils.ListNodeUtils;

import java.util.Arrays;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode();
        ListNode p = head, p1 = list1, p2 = list2;

        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            p = p.next;
        }
        p2.next = null;
        p1.next = list2.next;
        return list1.next;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        var data = Arrays.asList(1, 4, 3, 2, 5, 2);
        ListNode head = ListNodeUtils.generateFromList(data);
        int x = 3;
        var res = solu.partition(head, x);
        ListNodeUtils.printList(res);
    }
}
