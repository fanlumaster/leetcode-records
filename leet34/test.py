
def binary_search_left(nums, target):
    '''
    二分查找最左边的符合条件的元素
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


nums = [5, 7, 8, 8, 8, 10]
res_left = binary_search_left(nums, 8)
print(res_left)
res_right = binary_search_right(nums, 8)
print(res_right)
print(binary_search_left([], 1))
