from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        myset = set()
        res = ''
        for i in range(1, len(strs[0]) + 1):
            for each in strs:
                myset.add(each[:i])
            if len(myset) > 1:
                break
            res = myset.pop()

        return res


solu = Solution()
strs = ["flower", "flow", "flight"]
strs = ["dog", "racecar", "car"]
strs = ["flower", "flower", "flower", "flower"]
res = solu.longestCommonPrefix(strs)
print(res)
