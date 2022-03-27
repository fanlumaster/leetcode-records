from typing import List
import sys
import os
sys.path.append(os.path.abspath("../utils"))
from printBTree import TreeNode


def recoverFromLevelTraverse(rootList: List):
    if len(rootList) == 0:
        return None
    TreeNodeList = []
    N = len(rootList)
    for i in range(N):
        if rootList[i] != None:
            TreeNodeList.append(TreeNode(rootList[i]))
        else:
            TreeNodeList.append(None)
    for i in range(N):
        if TreeNodeList[i] != None and i * 2 + 1 < N and i * 2 + 2 < N:
            TreeNodeList[i].left = TreeNodeList[i * 2 + 1]
            TreeNodeList[i].right = TreeNodeList[i * 2 + 2]

    return TreeNodeList[0]


rootList = [1, 2, 3, None, None, 4, 5]
res = recoverFromLevelTraverse(rootList)
res.display()
