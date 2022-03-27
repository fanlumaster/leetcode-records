from typing import Optional

# Definition for a binary tree node.


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        nodes = []

        def dfs(node: Optional[TreeNode]) -> None:
            if not node:
                return
            dfs(node.left)
            nodes.append(node)
            dfs(node.right)
        dfs(root)
        x = None
        y = None
        for i in range(len(nodes) - 1):
            if nodes[i].val > nodes[i + 1].val:
                if not x:  # if x is None, then this is the first time we see a violation
                    x = nodes[i]
                y = nodes[i + 1]  # y is the second violation
        x.val, y.val = y.val, x.val


def dfs(node: Optional[TreeNode]) -> None:
    if not node:
        return
    dfs(node.left)
    print(node.val)
    dfs(node.right)


if __name__ == "__main__":
    root = TreeNode(7)
    root.left = TreeNode(2)
    root.right = TreeNode(6)
    root.left.left = TreeNode(1)
    root.left.right = TreeNode(3)
    root.right.left = TreeNode(5)
    root.right.right = TreeNode(4)
    Solution().recoverTree(root)
    dfs(root)
