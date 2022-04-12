from turtle import right
from typing import List


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


class Solution:
    def constructFromPrePost(self, preorder: List[int], postorder: List[int]) -> TreeNode:
        self.preDict = {}
        self.postDict = {}
        for i in range(len(preorder)):
            self.preDict[preorder[i]] = i
            self.postDict[postorder[i]] = i

        def build(preorder: List[int], leftPre: int, rightPre: int, postorder: List[int], leftPost: int, rightPost: int):
            if leftPre > rightPre:
                return None
            root = None
            if leftPre < len(preorder):
                root = TreeNode(preorder[leftPre])
            if leftPre > len(preorder) - 2:
                return root
            if leftPre == rightPre:
                return TreeNode(preorder[leftPre])
            # 左子树
            size = self.postDict[preorder[leftPre + 1]] - leftPost + 1
            leftPreL = leftPre + 1
            rightPreL = leftPre + size
            leftPostL = leftPost
            rightPostL = leftPost + size - 1
            # 右子树
            leftPreR = rightPreL + 1
            rightPreR = rightPre
            leftPostR = rightPostL + 1
            rightPostR = rightPost - 1

            # print(leftPreL, rightPreL, leftPostL, rightPostL)  # 1 3 0 2
            # print(leftPreR, rightPreR, leftPostR, rightPostR)  # 4 6 1 5
            # print('==========test==========')

            root.left = build(preorder, leftPreL, rightPreL,
                              postorder, leftPostL, rightPostL)
            root.right = build(preorder, leftPreR, rightPreR,
                               postorder, leftPostR, rightPostR)

            return root

        res = build(preorder, 0, len(preorder) - 1,
                    postorder, 0, len(postorder) - 1)
        return res


solu = Solution()
preorder = [1, 2, 4, 5, 3, 6, 7]
postorder = [4, 5, 2, 6, 7, 3, 1]
# preorder = [2, 4, 5]
# postorder = [4, 5, 2]
res = solu.constructFromPrePost(preorder, postorder)
res.display()
