from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res = []

        def backtrack(curRes: List, startIndex: int):
            self.res.append(curRes.copy())
            for i in range(startIndex, len(nums)):
                curRes += [nums[i]]
                backtrack(curRes, i + 1)
                curRes.pop()
        backtrack([], 0)
        return self.res


if __name__ == '__main__':
    solu = Solution()
    print(solu.subsets([1, 2, 3]))
