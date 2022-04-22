'''
自底向上进行构建

执行用时：48 ms, 在所有 Python3 提交中击败了77.24%的用户
内存消耗：16.6 MB, 在所有 Python3 提交中击败了44.24%的用户
'''
from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        dp = [[0 for j in range(len(grid[0]))] for i in range(len(grid))]
        dp[0][0] = grid[0][0]
        for i in range(1, len(grid[0])):
            dp[0][i] = dp[0][i - 1] + grid[0][i]
        for i in range(1, len(grid)):
            dp[i][0] = dp[i - 1][0] + grid[i][0]
        for i in range(1, len(grid)):
            for j in range(1, len(grid[0])):
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]

        return dp[-1][-1]


solu = Solution()
grid = [[1, 3, 1], [1, 5, 1], [4, 2, 1]]
res = solu.minPathSum(grid)
print(res)
