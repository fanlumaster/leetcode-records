# 滑动窗口

from operator import ne


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        need = {}
        window = {}
        for each in t:
            need[each] = 1 if (each not in need) else (need[each] + 1)
            window[each] = 0

        left = 0
        right = 0
        valid = 0
        resStart = 0
        resLength = float('inf')
        # 开始遍历
        while right < len(s):
            curChar = s[right]
            right += 1
            if curChar in need:
                window[curChar] += 1
                if window[curChar] == need[curChar]:
                    valid += 1
            # 开始滑动窗口
            while valid == len(need) and left < right:
                if resLength > right - left:
                    resStart = left
                    resLength = right - left
                # 移动左指针
                leftChar = s[left]
                left += 1
                if leftChar in need:
                    window[leftChar] -= 1
                    if window[leftChar] < need[leftChar]:
                        valid -= 1
        return '' if resLength == float('inf') else s[resStart:resStart + resLength]


solu = Solution()
s = "ADOBECODEBANC"
t = "ABC"
res = solu.minWindow(s, t)
print(res)
