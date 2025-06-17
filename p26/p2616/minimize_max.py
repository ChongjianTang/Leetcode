from typing import List


class Solution:
    """
    Jun 12, 2025 22:02
    Time Complexity: O(nlogn + nlogV) V is max_diff = nums[-1] - nums[0]
    Space Complexity: O(1)
    """

    def minimizeMax(self, nums: List[int], p: int) -> int:
        if p == 0:
            return 0
        nums.sort()

        min_diff = 0
        max_diff = nums[-1] - nums[0]

        while min_diff + 1 < max_diff:
            mid_diff = (min_diff + max_diff) // 2
            count = 0
            i = 1
            while i < len(nums):
                if nums[i] - nums[i - 1] <= mid_diff:
                    count += 1
                    if count == p:
                        break
                    i += 1
                i += 1

            if count == p:
                max_diff = mid_diff
            else:
                min_diff = mid_diff

        count = 0
        i = 1
        while i < len(nums):
            if nums[i] - nums[i - 1] <= min_diff:
                count += 1
                if count == p:
                    return min_diff
                i += 1
            i += 1
        return max_diff


if __name__ == '__main__':
    sol = Solution()
    nums = [4, 2, 1, 2]
    print(sol.minimizeMax(nums, 3))
