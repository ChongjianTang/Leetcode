from sys import prefix
from typing import List


class Solution:
    """
    Prefix Sum
    Dec 23, 2024 10:43
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def pivotIndex(self, nums: List[int]) -> int:
        prefix_sum = 0
        total = sum(nums)

        for i, num in enumerate(nums):
            if prefix_sum == total - prefix_sum - num:
                return i
            prefix_sum += num

        return -1
