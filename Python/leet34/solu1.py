from typing import List

'''
可以利用二分查找，分别从找出左边和右边的等于 target 的值
'''


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        res = [-1, -1]
        if not nums:
            return res
        if len(nums) == 1:
            return [0, 0] if nums[0] == target else res

        def binary_search_left(nums, target):
            '''
            寻找左边界
            '''
            res = -1
            if not nums:
                return res
            left = 0
            right = len(nums) - 1
            while left < right:
                mid = (left + right) // 2
                if nums[mid] == target:
                    res = mid
                    right = mid
                elif nums[mid] > target:
                    right = mid
                else:
                    left = mid + 1
            return left if nums[left] == target else res

        def binary_search_right(nums, target):
            '''
            二分查找最右边的符合条件的元素
            '''
            res = -1
            if not nums:
                return res
            left = 0
            right = len(nums) - 1
            while left < right:
                mid = (left + right) // 2
                if nums[mid] == target:
                    res = mid
                    left = mid + 1
                elif nums[mid] > target:
                    right = mid
                else:
                    left = mid + 1
            return left if nums[left] == target else res

        res[0] = binary_search_left(nums, target)
        res[1] = binary_search_right(nums, target)
        return res


if __name__ == "__main__":
    solu = Solution()
    print(solu.searchRange([5, 7, 7, 8, 8, 10], 8))
