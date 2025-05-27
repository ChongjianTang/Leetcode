from typing import List


class Solution:
    """
    May 27, 2025 16:16
    Time Complexity: O(mn)
    Space Complexity: O(1)
    """

    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        first_cell = True
        first_cell_x = -1
        first_cell_y = -1
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    if first_cell:
                        first_cell_x = i
                        first_cell_y = j

                        first_cell = False
                    else:
                        matrix[first_cell_x][j] = 0
                        matrix[i][first_cell_y] = 0
        if first_cell_x == first_cell_y == -1:
            return
        for i in range(len(matrix)):
            if matrix[i][first_cell_y] == 0:
                if i != first_cell_x:
                    for j in range(len(matrix[0])):
                        matrix[i][j] = 0

        for j in range(len(matrix[0])):
            if matrix[first_cell_x][j] == 0:
                if j != first_cell_y:
                    for i in range(len(matrix)):
                        matrix[i][j] = 0

        for i in range(len(matrix)):
            matrix[i][first_cell_y] = 0

        for j in range(len(matrix[0])):
            matrix[first_cell_x][j] = 0


if __name__ == '__main__':
    sol = Solution()
    matrix = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
    sol.setZeroes(matrix)
    print(matrix)
