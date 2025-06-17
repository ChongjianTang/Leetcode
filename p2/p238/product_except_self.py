from typing import List


class Solution:
    """
    Jun 10, 2025 16:59
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def productExceptSelf(self, nums: List[int]) -> List[int]:
        result = [1 for _ in nums]
        prefix = 1
        for i in range(len(nums)):
            result[i] = prefix
            prefix *= nums[i]

        suffix = 1
        for i in range(len(nums) - 1, -1, -1):
            result[i] *= suffix
            suffix *= nums[i]

        return result


class Solution1:
    """
    Nov 05, 2024 15:06
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def productExceptSelf(self, nums: List[int]) -> List[int]:
        result = [1] * len(nums)
        prefix = 1
        for i in range(len(nums)):
            result[i] = prefix
            prefix *= nums[i]

        suffix = 1
        for i in range(len(nums) - 1, -1, -1):
            result[i] *= suffix
            suffix *= nums[i]
        return result
