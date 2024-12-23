from typing import List


class Solution:
    """
    Dec 22, 2024 17:06
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def findMaxAverage(self, nums: List[int], k: int) -> float:
        left = 0
        right = k - 1

        total = 0

        for i in range(k):
            total += nums[i]

        max_val = total

        while right + 1 < len(nums):
            right += 1
            total += nums[right]
            total -= nums[left]
            left += 1

            max_val = max(max_val, total)

        return max_val / k
