class Solution:
    def minWindow(self, s: str, t: str) -> str:
        need = {}
        myWindow = {}
        sSet = set(s)
        tSet = set(t)
        for each in sSet:
            myWindow[each] = 0
        for each in tSet:
            need[each] = 0
        for each in t:
            need[each] += 1

        left = 0
        right = 0
        valid = 0  # 已经找到的符合条件的字符数
        start = 0
        length = float('inf')

        while right < len(s):
            # c 是将移入窗口的字符
            c = s[right]
            # 移动右指针
            right += 1
            # 进行窗口内数据的一系列更新
            if c in need:
                myWindow[c] += 1
                if myWindow[c] == need[c]:
                    valid += 1

            # 判断左侧窗口是否要收缩
            while valid == len(need):
                # 在这里更新覆盖子串
                if right - left < length:
                    start = left
                    length = right - left
                # d 是将移出窗口的字符
                d = s[left]
                # 移动左指针
                left += 1
                if d in need:
                    if myWindow[d] == need[d]:
                        valid -= 1
                    myWindow[d] -= 1

        print(length)
        return "" if length == float('inf') else s[start:start + length]


if __name__ == "__main__":
    s = Solution()
    # print(s.minWindow("ADOBECODEBANC", "ABC"))
    print(s.minWindow('a', 'aa'))
