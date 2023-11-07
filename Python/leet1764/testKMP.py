from typing import List


def generateNext(needle: List[int]) -> List[int]:
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


def kmp(haystack: List[int], needle: List[int]) -> int:
    next = generateNext(needle)
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


# needle = [1, 2, 3, 5, 2, 1, 2, 1, 2, 3]
# next = generateNext(needle)
# print(next)

haystack = [1, 2, 3, 5, 2, 1, 2, 1, 2, 3]
needle = [5, 2, 1]
res = kmp(haystack, needle)
print(res)
