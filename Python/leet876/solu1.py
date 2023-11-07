# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def middleNode(self, head: ListNode) -> ListNode:
        slowP = head
        fastP = head
        while fastP and fastP.next:
            fastP = fastP.next.next
            slowP = slowP.next

        return slowP
