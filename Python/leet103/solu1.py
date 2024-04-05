from queue import Queue
from typing import Optional, List, Tuple


class TreeNode:
    # Definition for a binary tree node.
    def __init__(self, val) -> None:
        self.val = val
        self.right: Optional[TreeNode] = None
        self.left: Optional[TreeNode] = None

    def insert(self, val) -> None:
        if self.val == val:
            return
        elif self.val < val:
            if self.right is None:
                self.right = TreeNode(val)
            else:
                self.right.insert(val)
        else:  # self.val > val
            if self.left is None:
                self.left = TreeNode(val)
            else:
                self.left.insert(val)

    def display(self) -> None:
        lines, *_ = self._display_aux()
        for line in lines:
            print(line)

    def _display_aux(self) -> Tuple[List[str], int, int, int]:
        """Returns list of strings, width, height, and horizontal coordinate of the root."""
        # No child.
        if self.right is None and self.left is None:
            line = '%s' % self.val
            width = len(line)
            height = 1
            middle = width // 2
            return [line], width, height, middle

        # Only left child.
        if self.right is None and self.left is not None:
            lines, n, p, x = self.left._display_aux()
            s = '%s' % self.val
            u = len(s)
            first_line = (x + 1) * ' ' + (n - x - 1) * '_' + s
            second_line = x * ' ' + '/' + (n - x - 1 + u) * ' '
            shifted_lines = [line + u * ' ' for line in lines]
            return [first_line, second_line] + shifted_lines, n + u, p + 2, n + u // 2

        # Only right child.
        if self.left is None and self.right is not None:
            lines, n, p, x = self.right._display_aux()
            s = '%s' % self.val
            u = len(s)
            first_line = s + x * '_' + (n - x) * ' '
            second_line = (u + x) * ' ' + '\\' + (n - x - 1) * ' '
            shifted_lines = [u * ' ' + line for line in lines]
            return [first_line, second_line] + shifted_lines, n + u, p + 2, u // 2

        if self.left is not None and self.right is not None:
            # Two children.
            left, n, p, x = self.left._display_aux()
            right, m, q, y = self.right._display_aux()
            s = '%s' % self.val
            u = len(s)
            first_line = (x + 1) * ' ' + (n - x - 1) * \
                '_' + s + y * '_' + (m - y) * ' '
            second_line = x * ' ' + '/' + \
                (n - x - 1 + u + y) * ' ' + '\\' + (m - y - 1) * ' '
            if p < q:
                left += [n * ' '] * (q - p)
            elif q < p:
                right += [m * ' '] * (p - q)
            zipped_lines = zip(left, right)
            lines = [first_line, second_line] + \
                [a + u * ' ' + b for a, b in zipped_lines]
            return lines, n + m + u, max(p, q) + 2, n + u // 2
        return [], 0, 0, 0  # dummy returns


def buildTreeFromLevelOrder(data: List[int]):
    if len(data) == 0:
        return None
    count = 0
    q = Queue()
    root = TreeNode(data[0])
    q.put(root)
    curNode = TreeNode(0)  # dummy value

    for i in range(1, len(data)):
        node = TreeNode(data[i]) if data[i] != None else None
        if count == 0:
            curNode = q.get()
            count += 1
            curNode.left = node
        else:
            count = 0
            curNode.right = node
        if data[i] != None:
            q.put(node)

    return root


class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        q = Queue()
        q.put(root)
        res: List[List[int]] = []
        direction = 1
        while not q.empty():
            curLevel = []
            curLevelNodeCnt = q.qsize()
            for _ in range(curLevelNodeCnt):
                curNode: TreeNode = q.get()
                curLevel.append(curNode.val)
                if curNode.left:
                    q.put(curNode.left)
                if curNode.right:
                    q.put(curNode.right)
            if (direction == -1):
                curLevel = curLevel[::-1]
            res.append(curLevel)
            direction *= -1
        return res


if __name__ == "__main__":
    solu = Solution()
    data = [3, 9, 20, None, None, 15, 7]
    root = buildTreeFromLevelOrder(data)
    res = solu.zigzagLevelOrder(root)
    print(res)
