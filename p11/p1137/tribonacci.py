class Solution:
    """
    Feb 15, 2025 13:03
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    def tribonacci(self, n: int) -> int:
        dp = [0, 1, 1]
        if n <= 2:
            return dp[n]

        for i in range(3, n + 1):
            temp = sum(dp)
            dp[0] = dp[1]
            dp[1] = dp[2]
            dp[2] = temp

        return temp
