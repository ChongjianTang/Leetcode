"""
You are given an integer array nums and a positive integer k.
A subsequence sub of nums with length x is called valid if it satisfies:

(sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x - 1]) % k.
Return the length of the longest valid subsequence of nums.


Example 1:

Input: nums = [1,2,3,4,5], k = 2

Output: 5

Explanation:

The longest valid subsequence is [1, 2, 3, 4, 5].

Example 2:

Input: nums = [1,4,2,3,1,4], k = 3

Output: 4

Explanation:

The longest valid subsequence is [1, 4, 1, 4].



Constraints:

2 <= nums.length <= 10^3
1 <= nums[i] <= 10^7
1 <= k <= 10^3
"""
from typing import List


class Solution:
    """
    Jul 17, 2025 16:48
    Time Complexity: O(nk)
    Space Complexity: O(nk)
    """
    def maximumLength(self, nums: List[int], k: int) -> int:
        dp = [[0 for _ in range(k)] for _ in range(len(nums))]
        prev = [-1] * k
        for i in range(len(nums)):
            r = nums[i] % k
            for j in range(k):
                if prev[j] == -1:
                    dp[i][(j + r) % k] = 1
                else:
                    dp[i][(j + r) % k] = dp[prev[j]][(j + r) % k] + 1

            prev[r] = i

        result = 0
        for i in range(k):
            result = max(result, max(dp[prev[i]]))

        return result


if __name__ == '__main__':
    obj = Solution()
    nums = [1, 4, 2, 3, 1, 4]
    k = 3
    print(obj.maximumLength(nums, k))

    nums = [1, 2, 3, 4, 5]
    k = 2
    print(obj.maximumLength(nums, k))
