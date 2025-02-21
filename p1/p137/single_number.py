from typing import List


class Solution:
    """
    Feb 19, 2025 15:48
    """
    def singleNumber(self, nums: List[int]) -> int:
        return (3 * sum(set(nums)) - sum(nums)) // 2
