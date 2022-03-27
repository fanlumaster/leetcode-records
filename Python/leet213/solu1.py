'''
原来思路很简单。和简单版本的打家劫舍是一样的。
只需要考虑去头或者去尾的情况即可。
'''

from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        dp1 = [0] * (len(nums) + 1)
        dp2 = [0] * (len(nums) + 1)
        numsExclueHead = nums[1:]
        numsExcludeTail = nums[:-1]

        for i in range(len(numsExclueHead) - 1, -1, -1):
            dp1[i] = max(dp1[i + 1], numsExclueHead[i] + dp1[i + 2])

        for i in range(len(numsExcludeTail) - 1, -1, -1):
            dp2[i] = max(dp2[i + 1], numsExcludeTail[i] + dp2[i + 2])

        return max(dp1[0], dp2[0])


solu = Solution()
nums = [2, 3, 2]
nums = [1, 2, 3, 1]
res = solu.rob(nums)
print(res)
