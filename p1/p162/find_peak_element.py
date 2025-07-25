"""
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.



Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.


Constraints:

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.
"""
from typing import List


class Solution:
    """
    Jul 08, 2025 16:50
    Time Complexity: O(logn)
    Space Complexity: O(1)
    """

    def findPeakElement(self, nums: List[int]) -> int:
        left = -1
        right = len(nums)
        while left + 1 < right:
            mid = (left + right) // 2
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid
            elif mid == 0 or nums[mid] > nums[mid - 1]:
                left = mid
            else:
                right = mid

        return left


class Solution1:
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


if __name__ == '__main__':
    obj = Solution()
    nums = [1, 2, 3, 1]
    print(obj.findPeakElement(nums))

    nums = [1, 2, 1, 3, 5, 6, 4]
    print(obj.findPeakElement(nums))
