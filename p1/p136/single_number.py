from typing import List


class Solution:
    """
    Feb 19, 2025 15:43
    """
    def singleNumber(self, nums: List[int]) -> int:
        ans = 0
        for num in nums:
            ans ^= num

        return ans