from typing import List


class Solution:
    """
    Dec 17, 2024 17:34
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        non_zero_index = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[i], nums[non_zero_index] = nums[non_zero_index], nums[i]
                non_zero_index += 1


if __name__ == '__main__':
    s = Solution()
    nums = [1,2]
    s.moveZeroes(nums)
    print(nums)
