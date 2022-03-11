# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        res = head
        headCopy = head
        for _ in range(n):
            headCopy = headCopy.next
        # 如果删除第倒数 size 个节点
        if not headCopy:
            return res.next
        while headCopy.next:
            head = head.next
            headCopy = headCopy.next

        head.next = head.next.next
        return res
