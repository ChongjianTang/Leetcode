from typing import List


class Solution:
    """
    May 14, 2025 18:57
    Time Complexity: O(E(n+m))
    Space Complexity: O(1)
    """

    def maxKilledEnemies(self, grid: List[List[str]]) -> int:
        result = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 'E':
                    k = i - 1
                    while k >= 0:
                        if grid[k][j] != "E" and grid[k][j] != "W":
                            grid[k][j] = str(int(grid[k][j]) + 1)
                            result = max(result, int(grid[k][j]))
                        elif grid[k][j] == "W":
                            break
                        k -= 1

                    k = i + 1
                    while k < len(grid):
                        if grid[k][j] != "E" and grid[k][j] != "W":
                            grid[k][j] = str(int(grid[k][j]) + 1)
                            result = max(result, int(grid[k][j]))
                        elif grid[k][j] == "W":
                            break
                        k += 1

                    k = j - 1
                    while k >= 0:
                        if grid[i][k] != "E" and grid[i][k] != "W":
                            grid[i][k] = str(int(grid[i][k]) + 1)
                            result = max(result, int(grid[i][k]))
                        elif grid[i][k] == "W":
                            break
                        k -= 1

                    k = j + 1
                    while k < len(grid[0]):
                        if grid[i][k] != "E" and grid[i][k] != "W":
                            grid[i][k] = str(int(grid[i][k]) + 1)
                            result = max(result, int(grid[i][k]))
                        elif grid[i][k] == "W":
                            break
                        k += 1
        return result

# TODO: Need to find a better solution.
