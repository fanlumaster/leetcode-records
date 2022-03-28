# 这题暴力解法很简单。
# 问题是优化的解法，即动态规划。
# 这里的 dp[i] 的定义是以 i 结尾的连续子数组的最大值

from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        dp = [0] * len(nums)
        dp[0] = nums[0]
        for i in range(1, len(nums)):
            dp[i] = max(dp[i - 1] + nums[i], nums[i])
        res = -float('inf')
        for i in range(len(dp)):
            res = max(res, dp[i])

        return res


solu = Solution()
data = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
data = [-2, -1]
res = solu.maxSubArray(data)
print(res)
