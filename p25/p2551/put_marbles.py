import heapq
from typing import List


class Solution:
    """
    Mar 31, 2025 15:42
    """
    def putMarbles(self, weights: List[int], k: int) -> int:
        min_heap = []
        max_heap = []
        n = len(weights)
        for i in range(n - 1):
            heapq.heappush(min_heap, weights[i] + weights[i + 1])
            if len(min_heap) > k - 1:
                heapq.heappop(min_heap)
            heapq.heappush(max_heap, -(weights[i] + weights[i + 1]))
            if len(max_heap) > k - 1:
                heapq.heappop(max_heap)

        return sum(min_heap) + sum(max_heap)
