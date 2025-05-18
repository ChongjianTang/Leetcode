class Solution:
    def colorTheGrid(self, m: int, n: int) -> int:
        mod = 10 ** 9 + 7
        dp = [[[0 for _ in range(3)] for _ in range(n)] for _ in range(m)]

        dp[0][0] = [1, 1, 1]
        for i in range(1, m):
            dp[i][0][2] = dp[i][0][1] = dp[i][0][0] = (dp[i - 1][0][1] + dp[i - 1][0][2]) % mod

        for i in range(1, n):
            dp[0][i][2] = dp[0][i][1] = dp[0][i][0] = (dp[0][i - 1][1] + dp[0][i - 1][2]) % mod

        for i in range(1, m):
            for j in range(1, n):
                dp[i][j][1] = dp[i][j][2] = dp[i][j][0] = ((dp[i - 1][j][1] + dp[i - 1][j][2]) * (
                        dp[i][j - 1][1] + dp[i][j - 1][2])) % mod

        return sum(dp[-1][-1]) % mod

if __name__ == '__main__':
    sol = Solution()
    print(sol.colorTheGrid(2,2))