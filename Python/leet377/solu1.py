from typing import List


class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        N = len(nums)
        dp = [0 for i in range(target + 1)]
        dp[0] = 1
        for i in range(1, target + 1):
            for j in range(N):
                if (nums[j] <= i):
                    dp[i] += dp[i - nums[j]]
        return dp[target]


solu = Solution()
nums = [1, 2, 3]
target = 4
res = solu.combinationSum4(nums, target)
print(res)
