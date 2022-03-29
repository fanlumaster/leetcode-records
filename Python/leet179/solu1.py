# 利用排序的思想，想到了就挺简单的。

from typing import List
from functools import cmp_to_key


class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        def cmp(x: int, y: int):
            a = int(str(x) + str(y))
            b = int(str(y) + str(x))
            return b - a
        nums.sort(key=cmp_to_key(cmp))
        res = ''
        nums = [str(item) for item in nums]
        res = res.join(nums)
        if res[0] == '0':
            return "0"
        return res


solu = Solution()
data = [3, 30, 34, 5, 9]
res = solu.largestNumber(data)
print(res)
