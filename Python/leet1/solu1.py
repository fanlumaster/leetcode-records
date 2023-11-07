'''
暴力方法
'''
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
        return []


if __name__ == '__main__':
    solu = Solution()
    nums = [3, 2, 4]
    target = 6
    ans = solu.twoSum(nums, target)
    print(ans)
