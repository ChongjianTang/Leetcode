"""
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
"""
from typing import List


class Solution:
    """
    Jul 14, 2025 16:35
    Time Complexity: O(log(min(m+n)))
    Space Complexity: O(1)
    """

    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        n = len(nums1)
        m = len(nums2)
        even = (n + m) % 2 == 0

        if n == 0:
            if m % 2 == 0:
                return (nums2[m // 2] + nums2[m // 2 - 1]) / 2
            else:
                return nums2[m // 2]

        left = -2
        right = n
        while left + 1 < right:
            i = (left + right) // 2
            j = (m + n - 1) // 2 - i - 1
            if i >= 0 and j >= 0:
                right_max_val = max(nums1[i], nums2[j])
            elif i >= 0:
                right_max_val = nums1[i]
            else:
                right_max_val = nums2[j]

            if i + 1 < n and j + 1 < m:
                left_min_val = min(nums1[i + 1], nums2[j + 1])
            elif i + 1 < n:
                left_min_val = nums1[i + 1]
            else:
                left_min_val = nums2[j + 1]

            if right_max_val <= left_min_val:
                if even:
                    return (right_max_val + left_min_val) / 2
                else:
                    return right_max_val
            elif nums1[i + 1] < nums2[j]:
                left = i
            else:
                right = i

        return -1


if __name__ == '__main__':
    obj = Solution()
    nums1 = [1, 2]
    nums2 = [3, 4, 5, 6]
    print(obj.findMedianSortedArrays(nums1, nums2))

    nums1 = [3]
    nums2 = [1, 2, 4]
    print(obj.findMedianSortedArrays(nums1, nums2))

    nums1 = [1, 3]
    nums2 = [2]
    print(obj.findMedianSortedArrays(nums1, nums2))
