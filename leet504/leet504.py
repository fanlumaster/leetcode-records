class Solution:
    def convertToBase7(self, num: int) -> str:
        res = ''
        flag = True
        if num < 0:
            flag = False
            num = -num
        while num >= 7:
            res += str(num % 7)
            num = num // 7
        if num:
            res += str(num)
        return res[::-1] if flag else '-' + res[::-1]


if __name__ == '__main__':
    s = Solution()
    print(s.convertToBase7(100))
    print(s.convertToBase7(-7))
