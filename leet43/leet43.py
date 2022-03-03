class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        if int(num1) == 0 or int(num2) == 0:
            return '0'
        num1 = num1[::-1]
        num2 = num2[::-1]
        numRes = (len(num1) + len(num2) + 1) * [0]
        for i in range(len(num1)):
            for j in range(len(num2)):
                numRes[i + j] += int(num1[i]) * int(num2[j]) % 10
                numRes[i + j + 1] += int(num1[i]) * int(num2[j]) // 10
        for i in range(len(numRes)):
            if numRes[i] >= 10:
                numRes[i + 1] += numRes[i] // 10
                numRes[i] %= 10
        numRes = numRes[::-1]
        index = 0
        for i in range(len(numRes)):
            if numRes[i] != 0:
                index = i
                break
        numRes = numRes[index:]
        res = ''
        for i in numRes:
            res += str(i)
        return res


if __name__ == '__main__':
    s = Solution()
    # print(s.multiply('123', '12'))
    # print(123 * 12)
    # print(s.multiply('99', '999'))
    # print(999 * 99)
    # print(s.multiply('9999', '99'))
    # print(9999 * 99)
    # print(s.multiply('9999', '999'))
    # print(9999 * 999)
    print(s.multiply('99999999999999999999999999999999999999999999999999999999999999999999999999999',
          '999999999999999999999999999999999999999999999999999999999999999999999999999'))
    print(99999999999999999999999999999999999999999999999999999999999999999999999999999 *
          999999999999999999999999999999999999999999999999999999999999999999999999999)
    print(s.multiply('0', '0'))
