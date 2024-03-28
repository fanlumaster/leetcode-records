"""
使用 hashmap + 双链表
"""

from typing import Optional


class ListNode:
    """
    双向链表节点
    """

    def __init__(self, key=None, value=None) -> None:
        self.key = key
        self.value = value
        self.prev: Optional[ListNode] = None
        self.next: Optional[ListNode] = None


class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.hashmap = {}
        # 新建两个节点，head 和 tail
        self.head = ListNode()
        self.tail = ListNode()
        self.head.next = self.tail
        self.tail.prev = self.head

    def move_node_to_tail(self, key: int):
        node = self.hashmap[key]
        node.prev.next = node.next
        node.next.prev = node.prev
        self.tail.prev.next = node
        node.prev = self.tail.prev
        self.tail.prev = node
        node.next = self.tail

    def get(self, key: int) -> int:
        if key in self.hashmap:
            self.move_node_to_tail(key)
        res = self.hashmap.get(key, -1)
        return res if res == -1 else res.value

    def put(self, key: int, value: int) -> None:
        if key in self.hashmap:
            self.hashmap[key].value = value
            self.move_node_to_tail(key)
        else:
            if len(self.hashmap) == self.capacity:
                self.hashmap.pop(self.head.next.key)
                self.head.next = self.head.next.next
                self.head.next.prev = self.head
            new = ListNode(key, value)
            self.hashmap[key] = new
            new.prev = self.tail.prev
            new.next = self.tail
            self.tail.prev.next = new
            self.tail.prev = new


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)

if __name__ == "__main__":
    # case1
    capacity = 2
    actions = ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
    data = [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

    lru = LRUCache(capacity)
    output = ["null"]
    for i in range(1, len(actions)):
        if "put" == actions[i]:
            lru.put(data[i][0], data[i][1])
            output.append("null")
        elif "get" == actions[i]:
            cur_val = lru.get(data[i][0])
            output.append(str(cur_val))
    print(output)
