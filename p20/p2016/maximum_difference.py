from typing import List


class Solution:
    """
    Jun 15, 2025 19:42
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def maximumDifference(self, nums: List[int]) -> int:
        min_val = nums[0]
        max_diff = -1
        for num in nums:
            if num > min_val:
                max_diff = max(max_diff, num - min_val)
            min_val = min(min_val, num)

        return max_diff


if __name__ == '__main__':
    sol = Solution()
    nums = [7, 1, 5, 4]
    print(sol.maximumDifference(nums))
