from typing import List


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def printList(head: ListNode):
    # 打印链表
    pointer = head
    while pointer:
        print(pointer.val, end=" ")
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


class Solution:
    def reverseBetween(self, head: ListNode, left: int, right: int) -> ListNode:
        # 第 N 个节点的后一个节点
        self.successor = None
        self.count = right - left + 1
        self.left = left

        def reverseN(head: ListNode, N: int):
            # 反转前 N 个节点
            if N == 1:
                self.successor = head.next
                return head

            reversedHead = reverseN(head.next, N - 1)
            head.next.next = head
            head.next = self.successor
            return reversedHead

        # return reverseN(head, 5)

        def reverseBt(head: ListNode, index: int):
            # 逆转从 index 开始的 M 个节点
            if index == self.left:
                return reverseN(head, self.count)
            reversedHead = reverseBt(head.next, index + 1)
            head.next = reversedHead
            return head

        res = reverseBt(head, 1)
        return res


solu = Solution()
data = [1, 2, 3, 4, 5]
head = buildListFromArray(data)
printList(head)
left = 2
right = 4
head = solu.reverseBetween(head, 2, 4)
printList(head)
