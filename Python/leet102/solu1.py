from typing import Optional, List
from queue import Queue
import os
import sys

# 引入二叉树相关的包
sys.path.insert(0, os.path.abspath(
    os.path.join(os.path.dirname(__file__), "..")))
from utils.buildTreeFromLevelOrder import TreeNode, buildTreeFromLevelOrder


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        q = Queue()
        q.put(root)
        res: List[List[int]] = []
        while not q.empty():
            curLevel = []
            curLevelNodeCnt = q.qsize()
            for _ in range(curLevelNodeCnt):
                curNode: TreeNode = q.get()
                curLevel.append(curNode.val)
                if curNode.left:
                    q.put(curNode.left)
                if curNode.right:
                    q.put(curNode.right)
            res.append(curLevel)
        return res


if __name__ == "__main__":
    solu = Solution()
    data = [3, 9, 20, None, None, 15, 7]
    root = buildTreeFromLevelOrder(data)
    res = solu.levelOrder(root)
    print(res)
