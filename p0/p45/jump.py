from typing import List


class Solution:
    """
    May 28, 2025 17:41
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def jump(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        jump_range = 0
        i = 0
        count = 0

        while i <= jump_range:
            max_jump_range = 0
            for j in range(i, jump_range + 1):
                max_jump_range = max(max_jump_range, j + nums[j])

            count += 1
            i = jump_range + 1
            jump_range = max_jump_range
            if jump_range >= len(nums) - 1:
                return count

        return -1


if __name__ == '__main__':
    sol = Solution()
    nums = [2, 3, 1, 1, 4]
    print(sol.jump(nums))
