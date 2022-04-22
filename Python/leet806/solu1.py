from typing import List


class Solution:
    def numberOfLines(self, widths: List[int], s: str) -> List[int]:
        res = [0] * 2
        sum = 0
        lines = 1
        for each in s:
            curLen = widths[ord(each) - 97]
            if sum + curLen > 100 * lines:
                sum = 100 * lines + curLen
                lines += 1
            elif sum + curLen == 100 * lines:
                sum += curLen
                lines += 1
            else:
                sum += curLen
        res[0] = lines
        res[1] = sum % 100
        if res[1] == 0:
            res[0] -= 1
            res[1] = 100
        return res


solu = Solution()
widths = [4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
          10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10]
S = "bbbcccdddaaa"
widths = [10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
          10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10]
S = "abcdefghijklmnopqrstuvwxyz"
widths = [3, 4, 10, 4, 8, 7, 3, 3, 4, 9, 8, 2,
          9, 6, 2, 8, 4, 9, 9, 10, 2, 4, 9, 10, 8, 2]
S = "mqblbtpvicqhbrejb"
res = solu.numberOfLines(widths, S)
print(res)
