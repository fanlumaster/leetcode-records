from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = [[]]
        for num in nums:
            res += [item + [num] for item in res]
        return res


if __name__ == '__main__':
    solu = Solution()
    print(solu.subsets([1, 2, 3]))
