"""
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
"""
from typing import List


class Solution:
    """
    Jul 09, 2025 16:06
    Time Complexity: O(logn)
    Space Complexity: O(1)
    """

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        result = [-1, -1]
        left = -1
        right = len(nums)
        while left + 1 < right:
            mid = (left + right) // 2
            if nums[mid] == target:
                if mid == 0 or nums[mid] > nums[mid - 1]:
                    result[0] = mid
                    break
                else:
                    right = mid
            elif nums[mid] < target:
                left = mid
            else:
                right = mid

        if result[0] == -1:
            return [-1, -1]

        left = -1
        right = len(nums)
        while left + 1 < right:
            mid = (left + right) // 2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid] < nums[mid + 1]:
                    result[1] = mid
                    return result
                else:
                    left = mid
            elif nums[mid] < target:
                left = mid
            else:
                right = mid

        return [-1, -1]


if __name__ == '__main__':
    obj = Solution()
    nums = []
    target = 0
    print(obj.searchRange(nums, target))

    nums = [5, 7, 7, 8, 8, 10]
    target = 6
    print(obj.searchRange(nums, target))

    nums = [5, 7, 7, 8, 8, 10]
    target = 8
    print(obj.searchRange(nums, target))
