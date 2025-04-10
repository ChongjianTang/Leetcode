from typing import List


class Solution:
    """
    Mar 18, 2025 14:15
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def longestNiceSubarray(self, nums: List[int]) -> int:
        left = 0
        right = 1
        n = len(nums)
        xor_sum = nums[0]
        max_len = 1
        while right < n and n - left >= max_len:
            while xor_sum & nums[right] != 0:
                xor_sum ^= nums[left]
                left += 1

            xor_sum ^= nums[right]
            right += 1
            max_len = max(max_len, right - left)

        return max_len


if __name__ == '__main__':
    obj = Solution()
    nums = [1, 3, 8, 48, 10]
    print(obj.longestNiceSubarray(nums))
