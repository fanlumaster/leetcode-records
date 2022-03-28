from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 1
        dp = [0] * len(nums)
        dp[0] = 1
        for i in range(1, len(nums)):
            tmp = 0
            for j in range(i):
                if nums[j] < nums[i]:
                    tmp = max(dp[j], tmp)
            dp[i] = tmp + 1

        res = 0
        for i in range(len(dp)):
            res = max(dp[i], res)

        return res


solu = Solution()
data = [10, 9, 2, 5, 3, 7, 101, 18]
data = [0, 1, 0, 3, 2, 3]
data = [7, 7, 7, 7, 7, 7, 7]
res = solu.lengthOfLIS(data)
print(res)
