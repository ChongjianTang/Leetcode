from typing import List


class Solution:
    """
    Feb 15, 2025 17:58
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def maxProfit(self, prices: List[int]) -> int:
        max_price = [0] * len(prices)
        min_price = [0] * len(prices)

        min_price[0] = prices[0]
        max_price[-1] = prices[-1]
        max_profit = 0
        for i in range(1, len(prices)):
            if prices[i] < min_price[i - 1]:
                min_price[i] = prices[i]
            else:
                min_price[i] = min_price[i - 1]

            index = len(prices) - 1 - i
            if prices[len(prices) - 1 - i] > max_price[index + 1]:
                max_price[index] = prices[index]
            else:
                max_price[index] = max_price[index + 1]

        for i in range(len(prices)):
            max_profit = max(max_profit, max_price[i] - min_price[i])

        return max_profit


class Solution1:
    """
    Feb 15, 2025 18:04
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def maxProfit(self, prices: List[int]) -> int:
        min_price = float('inf')
        max_profit = 0
        for price in prices:
            if min_price > price:
                min_price = price

            max_profit = max(max_profit, price - min_price)

        return max_profit
