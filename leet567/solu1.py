class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        need = {}
        window = {}
        for each in s1:
            need[each] = 1 if (each not in need) else (need[each] + 1)
            window[each] = 0

        left = 0
        right = 0
        valid = 0

        while right < len(s2):
            curChar = s2[right]
            right += 1
            if curChar in need:
                window[curChar] += 1
                if window[curChar] == need[curChar]:
                    valid += 1

            # 开始滑动
            while right - left >= len(s1):
                if valid == len(need):
                    return True

                leftChar = s2[left]
                left += 1
                if leftChar in need:
                    window[leftChar] -= 1
                    if window[leftChar] == need[leftChar] - 1:
                        valid -= 1

        return False


solu = Solution()
s1 = 'ab'
s2 = 'eidbaooo'
s1 = "ab"
s2 = "eidboaoo"
s1 = "hello"
s2 = "ooolleoooleh"
s1 = "abcdxabcde"
s2 = "abcdeabcdx"
print(solu.checkInclusion(s1, s2))
