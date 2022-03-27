from typing import List


class Solution:
    def platesBetweenCandles(self, s: str, queries: List[List[int]]) -> List[int]:
        res = [0] * len(queries)
        preSum, preSumArray = 0, [0] * len(s)
        leftCandle, leftArray = -1, [0] * len(s)
        for i in range(len(s)):
            if s[i] == '*':
                preSum += 1
            else:
                leftCandle = i
            preSumArray[i] = preSum
            leftArray[i] = leftCandle

        rightCandle, rightArray = len(s) - 1, [0] * len(s)
        for i in range(len(s) - 1, -1, -1):
            if s[i] == '|':
                rightCandle = i
            rightArray[i] = rightCandle

        for i in range(len(queries)):
            leftIndex = rightArray[queries[i][0]]
            rightIndex = leftArray[queries[i][1]]
            if leftIndex < rightIndex:
                res[i] = preSumArray[rightIndex] - preSumArray[leftIndex]

        return res


if __name__ == '__main__':
    solu = Solution()
    str1 = "**|**|***|"
    print(solu.platesBetweenCandles(str1, [[2, 5], [5, 9]]))
