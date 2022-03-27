from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.curRes = []
        self.res = []
        self.trackSum = 0
        candidates.sort()

        def backtrack(start: int, nums: List[int], target: int):
            if self.trackSum == target:
                self.res.append(self.curRes.copy())
            if self.trackSum > target:
                return

            for i in range(start, len(nums)):
                self.curRes.append(nums[i])
                self.trackSum += nums[i]
                backtrack(i, nums, target)
                self.trackSum -= nums[i]
                self.curRes.pop()

        backtrack(0, candidates, target)
        return self.res


if __name__ == '__main__':
    s = Solution()
    print(s.combinationSum([2, 7, 6, 3, 5, 1], 9))
