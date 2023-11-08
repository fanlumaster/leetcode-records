from typing import List

class Solution:
    def __init__(self) -> None:
        self.ans = []

    def isValid(self, s: str) -> bool:
        """
        判断一个括号字符串是否满足合法的括号的规则
        """
        count = 0
        for c in s:
            if c == '(':
                count += 1
            elif c == ')':
                if count <= 0:
                    return False
                else:
                    count -= 1
        return count == 0

    def helper(self, s: str, start: int, lRemove: int, rRemove: int):
        if (lRemove == 0 and rRemove == 0):
            if (self.isValid(s)):
                self.ans.append(s)
            return
        for i in range(start, len(s)):
            if (len(s) - start < (lRemove + rRemove)):
                return
            if (i != start and s[i] == s[i - 1]):
                continue
            # 尝试删除左括号
            if s[i] == '(':
                self.helper(s[:i] + s[i+1:], i, lRemove - 1, rRemove)
            elif s[i] == ')':
                self.helper(s[:i] + s[i+1:], i, lRemove, rRemove - 1)

    def removeInvalidParentheses(self, s: str) -> List[str]:
        lRemove = 0
        rRemove = 0
        for c in s:
            if c == ')':
                if (lRemove == 0):
                    rRemove += 1
                else:
                    lRemove -= 1
            elif c == '(':
                lRemove += 1
        self.helper(s, 0, lRemove, rRemove)

        return self.ans


"""
示例 1：
输入：s = "()())()"
输出：["(())()","()()()"]

示例 2：
输入：s = "(a)())()"
输出：["(a())()","(a)()()"]

示例 3：
输入：s = ")("
输出：[""]
"""

solu = Solution()
s = "()())()"
ans = solu.removeInvalidParentheses(s)
print(ans)
solu.ans.clear()

s = "(a)())()"
ans = solu.removeInvalidParentheses(s)
print(ans)
solu.ans.clear()

s = ")("
ans = solu.removeInvalidParentheses(s)
print(ans)
solu.ans.clear()
