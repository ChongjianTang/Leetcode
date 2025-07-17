"""
You are given an integer array nums.
A subsequence sub of nums with length x is called valid if it satisfies:

(sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2.
Return the length of the longest valid subsequence of nums.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.



Example 1:

Input: nums = [1,2,3,4]

Output: 4

Explanation:

The longest valid subsequence is [1, 2, 3, 4].

Example 2:

Input: nums = [1,2,1,1,2,1,2]

Output: 6

Explanation:

The longest valid subsequence is [1, 2, 1, 2, 1, 2].

Example 3:

Input: nums = [1,3]

Output: 2

Explanation:

The longest valid subsequence is [1, 3].



Constraints:

2 <= nums.length <= 2 * 10^5
1 <= nums[i] <= 10^7
"""
from typing import List


class Solution:
    """
    Jul 16, 2025 11:51
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def maximumLength(self, nums: List[int]) -> int:
        dp = [[0] * len(nums), [0] * len(nums)]
        # Prev even
        prev_even_index = -1
        # Prev odd
        prev_odd_index = -1
        for i in range(len(nums)):
            if nums[i] % 2 == 0:
                if prev_even_index == -1:
                    dp[0][i] = 1
                else:
                    dp[0][i] = dp[0][prev_even_index] + 1

                if prev_odd_index == -1:
                    dp[1][i] = 1
                else:
                    dp[1][i] = dp[1][prev_odd_index] + 1

                prev_even_index = i
            else:
                if prev_even_index == -1:
                    dp[1][i] = 1
                else:
                    dp[1][i] = dp[1][prev_even_index] + 1

                if prev_odd_index == -1:
                    dp[0][i] = 1
                else:
                    dp[0][i] = dp[0][prev_odd_index] + 1

                prev_odd_index = i

        return max(dp[0][prev_odd_index], dp[1][prev_odd_index], dp[0][prev_even_index], dp[1][prev_even_index])


if __name__ == '__main__':
    obj = Solution()
    nums = [1, 3]
    print(obj.maximumLength(nums))

    nums = [1, 2, 1, 1, 2, 1, 2]
    print(obj.maximumLength(nums))

    nums = [1, 2, 3, 4]
    print(obj.maximumLength(nums))
