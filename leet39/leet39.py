from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def dfs(candidates: List[int], target: int, path: List[int], res: List[List[int]]) -> None:
            if target == 0:
                res.append(path)
                return
            for i in range(len(candidates)):
                if target - candidates[i] < 0:
                    break
                dfs(candidates[i:], target - candidates[i],
                    path + [candidates[i]], res)

        res = []
        candidates.sort()
        dfs(candidates, target, [], res)
        return res


if __name__ == '__main__':
    s = Solution()
    print(s.combinationSum([2, 7, 6, 3, 5, 1], 9))
