import heapq
from typing import List


class Solution:
    """
    Mar 14, 2025 16:08
    Time Complexity: O(nlogm)
    Space Complexity: O(1)
    """

    def maximumCandies(self, candies: List[int], k: int) -> int:
        if sum(candies) < k:
            return 0

        min_candy = 1
        max_candy = max(candies)
        kids_allocated = 0
        for candy in candies:
            kids_allocated += (candy // max_candy)
        if kids_allocated >= k:
            return max_candy

        while min_candy + 1 < max_candy:
            mid = (min_candy + max_candy) // 2
            kids_allocated = 0
            for candy in candies:
                kids_allocated += (candy // mid)
            if kids_allocated >= k:
                min_candy = mid
            else:
                max_candy = mid

        return min_candy
