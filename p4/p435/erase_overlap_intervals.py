from collections import deque
from typing import List


class Solution:
    """
    Mar 02, 2025 22:03
    Time Complexity: O(nlogn)
    Space Complexity: O(n)
    """

    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        sorted_intervals = sorted(intervals, key=lambda x: x[1])
        count = 1
        prev = sorted_intervals[0]
        for i in range(1, len(sorted_intervals)):
            if sorted_intervals[i][0] >= prev[1]:
                count += 1
                prev = sorted_intervals[i]

        return len(intervals) - count
