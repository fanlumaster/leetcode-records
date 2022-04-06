class Solution:
    def climbStairs(self, n: int) -> int:
        if n < 3:
            return n
        first = 1
        second = 2
        res = 0
        for i in range(3, n + 1):
            res = first + second
            first = second
            second = res

        return res


solu = Solution()
n = 3
res = solu.climbStairs(n)
print(res)
