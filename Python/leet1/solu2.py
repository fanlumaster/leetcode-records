'''
如果想更快的话，那么就用哈希表好了。
'''
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashtable = dict()
        for i in range(len(nums)):
            if target - nums[i] in hashtable:
                return [hashtable[target - nums[i]], i]
            hashtable[nums[i]] = i
        return []


if __name__ == '__main__':
    solu = Solution()
    nums = [3, 2, 4]
    target = 6
    ans = solu.twoSum(nums, target)
    print(ans)
