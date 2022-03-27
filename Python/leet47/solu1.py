from typing import List


class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        self.curRes = []
        self.res = []
        self.used = [False] * len(nums)
        nums.sort()

        def backtrack(nums: List[int]):
            if len(self.curRes) == len(nums):
                self.res.append(self.curRes.copy())

            for i in range(len(nums)):
                if self.used[i]:
                    continue
                if i > 0 and nums[i] == nums[i - 1] and not self.used[i - 1]:
                    continue
                self.curRes.append(nums[i])
                self.used[i] = True
                backtrack(nums)
                self.used[i] = False
                self.curRes.pop()

        backtrack(nums)
        return self.res


if __name__ == "__main__":
    s = Solution()
    # print(s.permuteUnique([1, 1, 2]))
    print(s.permuteUnique([3, 3, 0, 3]))
