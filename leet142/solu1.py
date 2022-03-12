# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        slowP = head
        fastP = head
        while fastP and fastP.next:
            slowP = slowP.next
            fastP = fastP.next.next
            if slowP == fastP:
                slowP = head
                while not fastP == slowP:
                    slowP = slowP.next
                    fastP = fastP.next
                return fastP

        return None
