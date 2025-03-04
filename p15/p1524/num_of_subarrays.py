from typing import List


class Solution:
    """
    Feb 25, 2025 14:50
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def numOfSubarrays(self, arr: List[int]) -> int:
        mod = 10 ** 9 + 7
        n = len(arr)
        dp = [0] * n

        if arr[0] % 2 == 1:
            dp[0] = 1
        else:
            dp[0] = 0

        for i in range(1, n):
            if arr[i] % 2 == 1:
                dp[i] = i - dp[i - 1] + 1
            else:
                dp[i] = dp[i - 1]

        result = 0
        for val in dp:
            result = (result + val) % mod
        return result


if __name__ == '__main__':
    obj = Solution()
    arr = [2, 4, 6]
    print(obj.numOfSubarrays(arr) == 0)

    arr = [1, 2, 3, 4, 5, 6, 7]
    print(obj.numOfSubarrays(arr) == 16)
    arr = [1, 3, 5]
    print(obj.numOfSubarrays(arr) == 4)
