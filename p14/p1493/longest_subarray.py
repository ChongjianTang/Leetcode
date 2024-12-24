from typing import List


class Solution:
    """
    Sliding Window
    Dec 23, 2024 10:31
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def longestSubarray(self, nums: List[int]) -> int:
        zero_index = -1

        left = -1
        right = 0

        max_val = 0
        while right < len(nums):
            if nums[right] == 0:
                if zero_index != -1:
                    max_val = max(max_val, right - left - 1)
                    left = zero_index

                zero_index = right

            right += 1

        return max(max_val, right - left - 1) - 1
