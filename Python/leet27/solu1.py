from typing import List


class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        p = 0
        for i in range(len(nums)):
            if nums[i] == val:
                continue
            else:
                nums[p] = nums[i]
                p += 1
        return p


if __name__ == "__main__":
    solu = Solution()
    nums = [3, 2, 2, 3]
    val = 3
    nums = [0,1,2,2,3,0,4,2]
    val = 2
    res = solu.removeElement(nums, val)
    print(nums[:res])
