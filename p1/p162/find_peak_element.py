from tabnanny import check
from typing import List


class Solution:
    """
    Feb 15, 2025 00:08
    Binary Search
    Time Complexity: O(logn)
    Space Complexity: O(1)
    """

    def findPeakElement(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1
        while left + 1 < right:
            mid = (left + right) // 2
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid
            elif mid != 0 and nums[mid] <= nums[mid - 1]:
                right = mid - 1
            else:
                left = mid + 1

        if (left == 0 or nums[left] > nums[left - 1]) and (left == len(nums) - 1 or nums[left] > nums[left + 1]):
            return left

        if (right == 0 or nums[right] > nums[right - 1]) and (right == len(nums) - 1 or nums[right] > nums[right + 1]):
            return right

        return -1
