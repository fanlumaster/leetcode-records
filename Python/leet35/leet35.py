from ast import Num
from typing import List
from xml.dom import minidom


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        if target < nums[0]:
            return 0
        if target > nums[len(nums) - 1]:
            return len(nums)
        left = 0
        right = len(nums) - 1
        while left < right:
            mid = (left + right) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                right = mid
            else:
                left = mid + 1
        return left


if __name__ == "__main__":
    nums = [1, 3, 5, 6]
    target = 2
    res = Solution().searchInsert(nums, target)
    print(res)
