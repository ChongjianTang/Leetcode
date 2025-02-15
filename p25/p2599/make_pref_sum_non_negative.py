import heapq
from typing import List


class Solution:
    """
    Feb 13, 2025 22:36
    Time Complexity: O(nlogn)
    Space Complexity: O(n)
    """

    def makePrefSumNonNegative(self, nums: List[int]) -> int:
        heap = []
        prefix_sum = 0
        count = 0
        for num in nums:
            heapq.heappush(heap, num)
            prefix_sum += num
            while prefix_sum < 0:
                val = heapq.heappop(heap)
                prefix_sum -= val
                count += 1

        return count


if __name__ == '__main__':
    obj = Solution()
    nums = [3, -5, -2, 6]
    print(obj.makePrefSumNonNegative(nums) == 1)
