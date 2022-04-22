'''
主要是找规律
旋转一次后加什么，减什么
'''

from typing import List
# 4 3 2 6
# 6 4 3 2
# 2 6 4 3
# 3 2 6 4


class Solution:
    def maxRotateFunction(self, nums: List[int]) -> int:
        N = len(nums)
        res = 0
        sum = 0
        for i in range(N):
            sum += nums[i]  # 计算数组总和

        for i in range(N):
            res += i * nums[i]

        tmp = res
        for i in range(0, N - 1):
            tmp = tmp - nums[N - 1 - i] * \
                (N - 1) + nums[i] + (sum - nums[N - 1 - i] - nums[i])
            if tmp > res:
                res = tmp

        return res


solu = Solution()
nums = [4, 3, 2, 6]
res = solu.maxRotateFunction(nums)
print(res)
