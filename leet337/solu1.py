# 使用备忘录的递归，不然会超时

from typing import List
from queue import Queue

# Definition for a binary tree node.


class TreeNode:
    def __init__(self, val):
        self.val = val
        self.right = None
        self.left = None

    def insert(self, val):
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

    def display(self):
        lines, *_ = self._display_aux()
        for line in lines:
            print(line)

    def _display_aux(self):
        """Returns list of strings, width, height, and horizontal coordinate of the root."""
        # No child.
        if self.right is None and self.left is None:
            line = '%s' % self.val
            width = len(line)
            height = 1
            middle = width // 2
            return [line], width, height, middle

        # Only left child.
        if self.right is None:
            lines, n, p, x = self.left._display_aux()
            s = '%s' % self.val
            u = len(s)
            first_line = (x + 1) * ' ' + (n - x - 1) * '_' + s
            second_line = x * ' ' + '/' + (n - x - 1 + u) * ' '
            shifted_lines = [line + u * ' ' for line in lines]
            return [first_line, second_line] + shifted_lines, n + u, p + 2, n + u // 2

        # Only right child.
        if self.left is None:
            lines, n, p, x = self.right._display_aux()
            s = '%s' % self.val
            u = len(s)
            first_line = s + x * '_' + (n - x) * ' '
            second_line = (u + x) * ' ' + '\\' + (n - x - 1) * ' '
            shifted_lines = [u * ' ' + line for line in lines]
            return [first_line, second_line] + shifted_lines, n + u, p + 2, u // 2

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


def buildTree(data: List[int]):
    count = 0
    q = Queue()
    root = TreeNode(data[0])
    q.put(root)
    curNode = None

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
    def rob(self, root: TreeNode) -> int:
        self.memo = {}

        def rob(root: TreeNode):
            if root == None:
                return 0
            if root in self.memo:
                return self.memo[root]
            res0 = rob(root.left) + rob(root.right)
            res1 = root.val
            if root.left != None:
                res1 += rob(root.left.left) + rob(root.left.right)
            if root.right != None:
                res1 += rob(root.right.left) + rob(root.right.right)
            res = max(res0, res1)
            self.memo[root] = res
            return res

        return rob(root)


solu = Solution()
data = [3, 2, 3, None, 3, None, 1]
data = [3, 4, 5, 1, 3, None, 1]
data = [79, 99, 77, None, None, None, 69, None, 60, 53, None, 73, 11, None, None, None,
        62, 27, 62, None, None, 98, 50, None, None, 90, 48, 82, None, None, None, 55, 64,
        None, None, 73, 56, 6, 47, None, 93, None, None, 75, 44, 30, 82, None, None, None,
        None, None, None, 57, 36, 89, 42, None, None, 76, 10, None, None, None, None, None,
        32, 4, 18, None, None, 1, 7, None, None, 42, 64, None, None, 39, 76, None, None, 6, None,
        66, 8, 96, 91, 38, 38, None, None, None, None, 74, 42, None, None, None, 10, 40, 5, None,
        None, None, None, 28, 8, 24, 47, None, None, None, 17, 36, 50, 19, 63, 33, 89, None, None,
        None, None, None, None, None, None, 94, 72, None, None, 79, 25, None, None, 51, None, 70,
        84, 43, None, 64, 35, None, None, None, None, 40, 78, None, None, 35, 42, 98, 96, None, None,
        82, 26, None, None, None, None, 48, 91, None, None, 35, 93, 86, 42, None, None, None, None, 0,
        61, None, None, 67, None, 53, 48, None, None, 82, 30, None, 97, None, None, None, 1, None, None]
root = buildTree(data)
root.display()
res = solu.rob(root)
print(res)
