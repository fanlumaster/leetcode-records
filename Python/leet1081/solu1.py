class Solution:
    def smallestSubsequence(self, s: str) -> str:
        res = []
        isAdded = {}
        myDict = {}
        for i in range(len(s)):
            isAdded[s[i]] = False
            if s[i] in myDict:
                myDict[s[i]] += 1
            else:
                myDict[s[i]] = 1
        for i in range(len(s)):
            if len(res) == 0:
                res.append(s[i])
                isAdded[s[i]] = True
                myDict[s[i]] -= 1
            elif isAdded[s[i]] == False:
                while len(res) != 0 and s[i] < res[-1] and myDict[res[-1]] > 0:
                    tmp = res.pop()
                    isAdded[tmp] = False
                res.append(s[i])
                isAdded[s[i]] = True
                myDict[s[i]] -= 1
            else:
                myDict[s[i]] -= 1
        res = ''.join(res)
        return res
