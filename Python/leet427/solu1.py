'''
题目是：建立四叉树
二维的前缀树加递归
'''

from typing import List, Tuple

# Definition for a QuadTree node.


class Node:
    def __init__(self, val, isLeaf, topLeft=None, topRight=None, bottomLeft=None, bottomRight=None):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight


class Solution:
    def buildPrefixSumGrid(self, grid: List[List[int]]) -> List[List[int]]:
        '''
        构建前缀和数组
        '''
        gridPrefixSum = [[0 for i in range(len(grid[0]))]
                         for j in range(len(grid))]
        for i in range(len(grid)):
            gridPrefixSum[i][0] = grid[i][0]
            for j in range(1, len(grid[0])):
                gridPrefixSum[i][j] += gridPrefixSum[i][j - 1] + grid[i][j]
        for i in range(1, len(grid)):
            gridPrefixSum[i][0] += gridPrefixSum[i - 1][0]
            for j in range(1, len(grid[0])):
                gridPrefixSum[i][j] += gridPrefixSum[i - 1][j]

        return gridPrefixSum

    def judgeZeroOrOneAll(self, grid: List[List[int]], gridPrefixSum: List[List[int]], coord1: Tuple[int, int], coord2: Tuple[int, int]):
        '''
        判断 grid 数组中 i 到 j 这个区域是否是全 0 或者全 1
        注意这里的坐标的第一个值 x 表示行，第二个值 y 表示列
        '''
        squareWidth = coord2[0] - coord1[0] + 1
        squareWidthHalf = squareWidth // 2
        squareArea = squareWidth ** 2
        coord1 = (coord1[0] - 1, coord1[1] - 1)
        if coord1[0] < 0:
            squareSum = gridPrefixSum[coord2[0]][coord2[1]]
        else:
            squareSum = gridPrefixSum[coord2[0]][coord2[1]] - gridPrefixSum[coord1[0] + squareWidthHalf][coord1[1]] - \
                gridPrefixSum[coord1[0]][coord1[1] + squareWidthHalf] + \
                gridPrefixSum[coord1[0]][coord1[1]]
        if squareSum == 0:
            return (True, 0)
        if squareSum == squareArea:
            return (True, 1)
        return (False, 0)

    def construct(self, grid: List[List[int]]) -> 'Node':
        gridWidth = len(grid)
        gridPrefixSum = self.buildPrefixSumGrid(grid)
        ans = self.constructHelp(
            gridPrefixSum, grid, (0, 0), (gridWidth - 1, gridWidth - 1))
        return ans

    def constructHelp(self, gridPrefixSum: List[List[int]], grid: List[List[int]], coord1: Tuple[int, int], coord2: Tuple[int, int]):
        width = coord2[0] - coord1[0] + 1
        if width == 1:
            return Node(grid[coord1[0]][coord1[1]], 1)
        judgeRes = self.judgeZeroOrOneAll(grid, gridPrefixSum, coord1, coord2)
        halfWidth = width // 2
        if judgeRes[0] == True:
            return Node(judgeRes[1], 1)
        topLeft = self.constructHelp(
            gridPrefixSum, grid, coord1, (coord2[0] - halfWidth, coord2[1] - halfWidth))
        topRight = self.constructHelp(
            gridPrefixSum, grid, (coord1[0], coord1[1] + halfWidth), (coord2[0] - halfWidth, coord2[1]))
        bottomLeft = self.constructHelp(
            gridPrefixSum, grid, (coord1[0] + halfWidth, coord1[1]), (coord2[0], coord2[1] - halfWidth))
        bottomRight = self.constructHelp(
            gridPrefixSum, grid, (coord1[0] + halfWidth, coord1[1] + halfWidth), coord2)

        res = Node(1, 0, topLeft, topRight, bottomLeft, bottomRight)
        return res


solu = Solution()
grid = [[0, 1], [1, 0]]
grid = [[1, 1, 1, 1, 0, 0, 0, 0], [1, 1, 1, 1, 0, 0, 0, 0], [1, 1, 1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1, 1, 1], [
    1, 1, 1, 1, 0, 0, 0, 0], [1, 1, 1, 1, 0, 0, 0, 0], [1, 1, 1, 1, 0, 0, 0, 0], [1, 1, 1, 1, 0, 0, 0, 0]]
res = solu.construct(grid)
print(res.isLeaf, res.val)
print(res.topLeft.isLeaf, res.topLeft.val)
print(res.topRight.isLeaf, res.topRight.val)
print(res.bottomLeft.isLeaf, res.bottomLeft.val)
print(res.bottomRight.isLeaf, res.bottomRight.val)
