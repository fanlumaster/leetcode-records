def findNext(board):
    for i in range(9):
        for j in range(9):
            if board[i][j] == '.':
                return i, j
    return -1, -1


def isValid(board, i, j, num):
    for row in range(9):
        if board[row][j] == num:
            return False
    for col in range(9):
        if board[i][col] == num:
            return False
    for row in range(i//3*3, i//3*3+3):
        for col in range(j//3*3, j//3*3+3):
            if board[row][col] == num:
                return False
    return True


def solveSudoku(board, i=0, j=0):
    i, j = findNext(board)
    if i == -1:
        return True
    for num in range(1, 10):
        if isValid(board, i, j, str(num)):
            board[i][j] = str(num)
            if solveSudoku(board, i, j):
                return True
            board[i][j] = '.'
    return False


def printList(board):
    for row in board:
        print(row)


board = [["5", "3", ".", ".", "7", ".", ".", ".", "."],
         ["6", ".", ".", "1", "9", "5", ".", ".", "."],
         [".", "9", "8", ".", ".", ".", ".", "6", "."],
         ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
         ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
         ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
         [".", "6", ".", ".", ".", ".", "2", "8", "."],
         [".", ".", ".", "4", "1", "9", ".", ".", "5"],
         [".", ".", ".", ".", "8", ".", ".", "7", "9"]]

printList(board)

solveSudoku(board)

print('\n\n')
printList(board)
