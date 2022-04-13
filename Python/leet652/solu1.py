from typing import Optional, List
from queue import Queue


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
    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
        self.res = []
        self.treeDict = {}

        def postTraverse(root: TreeNode):
            if root == None:
                return '#'  # 空节点用 # 来表示
            left = postTraverse(root.left)
            right = postTraverse(root.right)
            curTree = left + ',' + right + ',' + str(root.val)
            print(curTree)
            if curTree in self.treeDict:
                self.treeDict[curTree] += 1
            else:
                self.treeDict[curTree] = 1
            if self.treeDict[curTree] == 2:
                self.res.append(root)
            return curTree

        postTraverse(root)
        return self.res


solu = Solution()
root = [1, 2, 3, 4, None, 2, 4, None, None, 4]
root = [2, 1, 1]
root = [10, 2, 22, 1, 12, 1, 1]
root = buildTree(root)
root.display()
res = solu.findDuplicateSubtrees(root)
res = [item.val for item in res]
print(res)
