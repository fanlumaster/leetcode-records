from typing import List


class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        self.curRes = []
        self.res = []
        self.trackSum = 0
        self.trackCount = 0

        def backtrack(start: int, k: int, n: int):
            if self.trackSum == n and self.trackCount == k:
                self.res.append(self.curRes.copy())

            if self.trackSum > n or self.trackCount > k:
                return

            for i in range(start, 10):
                self.curRes.append(i)
                self.trackSum += i
                self.trackCount += 1
                backtrack(i + 1, k, n)
                self.trackCount -= 1
                self.trackSum -= i
                self.curRes.pop()

        backtrack(1, k, n)
        return self.res


if __name__ == "__main__":
    solu = Solution()
    print(solu.combinationSum3(3, 7))
    print(solu.combinationSum3(3, 9))
