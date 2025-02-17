from typing import List


class Solution:
    """
    Feb 15, 2025 22:53
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) == 1:
            return 0
        dp = []
        for i in range(5):
            dp.append([0] * len(prices))
        """
        dp[0] - sold and 0 more
        dp[1] - sold and 1 more
        dp[2] - sold and 2 more
        dp[3] - hold and 0 more
        dp[4] - hold and 1 more
        """
        dp[0][0] = 0
        dp[1][0] = 0
        dp[2][0] = 0
        dp[3][0] = -prices[0]
        dp[4][0] = -prices[0]

        for i in range(1, len(prices)):
            dp[0][i] = max(dp[0][i - 1], dp[3][i - 1] + prices[i])
            dp[1][i] = max(dp[1][i - 1], dp[4][i - 1] + prices[i])
            dp[2][i] = dp[2][i - 1]
            dp[3][i] = max(dp[3][i - 1], dp[1][i - 1] - prices[i])
            dp[4][i] = max(dp[4][i - 1], dp[2][i - 1] - prices[i])

        return max(row[-1] for row in dp)


if __name__ == '__main__':
    obj = Solution()
    print(obj.maxProfit([3, 3, 5, 0, 0, 3, 1, 4]))
