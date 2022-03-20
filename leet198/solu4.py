# 自底向上构建，优化空间复杂度

from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        res = 0
        oneStep = 0
        twoSteps = 0
        for i in range(len(nums) - 1, -1, -1):
            res = max(oneStep, nums[i] + twoSteps)
            oneStep, twoSteps = res, oneStep

        return res


solu = Solution()
nums = [1, 2, 3, 1]
# nums = [183, 219, 57, 193, 94, 233, 202, 154, 65, 240, 97, 234, 100, 249, 186, 66, 90, 238,
#         168, 128, 177, 235, 50, 81, 185, 165, 217, 207, 88, 80, 112, 78, 135, 62, 228, 247, 211]
# 这个测试用例决定了备忘录中的默认值不能是 0
# nums = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
#         0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
res = solu.rob(nums)
print(res)
