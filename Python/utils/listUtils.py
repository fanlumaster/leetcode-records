from typing import List


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def printList(head: ListNode):
    # 打印链表
    pointer = head
    while(pointer):
        print(pointer.val, end=' ')
        pointer = pointer.next
    print()


def buildListFromArray(data: List[int]) -> ListNode:
    if not data:
        return None
    if len(data) == 1:
        return ListNode(data[0])
    head = ListNode(data[0])
    pointer = head
    for i in range(1, len(data)):
        pointer.next = ListNode(data[i])
        pointer = pointer.next

    return head


data = [1, 2, 3, 4, 5]
head = buildListFromArray(data)
printList(head)
