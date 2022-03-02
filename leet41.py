from typing import List


class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        if not nums:
            return 1

        for i in range(len(nums)):
            if nums[i] <= 0:
                nums[i] = len(nums) + 1

        for i in range(len(nums)):
            num = abs(nums[i])
            if num > 0 and num <= len(nums):
                nums[num - 1] = -abs(nums[num - 1])

        for i in range(len(nums)):
            if nums[i] > 0:
                return i + 1

        return len(nums) + 1


if __name__ == '__main__':
    s = Solution()
    print(s.firstMissingPositive([1, 2, 0]))
    print(s.firstMissingPositive([3, 4, -1, 1]))
    print(s.firstMissingPositive([7, 8, 9, 11, 12]))
    print(s.firstMissingPositive([1, 2, 0]))
    print(s.firstMissingPositive([1, 2, 3]))
    print(s.firstMissingPositive([1, 2, 3, 4]))
    print(s.firstMissingPositive([1, 2, 3, 4, 5]))
