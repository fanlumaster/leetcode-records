# 使用哈希表进行优化
from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res = 0
        preSum = {}
        preSum[0] = 1
        curSum = 0
        for i in range(len(nums)):
            curSum += nums[i]
            a = curSum - k
            if a in preSum:
                res += preSum[a]
            preSum[curSum] = preSum[curSum] + 1 if curSum in preSum else 1

        return res


solu = Solution()
nums = [1, 1, 1]
k = 2
nums = [1, 2, 3]
k = 3
res = solu.subarraySum(nums, k)
print(res)
