from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        if len(nums) == 1:
            return 0 if nums[0] == target else -1
        left = 0
        right = len(nums) - 1
        while left < right:
            mid = (left + right) // 2
            if nums[mid] == target:  # 如果中间值等于目标值，直接返回
                return mid
            elif nums[mid] > nums[right]:  # 右边有序
                if nums[left] <= target <= nums[mid]:  # 如果目标值在左边有序的区间内，则右边查找
                    right = mid
                else:  # 否则，左边查找
                    left = mid + 1
            elif nums[mid] < nums[right]:  # 左边有序
                if nums[mid] <= target <= nums[right]:  # 如果目标值在右边有序的区间内，则左边查找
                    left = mid + 1
                else:  # 否则，右边查找
                    right = mid
            else:  # nums[mid] == nums[right]
                right -= 1
        # 如果目标值等于中间值，则返回中间值的下标，否则返回-1
        return left if nums[left] == target else -1


solu = Solution()
print(solu.search([4, 5, 6, 7, 0, 1, 2], 0))  # 4
