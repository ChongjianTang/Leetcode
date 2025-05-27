from typing import List


class Solution:
    """
    May 18, 2025 17:06
    Time Complexity: O(1)
    Space Complexity: O(1)
    """

    def triangleType(self, nums: List[int]) -> str:
        if nums[0] >= nums[1] + nums[2]:
            return "none"
        if nums[1] >= nums[0] + nums[2]:
            return "none"
        if nums[2] >= nums[0] + nums[1]:
            return "none"

        if nums[0] == nums[1] == nums[2]:
            return "equilateral"

        if nums[0] == nums[1] or nums[1] == nums[2] or nums[0] == nums[2]:
            return "isosceles"

        return "scalene"
