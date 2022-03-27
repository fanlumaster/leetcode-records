from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        need = {}
        window = {}
        for each in p:
            need[each] = 1 if (each not in need) else (need[each] + 1)
            window[each] = 0

        left = 0
        right = 0
        valid = 0
        res = []

        while right < len(s):
            curChar = s[right]
            right += 1
            if curChar in need:
                window[curChar] += 1
                if window[curChar] == need[curChar]:
                    valid += 1

            while right - left >= len(p):
                if valid == len(need):
                    res.append(left)
                leftChar = s[left]
                left += 1
                if leftChar in need:
                    window[leftChar] -= 1
                    if window[leftChar] == need[leftChar] - 1:
                        valid -= 1

        return res


solu = Solution()
s = "cbaebabacd"
p = "abc"
s = "abab"
p = "ab"
print(solu.findAnagrams(s, p))
