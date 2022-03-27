from typing import List, Optional


class Solution:
    def findNext(self, board: List[List[str]]) -> Optional[int]:
        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    return i, j
        return -1, -1

    def isValid(self, board: List[List[str]], i: int, j: int, num: str) -> bool:
        for row in range(9):
            if board[row][j] == num:
                return False
        for col in range(9):
            if board[i][col] == num:
                return False
        for row in range(i // 3 * 3, i // 3 * 3 + 3):
            for col in range(j // 3 * 3, j // 3 * 3 + 3):
                if board[row][col] == num:
                    return False
        return True

    def solveSudokuHelper(self, board, i=0, j=0):
        i, j = self.findNext(board)
        if i == -1:
            return True
        for num in range(1, 10):
            if self.isValid(board, i, j, str(num)):
                board[i][j] = str(num)
                if self.solveSudokuHelper(board, i, j):
                    return True
                board[i][j] = '.'
        return False

    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.solveSudokuHelper(board)
        return


board = [["5", "3", ".", ".", "7", ".", ".", ".", "."],
         ["6", ".", ".", "1", "9", "5", ".", ".", "."],
         [".", "9", "8", ".", ".", ".", ".", "6", "."],
         ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
         ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
         ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
         [".", "6", ".", ".", ".", ".", "2", "8", "."],
         [".", ".", ".", "4", "1", "9", ".", ".", "5"],
         [".", ".", ".", ".", "8", ".", ".", "7", "9"]]

Solution().solveSudoku(board)

print(board)
