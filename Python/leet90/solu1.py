from typing import List


class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        self.curRes = []
        nums.sort()

        def backtrack(start: int, nums: List[int]):
            self.res.append(self.curRes.copy())

            for i in range(start, len(nums)):
                if i > start and nums[i] == nums[i - 1]:
                    continue
                self.curRes.append(nums[i])
                backtrack(i + 1, nums)
                self.curRes.pop()

        backtrack(0, nums)
        return self.res


if __name__ == "__main__":
    s = Solution()
    print(s.subsetsWithDup([1, 2, 2]))
