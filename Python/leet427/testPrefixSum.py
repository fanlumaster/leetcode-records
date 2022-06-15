'''
计算二维数组的前缀和：
思想是先计算每一行的前缀和，然后从第二行开始，将每一个位置上原来的“行前缀和”给加上上面的值即可。
'''

grid = [[1, 1, 1, 1, 0, 0, 0, 0],
        [1, 1, 1, 1, 0, 0, 0, 0],
        [1, 1, 1, 1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1, 1, 1, 1],
        [1, 1, 1, 1, 0, 0, 0, 0],
        [1, 1, 1, 1, 0, 0, 0, 0],
        [1, 1, 1, 1, 0, 0, 0, 0],
        [1, 1, 1, 1, 0, 0, 0, 0]]

gridPrefixSum = [[0 for i in range(len(grid[0]))] for j in range(len(grid))]
print(gridPrefixSum)
for i in range(len(grid)):
    gridPrefixSum[i][0] = grid[i][0]
    for j in range(1, len(grid[0])):
        gridPrefixSum[i][j] += gridPrefixSum[i][j - 1] + grid[i][j]
for i in range(1, len(grid)):
    gridPrefixSum[i][0] += gridPrefixSum[i - 1][0]
    for j in range(1, len(grid[0])):
        gridPrefixSum[i][j] += gridPrefixSum[i - 1][j]
