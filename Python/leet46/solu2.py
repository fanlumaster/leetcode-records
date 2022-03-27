from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        self.curRes = []
        self.used = [False] * len(nums)

        def backtrack(nums: List[int]):
            if len(self.curRes) == len(nums):
                self.res.append(self.curRes.copy())
            for i in range(len(nums)):
                if self.used[i]:
                    continue
                self.curRes.append(nums[i])
                self.used[i] = True
                backtrack(nums)
                self.used[i] = False
                self.curRes.pop()

        backtrack(nums)
        return self.res


if __name__ == '__main__':
    s = Solution()
    print(s.permute([1, 2, 3]))
