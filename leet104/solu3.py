from typing import Optional

# Definition for a binary tree node.


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        self.depth = 0
        self.res = 0

        def traverse(root: Optional[TreeNode]):
            if not root:
                return
            self.depth += 1
            self.res = max(self.res, self.depth)
            traverse(root.left)
            traverse(root.right)
            self.depth -= 1

        traverse(root)
        return self.res


if __name__ == '__main__':
    solu = Solution()
    root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right.left = TreeNode(15)
    root.right.right = TreeNode(7)
    print(solu.maxDepth(root))
