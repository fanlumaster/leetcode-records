import random

matrix = [[3, 0, 1, 4, 2],
          [5, 6, 3, 2, 1],
          [1, 2, 0, 1, 5],
          [4, 1, 0, 1, 7],
          [1, 0, 3, 0, 5]]

preSum = [[0] * (len(matrix[0]) + 1)
          for _ in range(len(matrix) + 1)]
print(preSum)
for i in range(len(preSum)):
    for j in range(len(preSum[0])):
        preSum[i][j] = random.randint(1, 26)

print(preSum)
