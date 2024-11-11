from typing import List


class Solution:
    """
    Nov 10, 2024 17:13
    Time Complexity: O(n)
    Space Complexity: O(2^n)
    """

    def minimumSubarrayLength(self, nums: List[int], k: int) -> int:
        if k == 0:
            return 1

        result = float('inf')
        prev_or_values = {}
        for i, num in enumerate(nums):
            or_values = {num: 1}
            for or_val, min_length in prev_or_values.items():
                new_or_val = or_val | num
                if new_or_val in or_values:
                    or_values[new_or_val] = min(min_length + 1, or_values[new_or_val])
                else:
                    or_values[new_or_val] = min_length + 1

            prev_or_values = or_values

            for or_val, min_length in prev_or_values.items():
                if or_val >= k:
                    result = min(result, min_length)

        if result == float('inf'):
            return -1
        else:
            return result


if __name__ == '__main__':
    sol = Solution()
    nums = [1, 12, 26, 2]
    k = 8
    print(sol.minimumSubarrayLength(nums, k))
