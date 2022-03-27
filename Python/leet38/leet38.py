class Solution:
    def countAndSay(self, n: int) -> str:
        if n == 1:
            return '1'
        else:
            s = self.countAndSay(n-1)
            res = ''
            count = 1
            for i in range(0, len(s)):
                if i == len(s) - 1 or s[i] != s[i+1]:
                    res += str(count) + s[i]
                    count = 1
                else:
                    count += 1
            return res


if __name__ == '__main__':
    sol = Solution()
    print(sol.countAndSay(1))
    print(sol.countAndSay(2))
    print(sol.countAndSay(3))
    print(sol.countAndSay(4))
    print(sol.countAndSay(5))
