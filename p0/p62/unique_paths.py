class Solution:
    """
    Feb 15, 2025 15:45
    Time Complexity: O(mn)
    Space Complexity: O(mn)
    """
    def uniquePaths(self, m: int, n: int) -> int:
        dp = []
        for i in range(m):
            dp.append([0] * n)

        for i in range(m):
            dp[i][0] = 1

        for i in range(n):
            dp[0][i] = 1

        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]

        return dp[-1][-1]
