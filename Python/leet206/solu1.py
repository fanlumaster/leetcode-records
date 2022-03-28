# 递归反转链表

# Definition for singly-linked list.
from typing import List


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head == None or head.next == None:
            return head
        reversedHead = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return reversedHead


def printList(head: ListNode):
    pointer = head
    while(pointer):
        print(pointer.val, end=' ')
        pointer = pointer.next
    print()


solu = Solution()
head = ListNode(1)
head.next = ListNode(2)
head.next.next = ListNode(3)
head.next.next.next = ListNode(4)
head.next.next.next.next = ListNode(5)
printList(head)
res = solu.reverseList(head)
printList(res)
