'''
用贪心的方法，实际上是不行的。
此方法错误
'''

from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 1
        res = 1
        for i in range(len(nums)):
            tmpRes = 1
            curValue = nums[i]
            for j in range(i + 1, len(nums)):
                if nums[j] > curValue:
                    curValue = nums[j]
                    tmpRes += 1


solu = Solution()
data = [10, 9, 2, 5, 3, 7, 101, 18]
data = [0, 1, 0, 3, 2, 3]
# data = [7, 7, 7, 7, 7, 7, 7]
res = solu.lengthOfLIS(data)
print(res)
