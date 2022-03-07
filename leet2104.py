from typing import List


class Solution:
    def subArrayRanges(self, nums: List[int]) -> int:
        if not nums:
            return 0

        def subArray(nums, start, end):
            pass


if __name__ == '__main__':
    s = Solution()
    # print(s.subArrayRanges([1, 2, 3]))
    # print(s.subArrayRanges([1, 3, 3]))
    print(s.subArrayRanges([4, -2, -3, 4, 1]))
