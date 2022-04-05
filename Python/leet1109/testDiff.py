from typing import List


class DiffArray:
    '''
    差分数组辅助类
    '''

    def __init__(self, nums: List[int]) -> None:
        N = len(nums)
        self.diff = [0] * N
        self.diff[0] = nums[0]
        for i in range(1, N):
            self.diff[i] = nums[i] - nums[i - 1]

    def operateRange(self, beginIndex: int, endIndex: int, operateNum: int):
        '''
        在差分数组上操作
        '''
        self.diff[beginIndex] += operateNum
        if endIndex < len(self.diff) - 1:
            self.diff[endIndex + 1] -= operateNum

    def restoreArray(self):
        '''
        根据差分数组恢复原数组
        '''
        N = len(self.diff)
        res = [0] * N
        res[0] = self.diff[0]
        for i in range(1, N):
            res[i] = res[i - 1] + self.diff[i]
        return res


nums = [8, 5, 9, 6, 1]
test = DiffArray(nums)
print(test.diff)
print(test.restoreArray())
test.operateRange(1, 3, 3)
print(test.restoreArray())
