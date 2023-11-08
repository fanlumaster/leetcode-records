class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # 开始的边界条件判断
        if len(s) == 1:
            return 1
        window = {}
        setS = set(s)
        # 边界条件判断
        if len(setS) == len(s):
            return len(s)
        for each in setS:
            window[each] = 0

        left = 0
        right = 0
        resLength = 0

        while right < len(s):
            curChar = s[right]
            right += 1
            window[curChar] += 1
            while window[curChar] > 1:
                if right - left > resLength:
                    resLength = right - left - 1
                leftChar = s[left]
                left += 1
                window[leftChar] -= 1

        # 最后的边界条件判断
        if right - left > resLength:
            resLength = right - left

        return resLength


solu = Solution()
s = "abcabcbb"
s = "bbbbb"
s = "pwwkew"
res = solu.lengthOfLongestSubstring(s)
print(res)
