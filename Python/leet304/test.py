matrix = [[3, 0, 1, 4, 2],
          [5, 6, 3, 2, 1],
          [1, 2, 0, 1, 5],
          [4, 1, 0, 1, 7],
          [1, 0, 3, 0, 5]]

preSum = [[0] * (len(matrix[0]) + 1)
          for _ in range(len(matrix) + 1)]
print(preSum)
