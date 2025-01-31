import heapq
from typing import List


class Solution:
    """
    Heap
    Jan 30, 2025 16:32
    Time Complexity: O(nlogn)
    Space Complexity: O(n)
    """

    def maxScore(self, nums1: List[int], nums2: List[int], k: int) -> int:
        pairs = sorted(zip(nums1, nums2), key=lambda x: -x[1])

        heap = []
        max_score = 0
        arr_sum = 0

        for num1, num2 in pairs:
            if len(heap) + 1 > k:
                arr_sum -= heapq.heappop(heap)

            arr_sum += num1
            heapq.heappush(heap, num1)

            if len(heap) == k:
                max_score = max(max_score, arr_sum * num2)

        return max_score


if __name__ == '__main__':
    sol = Solution()
    print(sol.maxScore([2, 1, 14, 12], [11, 7, 13, 6], 3) == 168)
