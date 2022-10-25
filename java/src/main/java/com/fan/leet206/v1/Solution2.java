package com.fan.leet206.v1;


import com.fan.utils.ListNode;
import com.fan.utils.ListNodeUtils;

import java.util.Arrays;

// recurse write again
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = recursion(null, head);
        return res;
    }

    private ListNode recursion(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode nextNode = cur.next;
        cur.next = pre;
        return recursion(cur, nextNode);
    }

    public static void main(String[] args) {
        var solu = new Solution2();
        ListNode head = ListNodeUtils.generateFromList(Arrays.asList(1, 2, 3, 4, 5));
        var res = solu.reverseList(head);
        ListNodeUtils.printList(res);
    }
}
