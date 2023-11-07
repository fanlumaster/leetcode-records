from typing import List

'''
brute-force, dfs, then filter
'''
class Solution:
    def __init__(self) -> None:
        self.res = []

    def isValid(self, s):
        stack = []
        for c in s:
            if c == "(":
                stack.append(")")
            elif len(stack) == 0 or stack.pop() != c:
                return False

        return len(stack) == 0

    def recurse(self, curS: str, n: int):
        if n == 0:
            # print(curS)
            if self.isValid(curS):
                self.res.append(curS)
            return

        self.recurse(curS + "(", n - 1)
        self.recurse(curS + ")", n - 1)

    def generateParenthesis(self, n: int) -> List[str]:
        newN = n * 2
        self.recurse("", newN)
        return self.res


if __name__ == "__main__":
    solu = Solution()
    n = 3
    n = 1
    n = 2
    res = solu.generateParenthesis(n)
    print(res)
