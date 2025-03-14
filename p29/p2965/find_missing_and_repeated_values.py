import math
from operator import rshift
from typing import List


class Solution:
    """
    Mar 05, 2025 16:10
    """
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        n = len(grid)
        visited = [False] * (n * n)
        result = [0, 0]
        for i in range(n):
            for j in range(n):
                if not visited[grid[i][j] - 1]:
                    visited[grid[i][j] - 1] = True
                else:
                    result[0] = grid[i][j]

        for i in range(n * n):
            if not visited[i]:
                result[1] = i + 1

        return result
