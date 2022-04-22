grid = [[1, 3, 1], [1, 5, 1], [4, 2, 1]]

print(grid)

print(grid[:2])

grid = [[1, 3]]
print([grid[i][:len(grid[0]) - 1] for i in range(len(grid))])

# print(grid[-1][-1])
