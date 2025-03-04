from typing import List


class Solution:
    """
    Feb 28, 2025 01:44
    Time Complexity: O(n^2)
    Space Complexity: O(n^2)
    """

    def lenLongestFibSubseq(self, arr: List[int]) -> int:
        index_map = {}
        for i, val in enumerate(arr):
            index_map[val] = i

        dp = []
        n = len(arr)
        for i in range(n):
            dp.append([0] * n)

        for i in range(1, n):
            dp[0][i] = 2

        max_len = 0
        for i in range(1, n):
            for j in range(i + 1, n):
                val = arr[j] - arr[i]
                if val in index_map and val < arr[i]:
                    dp[i][j] = dp[index_map[val]][i] + 1
                    max_len = max(max_len, dp[i][j])
                else:
                    dp[i][j] = 2

        return max_len


if __name__ == '__main__':
    obj = Solution()
    print(obj.lenLongestFibSubseq([2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50]))
