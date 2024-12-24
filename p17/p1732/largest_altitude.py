from typing import List


class Solution:
    """
    Prefix sum
    Dec 23, 2024 10:36
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def largestAltitude(self, gain: List[int]) -> int:
        prefix_sum = 0
        max_val = 0
        for val in gain:
            prefix_sum += val
            max_val = max(max_val, prefix_sum)

        return max_val
