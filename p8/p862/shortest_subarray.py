from typing import List


class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        left = right = 0
        sum = 0

        min_length = float('inf')
        while right < len(nums):
            while sum < k and right < len(nums):
                sum += nums[right]
                right += 1

            while sum >= k:
                min_length = min(min_length, right - left)
                sum -= nums[left]
                left += 1

        return min_length
