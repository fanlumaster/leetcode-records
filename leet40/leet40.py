from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        def dfs(candidates: List[int], target: int, path: List[int], res: List[List[int]]) -> None:
            if target == 0:
                res.append(path)
                return
            for i in range(len(candidates)):
                if target - candidates[i] < 0:
                    break
                if i > 0 and candidates[i] == candidates[i - 1]:
                    continue
                dfs(candidates[i + 1:], target - candidates[i],
                    path + [candidates[i]], res)

        res = []
        candidates.sort()
        dfs(candidates, target, [], res)
        return res


if __name__ == '__main__':
    s = Solution()
    print(s.combinationSum2([10, 1, 2, 7, 6, 1, 5], 8))
    print(s.combinationSum2([2, 5, 2, 1, 2], 5))
    print(s.combinationSum2([2, 5, 2, 1, 2], 6))
