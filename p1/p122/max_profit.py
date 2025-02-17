from typing import List


class Solution:
    """
    Feb 15, 2025 22:20
    DP
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) == 1:
            return 0
        dp = [[0] * len(prices), [0] * len(prices)]
        dp[1][0] = -prices[0]
        for i in range(1, len(prices)):
            dp[0][i] = max(dp[0][i - 1], dp[1][i - 1] + prices[i])
            dp[1][i] = max(dp[1][i - 1], dp[0][i - 1] - prices[i])

        return dp[0][len(prices) - 1]


class Solution:
    """
    Feb 15, 2025 22:22
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i - 1]:
                max_profit += (prices[i] - prices[i - 1])

        return max_profit


if __name__ == '__main__':
    obj = Solution()
    print(obj.maxProfit([7, 6, 4, 3, 1]))
