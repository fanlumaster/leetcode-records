'''
This solution is not suitable for this problem, cause in this problem, it defines that
subarray must be constitude.
'''

from typing import List


class Solution:
    def canChoose(self, groups: List[List[int]], nums: List[int]) -> bool:
        groupsList = []
        for i in range(len(groups)):
            for j in range(len(groups[i])):
                groupsList.append(groups[i][j])
        groupsPointer = 0
        numsPointer = 0
        while (numsPointer < len(nums) and groupsPointer < len(groupsList)):
            if (groupsList[groupsPointer] == nums[numsPointer]):
                groupsPointer += 1
                numsPointer += 1
            else:
                numsPointer += 1
        if (groupsPointer == len(groupsList)):
            return True

        return False


if __name__ == "__main__":
    solu = Solution()
    # Case 1
    groups = [[1, -1, -1], [3, -2, 0]]
    nums = [1, -1, 0, 1, -1, -1, 3, -2, 0]
    # Case 2
    groups = [[10, -2], [1, 2, 3, 4]]
    nums = [1, 2, 3, 4, 10, -2]
    # Case 3
    groups = [[1, 2, 3], [3, 4]]
    nums = [7, 7, 1, 2, 3, 4, 7, 7]
    res = solu.canChoose(groups, nums)
    print(res)
