class Solution:
    """
    Feb 28, 2025 00:31
    Time Complexity: O(mn)
    Space Complexity: O(min(n,m))
    """

    def shortestCommonSupersequence(self, str1: str, str2: str) -> str:
        dp = []
        if len(str1) < len(str2):
            new_str1, new_str2 = str2, str1
        else:
            new_str1 = str1
            new_str2 = str2
        n = len(new_str1)
        m = len(new_str2)

        dp.append([[] for _ in range(m)])
        dp.append([[] for _ in range(m)])

        if new_str1[0] == new_str2[0]:
            dp[0][0] = [new_str1[0]]
        else:
            dp[0][0] = [new_str1[0], new_str2[0]]

        for i in range(1, m):
            if new_str1[0] == new_str2[i]:
                dp[0][i] = list(new_str2[:i + 1])
            else:
                dp[0][i] = dp[0][i - 1] + [new_str2[i]]

        for i in range(1, n):
            if new_str1[i] == new_str2[0]:
                dp[1][0] = list(new_str1[:i + 1])
            else:
                dp[1][0] = dp[0][0] + [new_str1[i]]

            for j in range(1, m):
                if new_str1[i] == new_str2[j]:
                    dp[1][j] = dp[0][j - 1] + [new_str1[i]]
                else:
                    if len(dp[1][j - 1]) < len(dp[0][j]):
                        dp[1][j] = dp[1][j - 1] + [new_str2[j]]
                    else:
                        dp[1][j] = dp[0][j] + [new_str1[i]]

                dp[0][j - 1] = dp[1][j - 1]

            dp[0][-1] = dp[1][-1]

        return "".join(dp[0][-1])
# TODO: faster

if __name__ == '__main__':
    obj = Solution()
    str1 = "abac"
    str2 = "cab"
    print(obj.shortestCommonSupersequence(str1, str2))
