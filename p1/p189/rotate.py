from typing import List


class Solution:
    """
    May 27, 2025 18:06
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = 0
        count = 0

        while count != len(nums):
            prev_val = nums[i]
            index = (i + k) % len(nums)
            while index != i:
                nums[index], prev_val = prev_val, nums[index]
                index = (index + k) % len(nums)
                count += 1

            nums[index] = prev_val
            count += 1
            i += 1
