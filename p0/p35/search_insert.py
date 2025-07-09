"""
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return
the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
"""
from typing import List


class Solution:
    """
    Jul 08, 2025 16:13
    Time Complexity: O(logn)
    Space Complexity: O(1)
    """

    def searchInsert(self, nums: List[int], target: int) -> int:
        left = -1
        right = len(nums)
        while left + 1 < right:
            mid = (left + right) // 2
            if target == nums[mid]:
                return mid
            elif target < nums[mid]:
                right = mid
            else:
                left = mid

        return left + 1


if __name__ == '__main__':
    obj = Solution()
    nums = [1, 3, 5, 6]
    target = 5
    print(obj.searchInsert(nums, target) == 2)

    nums = [1, 3, 5, 6]
    target = 2
    print(obj.searchInsert(nums, target) == 1)

    nums = [1, 3, 5, 6]
    target = 7
    print(obj.searchInsert(nums, target) == 4)
