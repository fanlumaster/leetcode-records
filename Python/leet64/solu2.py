'''
使用备忘录进行优化

执行用时：4984 ms, 在所有 Python3 提交中击败了6.16%的用户
内存消耗：70.9 MB, 在所有 Python3 提交中击败了5.01%的用户
'''
from typing import List


class Solution:
    def __init__(self) -> None:
        self.memo = {}

    def minPathSum(self, grid: List[List[int]]) -> int:
        M = len(grid)
        N = len(grid[0])
        if (M, N) in self.memo:
            return self.memo[(M, N)]
        if len(grid) == 1 and len(grid[0]) == 1:
            return grid[0][0]
        if len(grid) == 1:
            return self.minPathSum([grid[0][:len(grid[0]) - 1]]) + grid[-1][-1]
        if len(grid[0]) == 1:
            return self.minPathSum(grid[:len(grid) - 1]) + grid[-1][-1]

        M = len(grid)
        N = len(grid[0])

        leftSubGrid = [grid[i][:N - 1] for i in range(M)]
        upSubGrid = grid[0:len(grid) - 1]
        leftSum = self.minPathSum(leftSubGrid)
        upSum = self.minPathSum(upSubGrid)
        res = min(leftSum, upSum) + grid[-1][-1]
        self.memo[(M, N)] = res
        return res


solu = Solution()
grid = [[1, 3, 1], [1, 5, 1], [4, 2, 1]]
res = solu.minPathSum(grid)
print(res)
