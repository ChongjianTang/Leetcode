from typing import List


class Solution:
    """
    Oct 27, 2024 18:08
    Time Complexity: O(mn)
    Space Complexity: O(mn)
    """

    def countSquares(self, matrix: List[List[int]]) -> int:
        if not matrix:
            return 0

        m = len(matrix)
        n = len(matrix[0])

        result = 0

        dp = [[0] * n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    dp[i][j] = 0
                else:
                    if i == 0 or j == 0:
                        dp[i][j] = 1
                    else:
                        dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1

                    result += dp[i][j]

        return result
