from typing import List


class Solution:
    """
    Apr 02, 2025 14:27
    """
    def maximumTripletValue(self, nums: List[int]) -> int:
        n = len(nums)
        result = 0
        for i in range(n - 2):
            for j in range(i + 1, n - 1):
                result = max(result, (nums[i] - nums[j]) * max(nums[j + 1:]))
                result = max(0, result)
        return result
