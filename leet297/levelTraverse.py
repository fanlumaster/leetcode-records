class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def levelTraverseTree(root: TreeNode):
    if not root:
        return "None"

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

    return res


root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.right.left = TreeNode(4)
root.right.right = TreeNode(5)
res = levelTraverseTree(root)
print(res)
