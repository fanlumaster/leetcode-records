'''
没有使用备忘录，超出时间限制
'''
from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
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
        return res


solu = Solution()
grid = [[1, 3, 1], [1, 5, 1], [4, 2, 1]]
res = solu.minPathSum(grid)
print(res)
