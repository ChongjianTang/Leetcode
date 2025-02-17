from typing import List


class Solution:
    """
    Feb 15, 2025 23:17
    Time Complexity: O(nk)
    Space Complexity: O(nk)
    """
    def maxProfit(self, k: int, prices: List[int]) -> int:
        if len(prices) == 1:
            return 0
        m, n = 2, len(prices)
        dp = []
        for i in range(m):
            dp.append([])
            for j in range(k + 1):
                dp[i].append([0] * n)

        for i in range(k + 1):
            dp[1][i][0] = -prices[0]

        for i in range(1, n):
            for j in range(k + 1):
                if j < k:
                    dp[0][j][i] = max(dp[0][j][i - 1], dp[1][j][i - 1] + prices[i])
                    dp[1][j][i] = max(dp[1][j][i - 1], dp[0][j + 1][i - 1] - prices[i])
                else:
                    dp[0][j][i] = dp[0][j][i - 1]

        return max(max(row[-1] for row in matrix) for matrix in dp)


if __name__ == '__main__':
    obj = Solution()
    print(obj.maxProfit(2, [2, 4, 1]))
