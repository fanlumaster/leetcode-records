'''
Not AC。
时间超出显示。
果然不能简单暴力解决。
'''

from typing import List


class Solution:
    def platesBetweenCandles(self, s: str, queries: List[List[int]]) -> List[int]:
        res = [0] * len(queries)
        for index in range(len(queries)):
            sub_str = s[queries[index][0]:queries[index][1] + 1]
            left, right = 0, len(sub_str) - 1
            for i in range(len(sub_str)):
                if sub_str[i] == '*':
                    left += 1
                else:
                    break
            for i in range(len(sub_str) - 1, -1, -1):
                if sub_str[i] == '*':
                    right -= 1
                else:
                    break
            if left < right:
                res[index] = sub_str[left:right+1].count('*')

        return res


if __name__ == '__main__':
    solu = Solution()
    str1 = "**|**|***|"
    print(solu.platesBetweenCandles(str1, [[2, 5], [5, 9]]))
