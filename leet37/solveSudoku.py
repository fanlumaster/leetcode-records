def findNext(grid, i, j):
    for i in range(9):
        for j in range(9):
            if grid[i][j] == '.':
                return i, j
    return -1, -1


def isValid(grid, i, j, num):
    for row in range(9):
        if grid[row][j] == num:
            return False
    for col in range(9):
        if grid[i][col] == num:
            return False
    for row in range(i//3*3, i//3*3+3):
        for col in range(j//3*3, j//3*3+3):
            if grid[row][col] == num:
                return False
    return True


def solveSudoku(grid, i=0, j=0):
    i, j = findNext(grid, i, j)
    if i == -1:
        return True
    for num in range(1, 10):
        if isValid(grid, i, j, str(num)):
            grid[i][j] = str(num)
            if solveSudoku(grid, i, j):
                return True
            grid[i][j] = '.'
    return False


def printList(grid):
    for row in grid:
        print(row)


grid = [["5", "3", ".", ".", "7", ".", ".", ".", "."],
        ["6", ".", ".", "1", "9", "5", ".", ".", "."],
        [".", "9", "8", ".", ".", ".", ".", "6", "."],
        ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
        ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
        ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
        [".", "6", ".", ".", ".", ".", "2", "8", "."],
        [".", ".", ".", "4", "1", "9", ".", ".", "5"],
        [".", ".", ".", ".", "8", ".", ".", "7", "9"]]

printList(grid)

solveSudoku(grid)

print('\n\n')
printList(grid)
