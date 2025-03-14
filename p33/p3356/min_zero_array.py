from typing import List


class Solution:
    """
    TLE
    """
    def minZeroArray(self, nums: List[int], queries: List[List[int]]) -> int:
        if sum(nums) == 0:
            return 0
        for count, query in enumerate(queries):
            for i in range(query[0], query[1] + 1):
                if nums[i] <= query[2]:
                    nums[i] = 0
                else:
                    nums[i] -= query[2]
            if sum(nums) == 0:
                return count + 1

        return -1

class Solution1:
    """
    TLE
    """
    def minZeroArray(self, nums: List[int], queries: List[List[int]]) -> int:
        if sum(nums) == 0:
            return 0
        for count, query in enumerate(queries):
            for i in range(query[0], query[1] + 1):
                if nums[i] <= query[2]:
                    nums[i] = 0
                else:
                    nums[i] -= query[2]
            if sum(nums) == 0:
                return count + 1

        return -1