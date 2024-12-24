from typing import List


class Solution:
    """
    Dec 23, 2024 10:53
    Time Complexity: O(n+m)
    Space Complexity: O(n+m)
    """

    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        set1 = set(nums1)
        set2 = set(nums2)

        return [list(set1 - set2), list(set2 - set1)]
