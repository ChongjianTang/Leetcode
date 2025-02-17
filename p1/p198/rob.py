from typing import List


class Solution:
    """
    Feb 15, 2025 13:25
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        dp = [nums[0], max(nums[1], nums[0])]

        for i in range(2, len(nums)):
            temp = max(dp[0] + nums[i], dp[1])
            dp[0] = dp[1]
            dp[1] = temp

        return max(dp)


if __name__ == '__main__':
    obj = Solution()
    print(obj.rob([2, 1, 1, 2]))
