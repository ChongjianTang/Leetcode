from collections import deque
from typing import List


class Solution:
    """
    Dec 22, 2024 18:00
    Time Complexity: O(n)
    Space Complexity: O(k)
    """

    def longestOnes(self, nums: List[int], k: int) -> int:
        zero_indices = deque()

        left = -1
        right = 0

        max_val = 0
        while right < len(nums):
            if nums[right] == 0:
                max_val = max(max_val, right - left - 1)

                zero_indices.append(right)
                if len(zero_indices) > k:
                    left = zero_indices.popleft()

            right += 1

        return max(max_val, right - left - 1)
