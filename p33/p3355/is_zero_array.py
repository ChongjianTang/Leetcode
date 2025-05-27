import heapq
from typing import List


class Solution:
    """
    May 23, 2025 11:22
    Time Complexity: O(n+qlogq)
    Space Complexity: O(q)
        - q is len(queries)
    """
    def isZeroArray(self, nums: List[int], queries: List[List[int]]) -> bool:
        min_heap = []
        for query in queries:
            heapq.heappush(min_heap, (query[0], 1))
            heapq.heappush(min_heap, (query[1] + 1, -1))

        i = 0
        curr = 0
        while min_heap:
            (index, flag) = heapq.heappop(min_heap)
            while i < index:
                if nums[i] > curr:
                    return False
                i += 1

            curr += flag

        while i < len(nums):
            if nums[i] > curr:
                return False
            i += 1

        return True


if __name__ == '__main__':
    sol = Solution()
    nums = [1, 0, 1]
    queries = [[0, 2]]
    print(sol.isZeroArray(nums, queries))
