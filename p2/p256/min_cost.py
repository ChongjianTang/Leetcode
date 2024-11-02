from typing import List


class Solution:
    """
    Oct 30, 2024 13:33
    DP
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def minCost(self, costs: List[List[int]]) -> int:
        m = len(costs)
        n = len(costs[0])
        dp = [[0] * n for _ in range(m)]
        dp[0] = costs[0]
        for i in range(1, m, 1):
            for j in range(n):
                dp[i][j] = float('inf')
                for k in range(n):
                    if j != k:
                        dp[i][j] = min(dp[i][j], dp[i - 1][k] + costs[i][j])

        return min(dp[-1])
