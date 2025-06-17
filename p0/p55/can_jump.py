from typing import List


class Solution:
    """
    May 28, 2025 09:41
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def canJump(self, nums: List[int]) -> bool:
        jump_range = 0
        i = 0
        while i <= jump_range:
            jump_range = max(jump_range, i + nums[i])
            if jump_range >= len(nums) - 1:
                return True
            i += 1

        return False
