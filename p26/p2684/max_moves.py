from typing import List


class Solution:
    """
    Oct 29, 2024 02:44
    DP
    Time Complexity: O(mn)
    Space Complexity: O(mn)
    """
    def maxMoves(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dp = [[0] * n for _ in range(m)]
        for j in range(n - 2, -1, -1):
            for i in range(m):
                if i - 1 >= 0 and grid[i][j] < grid[i - 1][j + 1]:
                    dp[i][j] = max(dp[i][j], dp[i - 1][j + 1] + 1)
                if grid[i][j] < grid[i][j + 1]:
                    dp[i][j] = max(dp[i][j], dp[i][j + 1] + 1)
                if i + 1 < m and grid[i][j] < grid[i + 1][j + 1]:
                    dp[i][j] = max(dp[i][j], dp[i + 1][j + 1] + 1)

        max_move = 0
        for i in range(m):
            max_move = max(max_move, dp[i][0])

        return max_move


if __name__ == '__main__':
    s = Solution()
    grid = [[2, 4, 3, 5], [5, 4, 9, 3], [3, 4, 2, 11], [10, 9, 13, 15]]
    print(s.maxMoves(grid) == 3)

    grid = [[131, 1, 95, 208, 38, 257, 123, 204, 101],
            [185, 165, 292, 109, 266, 259, 97, 234, 60],
            [55, 281, 38, 61, 204, 243, 32, 54, 164],
            [106, 230, 202, 4, 65, 243, 89, 139, 211],
            [192, 246, 11, 294, 119, 43, 250, 161, 110],
            [71, 279, 288, 173, 64, 48, 216, 26, 276],
            [23, 206, 152, 106, 288, 286, 270, 131, 12],
            [115, 64, 251, 108, 194, 295, 131, 249, 121]]
    print(s.maxMoves(grid) == 5)
