from typing import List


class Solution:
    def generateNext(self, needle: List[int]) -> List[int]:
        next = [0 for _ in range(len(needle))]
        i = 1
        j = 0
        while i < len(needle):
            while j > 0 and needle[j] != needle[i]:
                j = next[j - 1]
            if needle[j] == needle[i]:
                j += 1
            next[i] = j
            i += 1
        return next

    def kmp(self, needle: List[int], haystack: List[int]) -> int:
        next = self.generateNext(needle)
        i = 0
        j = 0
        while i < len(haystack):
            while j > 0 and needle[j] != haystack[i]:
                j = next[j - 1]
            if needle[j] == haystack[i]:
                j += 1
            if j == len(needle):
                return i - j + 1
            i += 1
        return -1

    def canChoose(self, groups: List[List[int]], nums: List[int]) -> bool:
        for i in range(len(groups)):
            curNeedle = groups[i]
            index = self.kmp(needle=curNeedle, haystack=nums)
            if index == -1:
                return False
            nums = nums[index + len(curNeedle):]
        return True


if __name__ == "__main__":
    solu = Solution()
    # Case 1
    groups = [[1, -1, -1], [3, -2, 0]]
    nums = [1, -1, 0, 1, -1, -1, 3, -2, 0]
    # Case 2
    groups = [[10, -2], [1, 2, 3, 4]]
    nums = [1, 2, 3, 4, 10, -2]
    # Case 3
    groups = [[1, 2, 3], [3, 4]]
    nums = [7, 7, 1, 2, 3, 4, 7, 7]
    res = solu.canChoose(groups, nums)
    print(res)
