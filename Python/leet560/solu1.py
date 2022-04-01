# 时间复杂度不够要求
from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res = 0
        # nums.length >= 1
        preSum = [0] * (len(nums) + 1)
        for i in range(1, len(nums) + 1):
            preSum[i] = preSum[i - 1] + nums[i - 1]
        for i in range(1, len(nums) + 1):
            for j in range(i, len(nums) + 1):
                cur = preSum[j] - preSum[i - 1]
                if cur == k:
                    res += 1

        return res


solu = Solution()
nums = [1, 1, 1]
k = 2
nums = [1, 2, 3]
k = 3
res = solu.subarraySum(nums, k)
print(res)
