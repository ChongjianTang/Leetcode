from typing import List


class Solution:
    """
    Feb 15, 2025 22:23
    Time Complexity: O(n)
    Space Complexity: O(n)
    """
    def maxProfit(self, prices: List[int], fee: int) -> int:
        if len(prices) == 1:
            return 0
        dp = [[0] * len(prices), [0] * len(prices)]
        dp[1][0] = -prices[0]
        for i in range(1, len(prices)):
            dp[0][i] = max(dp[0][i - 1], dp[1][i - 1] + prices[i] -fee)
            dp[1][i] = max(dp[1][i - 1], dp[0][i - 1] - prices[i])

        return dp[0][len(prices) - 1]