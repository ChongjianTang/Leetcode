from typing import List


class Solution:
    """
    Mar 18, 2025 16:53
    Binary Search
    Time Complexity: O(nlogm)
    Space Complexity: O(1)
    """

    def minCapability(self, nums: List[int], k: int) -> int:
        left = min(nums)
        right = max(nums)

        while left + 1 < right:
            mid = (left + right) // 2
            count = 0

            i = 0
            while i < len(nums):
                if nums[i] <= mid:
                    count += 1
                    i += 2
                    if count == k:
                        break
                else:
                    i += 1

            if count == k:
                right = mid
            else:
                left = mid

        return right


class Solution1:
    """
    TLE
    """

    def minCapability(self, nums: List[int], k: int) -> int:
        if k == 1:
            return min(nums)

        dp = []
        n = len(nums)
        for i in range(k):
            dp.append([0] * n)

        for i in range(n):
            dp[0][i] = nums[i]

        for i in range(1, k):
            prev_min = min(dp[i - 1][i * 2 - 2: (i + 1) * 2 - 3])
            for j in range((i + 1) * 2 - 2, n):
                dp[i][j] = max(prev_min, nums[j])
                prev_min = min(prev_min, dp[i - 1][j - 1])

        return min(dp[k - 1][2 * k - 2:])


if __name__ == '__main__':
    obj = Solution()
    nums = [9, 6, 20, 21, 8]
    print(obj.minCapability(nums, 3))
