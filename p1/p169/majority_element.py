from typing import List


class Solution:
    """
    May 27, 2025 17:07
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def majorityElement(self, nums: List[int]) -> int:
        candidate = nums[0]

        count = 1
        for i in range(1, len(nums)):
            if count == 0:
                candidate = nums[i]
                count += 1
            else:
                if nums[i] == candidate:
                    count += 1
                else:
                    count -= 1

        return candidate
