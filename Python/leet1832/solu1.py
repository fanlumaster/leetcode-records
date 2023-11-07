class Solution:
    def checkIfPangram(self, sentence: str) -> bool:
        mySet = set()
        for c in sentence:
            if c >= 'a' and c <= 'z':
                mySet.add(c)
                if len(mySet) == 26:
                    return True
            else:
                return False
        return False


if __name__ == "__main__":
    solu = Solution()
    sentence = 'thequickbrownfoxjumpsoverthelazydog'
    sentence = 'leetcode'
    res = solu.checkIfPangram(sentence)
    print(res)
