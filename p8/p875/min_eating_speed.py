import math
from typing import List


class Solution:
    """
    Feb 15, 2025 00:36
    Time Complexity: O(nlog(max(piles))
    Space Complexity: O(1)
    """

    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        min_rate = 1
        max_rate = math.ceil(max(piles) / (h // len(piles)))
        while min_rate + 1 < max_rate:
            mid = (min_rate + max_rate) // 2
            count = sum((pile + mid - 1) // mid for pile in piles)
            if count > h:
                min_rate = mid
            else:
                max_rate = mid

        return max_rate


if __name__ == '__main__':
    obj = Solution()
    print(obj.minEatingSpeed([312884470], 312884469) == 2)
