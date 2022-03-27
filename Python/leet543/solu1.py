from typing import List

# Definition for a binary tree node.


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        if not root or (not root.left and not root.right):
            return 0

        self.diameter = 0

        def dfs(root: TreeNode):
            if not root:
                return 0
            left = dfs(root.left)
            right = dfs(root.right)
            res = max(left, right) + 1
            self.diameter = max(self.diameter, left + right)
            return res

        dfs(root)
        return self.diameter


if __name__ == '__main__':
    solu = Solution()
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.right = TreeNode(3)
    print(solu.diameterOfBinaryTree(root))

    # treeNodeList = [1, 2, 3, 4, 5]
    # tree = createBTree(treeNodeList, 0)
    # levelTraverse(tree)
