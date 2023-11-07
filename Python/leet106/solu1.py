from typing import List


class    TreeNode:
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
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        # 首先，构造列表中值与索引一一映射的字典
        self.inorderDict = {}
        self.postOrderDict = {}
        for i in range(len(inorder)):
            self.inorderDict[inorder[i]] = i
            self.postOrderDict[postorder[i]] = i

        def build(inorder: List[int], inLeft: int, inRight: int, postorder: List[int], postLeft: int, postRight: int):
            if inLeft > inRight:
                return None
            root = TreeNode(postorder[postRight])
            # 左子树
            size = self.inorderDict[postorder[postRight]] - inLeft
            leftNextInLeft = inLeft
            leftNextInRight = inLeft + size - 1
            leftNextPostLeft = postLeft
            leftNextPostRight = postLeft + size - 1
            # 右子树
            size = inRight - self.inorderDict[postorder[postRight]]
            rightNextInleft = inRight - size + 1
            rightNextInRight = inRight
            rightNextPostLeft = postRight - size
            rightNextPostRight = postRight - 1
            root.left = build(inorder, leftNextInLeft, leftNextInRight,
                              postorder, leftNextPostLeft, leftNextPostRight)
            root.right = build(inorder, rightNextInleft, rightNextInRight,
                               postorder, rightNextPostLeft, rightNextPostRight)
            return root

        res = build(inorder, 0, len(inorder) - 1,
                    postorder, 0, len(postorder) - 1)

        return res


solu = Solution()
inorder = [9, 3, 15, 20, 7]
postorder = [9, 15, 7, 20, 3]
inorder = [-1]
postorder = [-1]
res = solu.buildTree(inorder, postorder)
res.display()
