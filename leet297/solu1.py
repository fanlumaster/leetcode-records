
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

from typing import List
from queue import Queue

class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return "[None]"

        res = []
        q = [root]
        while q:
            size = len(q)
            for i in range(size):
                each = q.pop(0)
                if each == None:
                    res.append(None)
                else:
                    res.append(each.val)
                    q.append(each.left)
                    q.append(each.right)

        index = len(res) - 1
        while index > -1 and res[index] == None:
            res.pop()
            index -= 1

        return str(res)

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
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
                if count == 0:
                    count += 1
                    curNode.left = node
                else:
                    count = 0
                    curNode.right = node
                if data[i] != None:
                    q.put(node)
            
            return root

        data = data[1:-1]
        if data == 'None':
            return None
        data = data.split(', ')
        for i in range(len(data)):
            if data[i] == 'None':
                data[i] = None
            else:
                data[i] = int(data[i])

        # print('data', data)
        root = buildTree(data)
        return root


# Your Codec object will be instantiated and called as such:
ser = Codec()
deser = Codec()
# root = TreeNode(1)
# root.left = TreeNode(2)
# root.display()
# print(ser.serialize(root))
# ans = deser.deserialize(ser.serialize(root))
# ans.display()
# print('--------')
data = '[1, 2, 3, None, None, 4, 5, 6, 7]'
data = '[4, -7, -3, None, None, -9, -3, 9, -7, -4, None, 6, None, -6, -6, None, None, 0, 6, 5, None, 9, None, None, -1, -4, None, None, None, -2]'
deser.deserialize(data).display()
