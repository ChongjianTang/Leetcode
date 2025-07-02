from asyncore import write
from typing import List


class Solution:
    """
    Jun 30, 2025 12:06
    Time Complexity: O(N*3^L) where N is the number of cells in the board and L is the length of the word to be matched.
    Space Complexity: O(L)
    """

    def exist(self, board: List[List[str]], word: str) -> bool:
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    board[i][j] = ""
                    if self.back_tracking(board, word, 1, i, j):
                        return True
                    board[i][j] = word[0]
        return False

    def back_tracking(self, board: List[List[str]], word, index, x, y):
        if index == len(word):
            return True
        delta_x = [1, -1, 0, 0]
        delta_y = [0, 0, 1, -1]
        for i in range(len(delta_x)):
            new_x = x + delta_x[i]
            new_y = y + delta_y[i]
            if 0 <= new_x < len(board) and 0 <= new_y < len(board[0]):
                if board[new_x][new_y] == word[index]:
                    board[new_x][new_y] = ""
                    if self.back_tracking(board, word, index + 1, new_x, new_y):
                        return True
                    board[new_x][new_y] = word[index]
        return False


if __name__ == '__main__':
    sol = Solution()
    board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]]
    word = "ABCCED"
    print(sol.exist(board, word))
