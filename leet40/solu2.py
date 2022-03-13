from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        self.curRes = []
        self.res = []
        self.trackSum = 0
        candidates.sort()

        def backtrack(start: int, candidates: List[int], target):
            if self.trackSum == target:
                self.res.append(self.curRes.copy())
                return
            if self.trackSum > target:
                return

            for i in range(start, len(candidates)):
                # 除去重复元素的情况
                if i > start and candidates[i] == candidates[i - 1]:
                    continue
                self.curRes.append(candidates[i])
                self.trackSum += candidates[i]
                backtrack(i + 1, candidates, target)
                self.trackSum -= candidates[i]
                self.curRes.pop()

        backtrack(0, candidates, target)
        return self.res


if __name__ == "__main__":
    s = Solution()
    print(s.combinationSum2([10, 1, 2, 7, 6, 1, 5], 8))
    # print(s.combinationSum2([2, 5, 2, 1, 2], 5))
    # print(s.combinationSum2([2, 5, 2, 1, 2], 6))
