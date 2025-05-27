class Solution:
    """
    May 18, 2025 16:55
    Time Complexity: O(n * size * size)
    Space Complexity: O(n * size)
        - size: 3 * 2^(m-1)
    """
    def colorTheGrid(self, m: int, n: int) -> int:
        mod = 10 ** 9 + 7

        valid_cols = []

        self.generate_valid_cols([], 0, m, valid_cols)

        compatible = {}
        for i in range(len(valid_cols)):
            compatible[i] = []

        for i in range(len(valid_cols)):
            for j in range(i + 1, len(valid_cols)):
                flag = True
                for k in range(m):
                    if valid_cols[i][k] == valid_cols[j][k]:
                        flag = False
                        break
                if flag:
                    compatible[i].append(j)
                    compatible[j].append(i)

        dp = [[0 for _ in range(len(valid_cols))] for _ in range(n)]

        for i in range(len(dp[0])):
            dp[0][i] = 1

        for i in range(1, n):
            for j in range(len(valid_cols)):
                prev_states = compatible[j]
                for prev_state in prev_states:
                    dp[i][j] = (dp[i][j] + dp[i - 1][prev_state]) % mod

        return sum(dp[-1]) % mod

    def generate_valid_cols(self, cur, pos, m, valid_cols):
        if pos == m:
            valid_cols.append(cur[:])
            return

        for i in range(3):
            if pos == 0 or i != cur[-1]:
                self.generate_valid_cols(cur + [i], pos + 1, m, valid_cols)


if __name__ == '__main__':
    sol = Solution()
    print(sol.colorTheGrid(1, 1))
