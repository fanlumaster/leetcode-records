from typing import List


class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        if len(envelopes) == 1:
            return 1

        envelopes.sort(key=lambda x: (x[0], -x[1]))
        data = [item[1] for item in envelopes]
        top = [0] * len(data)
        piles = 0
        for i in range(len(data)):
            cur = data[i]
            left = 0
            right = piles
            # 二分查找最左边的大于 cur 的元素的位置
            while left < right:
                mid = left + (right - left) // 2
                if top[mid] > cur:
                    right = mid
                elif top[mid] < cur:
                    left = mid + 1
                elif top[mid] == cur:
                    right = mid
            top[left] = cur
            if left == piles:
                piles += 1

        return piles


solu = Solution()
envelopes = [[5, 4], [6, 4], [6, 7], [2, 3]]
envelopes = [[1, 1], [1, 1], [1, 1]]
res = solu.maxEnvelopes(envelopes)
print(res)
