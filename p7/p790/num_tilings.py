class Solution:
    """
    Feb 15, 2025 14:00
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def numTilings(self, n: int) -> int:
        if n == 1:
            return 1
        dp = [[0] * n, [0] * n, [0] * n]
        """
        0 - *
            *
        1 - * *
            *
        2 - *
            * *
        """
        dp[0][0] = 1
        dp[0][1] = 2
        dp[1][0] = 0
        dp[1][1] = 1
        dp[2][0] = 0
        dp[2][1] = 1

        mod_num = int(1e9) + 7

        for i in range(2, n):
            dp[0][i] = (dp[0][i - 1] + dp[0][i - 2] + dp[1][i - 1] + dp[2][i - 1]) % mod_num
            dp[1][i] = (dp[2][i - 1] + dp[0][i - 2]) % mod_num
            dp[2][i] = (dp[1][i - 1] + dp[0][i - 2]) % mod_num

        return dp[0][-1]


if __name__ == '__main__':
    obj = Solution()
    print(obj.numTilings(3))
