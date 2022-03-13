from typing import List


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        self.res = []
        self.curRes = []

        def backtrack(start: int, n: int, k: int):
            if (len(self.curRes) == k):
                self.res.append(self.curRes.copy())
                return
            for i in range(start, n + 1):
                self.curRes.append(i)
                backtrack(i + 1, n, k)
                self.curRes.pop()

        backtrack(1, n, k)
        return self.res


if __name__ == '__main__':
    solu = Solution()
    print(solu.combine(4, 2))
