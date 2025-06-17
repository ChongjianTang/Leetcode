from typing import List


class Solution:
    """
    May 27, 2025 16:44
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def removeDuplicates(self, nums: List[int]) -> int:
        prev = nums[0]
        index = 1
        count = 1
        for i in range(len(nums)):
            if nums[i] != prev:
                nums[index] = nums[i]
                index += 1
                prev = nums[i]
                count = 1
            else:
                if count < 2:
                    nums[index] = nums[i]
                    index += 1
                    count += 1
        return index
