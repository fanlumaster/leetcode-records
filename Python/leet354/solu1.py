from typing import List
from functools import cmp_to_key


class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if len(envelopes) == 1:
            return 1

        def cmp(x: List[int], y: List[int]):
            if x[0] < y[0]:
                return -1
            if x[0] > y[0]:
                return 1
            if x[0] == y[0]:
                if x[1] > y[1]:
                    return -1
                else:
                    return 1
        envelopes.sort(key=cmp_to_key(cmp))
        data = [item[1] for item in envelopes]
        dp = [0] * len(data)
        dp[0] = 1
        for i in range(1, len(data)):
            temp = 0
            for j in range(i):
                if data[j] < data[i]:
                    temp = max(temp, dp[j])
            temp += 1
            dp[i] = temp
        res = max(dp)
        return res


solu = Solution()
envelopes = [[5, 4], [6, 4], [6, 7], [2, 3]]
envelopes = [[1, 1], [1, 1], [1, 1]]
res = solu.maxEnvelopes(envelopes)
print(res)
