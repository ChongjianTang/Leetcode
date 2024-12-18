from typing import List


class Solution:
    """
    Dec 09, 2024 11:43
    Time Complexity: O(n+m)
    Space Complexity: O(n)
    """

    def isArraySpecial(self, nums: List[int], queries: List[List[int]]) -> List[bool]:
        n = len(nums)
        prefix = [0] * (n + 1)
        for i in range(1, n):
            if (nums[i] + nums[i - 1]) % 2 == 0:
                prefix[i] = prefix[i - 1] + 1
            else:
                prefix[i] = prefix[i - 1]

        result = []
        for query in queries:
            result.append(prefix[query[0]] == prefix[query[1]])

        return result
