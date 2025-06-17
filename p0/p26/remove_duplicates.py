from typing import List


class Solution:
    """
    May 27, 2025 16:38
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def removeDuplicates(self, nums: List[int]) -> int:
        prev = nums[0]
        index = 1
        for i in range(1, len(nums)):
            if nums[i] != prev:
                nums[index] = nums[i]
                index += 1
                prev = nums[i]

        return index
