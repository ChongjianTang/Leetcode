class Solution:
    """
    Feb 19, 2025 14:56
    Time Complexity: O(mn)
    Space Complexity: O(mn)
    """
    def minDistance(self, word1: str, word2: str) -> int:
        m, n = len(word1), len(word2)

        if m == 0:
            return n
        if n == 0:
            return m

        dp = []
        for i in range(m):
            dp.append([0] * n)

        if word1[0] == word2[0]:
            dp[0][0] = 0
        else:
            dp[0][0] = 1

        for i in range(1, m):
            if word1[i] == word2[0]:
                dp[i][0] = i
            else:
                dp[i][0] = dp[i - 1][0] + 1

        for i in range(1, n):
            if word1[0] == word2[i]:
                dp[0][i] = i
            else:
                dp[0][i] = dp[0][i - 1] + 1

        for i in range(1, m):
            for j in range(1, n):
                if word1[i] == word2[j]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1)

        return dp[-1][-1]