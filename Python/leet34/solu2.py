from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        res = [-1, -1]
        if not nums:
            return res
        if len(nums) == 1:
            return [0, 0] if nums[0] == target else res

        left = 0
        right = len(nums) - 1
        # 寻找左边界
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                right = mid - 1
            elif nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
        if left < len(nums) and nums[left] == target:
            res[0] = left

        # 寻找右边界
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                left = mid + 1
            elif nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
        if right > -1 and nums[right] == target:
            res[1] = right

        return res


if __name__ == "__main__":
    solu = Solution()
    print(solu.searchRange([5, 7, 7, 8, 8, 10], 8))
    # print(solu.searchRange([2, 2], 3))
    # print(solu.searchRange([2, 2], 2))
    # print(solu.searchRange([1, 3], 1))
