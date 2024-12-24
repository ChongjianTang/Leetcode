from collections import Counter
from typing import List


class Solution:
    """
    Dec 23, 2024 15:10
    Time Complexity: O(n^2)
    Space Complexity: O(n^2)
    """

    def equalPairs(self, grid: List[List[int]]) -> int:
        n = len(grid)
        row_counter = Counter(tuple(row) for row in grid)

        count = 0
        for j in range(n):
            col = tuple(grid[i][j] for i in range(n))
            count += row_counter[col]

        return count
