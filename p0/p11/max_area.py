from typing import List


class Solution:
    """
    Dec 22, 2024 16:23
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    def maxArea(self, height: List[int]) -> int:
        max_area = 0

        left = 0
        right = len(height) - 1

        while left < right:
            amount = (right - left) * min(height[left], height[right])
            max_area = max(amount, max_area)
            if height[left] >= height[right]:
                right -= 1
            else:
                left += 1
        return max_area
