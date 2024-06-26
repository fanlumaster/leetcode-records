import random
from typing import List, Optional, Tuple


class TreeNode:
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


if __name__ == "__main__":

    b = TreeNode(50)
    for _ in range(50):
        b.insert(random.randint(0, 100))
    b.display()

    # root = TreeNode(1)
    # root.left = TreeNode(2)
    # root.right = TreeNode(3)
    # root.right.left = TreeNode(4)
    # root.right.right = TreeNode(5)
    # root.display()
