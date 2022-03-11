from typing import List, Optional
from queue import PriorityQueue

# Definition for singly-linked list.


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        pq = PriorityQueue()
        dummy = ListNode(-1)
        res = dummy
        for i in range(len(lists)):
            curNode = lists[i]
            while curNode:
                pq.put(curNode.val)
                curNode = curNode.next
        while not pq.empty():
            dummy.next = ListNode(pq.get())
            dummy = dummy.next

        return res.next


if __name__ == '__main__':
    solu = Solution()
    # lists = [ListNode(1), ListNode(4), ListNode(5)]
    # lists = [ListNode(1), ListNode(3), ListNode(4)]
    lists = [ListNode(1), ListNode(2), ListNode(3)]
    res = solu.mergeKLists(lists)
    while res:
        print(res.val)
        res = res.next
