from typing import List


class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        M = len(matrix)  # 行数
        N = len(matrix[0])  # 列数
        self.preSum = [[0] * (N + 1)
                       for _ in range(M + 1)]
        # 先每一行相加
        for i in range(M):
            for j in range(N):
                self.preSum[i + 1][j + 1] = \
                    self.preSum[i + 1][j] + matrix[i][j]
        # 然后每一列相加
        for i in range(M):
            for j in range(N):
                self.preSum[i + 1][j + 1] += self.preSum[i][j + 1]

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        res = self.preSum[row2 + 1][col2 + 1] - \
            self.preSum[row1][col2 + 1] - \
            self.preSum[row2 + 1][col1] + \
            self.preSum[row1][col1]

        return res


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)
matrix = matrix = [[3, 0, 1, 4, 2],
                   [5, 6, 3, 2, 1],
                   [1, 2, 0, 1, 5],
                   [4, 1, 0, 1, 7],
                   [1, 0, 3, 0, 5]]
obj = NumMatrix(matrix)
# print(obj.preSum)
# for i in range(0, len(obj.preSum)):
#     print(obj.preSum[i])
row1, col1, row2, col2 = [2, 1, 4, 3]
res = obj.sumRegion(row1, col1, row2, col2)
print(res)
