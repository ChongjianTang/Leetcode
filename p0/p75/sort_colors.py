from typing import List


class Solution:
    """
    May 17, 2025 15:42
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        left = 0
        while left < n and nums[left] == 0:
            left += 1
        right = n - 1
        while right >= 0 and nums[right] == 2:
            right -= 1

        i = left
        while i <= right:
            if nums[i] == 2:
                nums[right], nums[i] = nums[i], nums[right]
                while nums[right] == 2:
                    right -= 1
            if nums[i] == 0:
                nums[left], nums[i] = nums[i], nums[left]
                left += 1

            i += 1


if __name__ == '__main__':
    sol = Solution()
    nums = [2, 0, 2, 1, 1, 0]
    sol.sortColors(nums)
    print(nums)
