from typing import List


class Solution:
    """
    May 14, 2025 17:31
    Time Complexity: O(n+m)
    Space Complexity: O(1)
    """

    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        i = m - 1
        j = n - 1
        k = m + n - 1

        while k >= 0:
            if i == -1:
                nums1[k] = nums2[j]
                j -= 1
            elif j == -1:
                nums1[k] = nums1[i]
                i -= 1
            else:
                if nums1[i] > nums2[j]:
                    nums1[k] = nums1[i]
                    i -= 1
                else:
                    nums1[k] = nums2[j]
                    j -= 1

            k -= 1
