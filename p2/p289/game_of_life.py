from typing import List


class Solution:
    """
    Jun 16, 2025 17:41
    Time Complexity: O(mn)
    Space Complexity: O(1)
    """

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.is_live(board, i, j):
                    if board[i][j] == 0:
                        board[i][j] = 2
                else:
                    if board[i][j] == 1:
                        board[i][j] = 3

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == 3:
                    board[i][j] = 0

    def is_live(self, board: List[List[int]], i, j):
        delta_x = [-1, 0, 1]
        delta_y = [-1, 0, 1]

        count = 0
        for x in delta_x:
            for y in delta_y:
                if 0 <= i + x < len(board) and 0 <= j + y < len(board[0]) and not (x == 0 and y == 0):
                    if board[i + x][j + y] == 1 or board[i + x][j + y] == 3:
                        count += 1

        if board[i][j] == 0:
            if count == 3:
                return True
            else:
                return False
        else:
            if count < 2 or count > 3:
                return False
            else:
                return True
