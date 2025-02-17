from typing import List


class Solution:
    """
    Feb 15, 2025 13:13
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def minCostClimbingStairs(self, cost: List[int]) -> int:
        dp = [0] * 3
        dp[0] = 0
        dp[1] = 0

        for i in range(2, len(cost) + 1):
            temp = min(dp[0] + cost[i - 2], dp[1] + cost[i - 1])
            dp[0] = dp[1]
            dp[1] = temp

        return dp[1]
