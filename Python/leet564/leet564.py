from json.encoder import INFINITY


class Solution:
    def nearestPalindromic(self, n: str) -> str:
        if len(n) == 1:
            return str(int(n) - 1)
        length = len(n)
        candidates = []
        half = n[:length//2]
        x0 = int(n[:length//2 + length % 2])
        candidates.append(str(x0) + half[::-1])
        if x0 % 10 != 9:
            x1 = int(n[:length//2 + length % 2]) + 1
            if len(n) % 2 == 0:
                half = str(x1)
            candidates.append(str(x1) + half[::-1])
        if x0 % 10 != 0:
            x2 = int(n[:length//2 + length % 2]) - 1
            if len(n) % 2 == 0:
                half = str(x2)
            candidates.append(str(x2) + half[::-1])
        candidates.append('9' * length)
        candidates.append('9' * (length - 1))
        candidates.append('1' + '0' * (length - 1) + '1')
        print(candidates)
        return min(candidates, key=lambda x: (abs(int(x) - int(n) or float('inf')), int(x)))


if __name__ == '__main__':
    s = Solution()
    print(s.nearestPalindromic('123'))
    print(s.nearestPalindromic('101'))
    print(s.nearestPalindromic('88'))
    print(s.nearestPalindromic('99'))
    print(s.nearestPalindromic('1283'))
    print(s.nearestPalindromic('111111111'))
