package com.fan.leet141;

import com.fan.utils.ListNode;
import com.fan.utils.ListNodeUtils;

import java.util.Arrays;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode resP = res;
        ListNode p1 = list1;
        ListNode p2 = list2;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                resP.next = p1;
                p1 = p1.next;
            } else {
                resP.next = p2;
                p2 = p2.next;
            }
            resP = resP.next;
        }

        if (p1 != null) {
            resP.next = p1;
        }
        if (p2 != null) {
            resP.next = p2;
        }

        return res.next;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        var data1 = Arrays.asList(1, 2, 4);
        var data2 = Arrays.asList(1, 3, 4);
        ListNode list1 = ListNodeUtils.generateFromList(data1);
        ListNode list2 = ListNodeUtils.generateFromList(data2);
        var res = solu.mergeTwoLists(list1, list2);
        ListNodeUtils.printList(res);
    }
}
