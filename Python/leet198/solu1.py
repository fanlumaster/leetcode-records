# 纯递归，会超时

from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        self.nums = nums

        def dp(start: int):
            if start >= len(self.nums):
                return 0
            res = max(dp(start + 1), self.nums[start] + dp(start + 2))
            return res

        return dp(0)


solu = Solution()
nums = [1, 2, 3, 1]
nums = [183, 219, 57, 193, 94, 233, 202, 154, 65, 240, 97, 234, 100, 249, 186, 66, 90, 238,
        168, 128, 177, 235, 50, 81, 185, 165, 217, 207, 88, 80, 112, 78, 135, 62, 228, 247, 211]
res = solu.rob(nums)
print(res)
