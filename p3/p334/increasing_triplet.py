from typing import List


class Solution:
    """
    Dec 17, 2024 13:13
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    def increasingTriplet(self, nums: List[int]) -> bool:
        first = second = float('inf')
        for num in nums:
            if num <= first:
                first = num
            elif num <= second:
                second = num
            else:
                return True

        return False