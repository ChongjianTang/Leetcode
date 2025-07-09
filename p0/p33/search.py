"""
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
"""
from typing import List


class Solution:
    """
    Jul 08, 2025 18:15
    Time Complexity: O(logn)
    Space Complexity: O(1)
    """

    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1

        while left + 1 < right:
            rotated = nums[left] > nums[right]
            mid = (left + right) // 2
            if nums[mid] == target:
                return mid
            if rotated:
                if nums[mid] > nums[left]:
                    if target > nums[mid]:
                        left = mid
                    else:
                        if target >= nums[left]:
                            right = mid
                        else:
                            left = mid
                else:
                    if target < nums[mid]:
                        right = mid
                    else:
                        if target <= nums[right]:
                            left = mid
                        else:
                            right = mid

            else:
                if nums[mid] < target:
                    left = mid
                else:
                    right = mid

        if nums[left] == target:
            return left

        if nums[right] == target:
            return right

        return -1


if __name__ == '__main__':
    obj = Solution()
    nums = [5, 1, 3]
    target = 5
    print(obj.search(nums, target))

    nums = [1]
    target = 0
    print(obj.search(nums, target))

    nums = [4, 5, 6, 7, 0, 1, 2]
    target = 3
    print(obj.search(nums, target))
    nums = [4, 5, 6, 7, 0, 1, 2]
    target = 0
    print(obj.search(nums, target))
