"""
Given two sorted 0-indexed integer arrays nums1 and nums2 as well as an integer k, return the kth (1-based) smallest product of nums1[i] * nums2[j] where 0 <= i < nums1.length and 0 <= j < nums2.length.


Example 1:

Input: nums1 = [2,5], nums2 = [3,4], k = 2
Output: 8
Explanation: The 2 smallest products are:
- nums1[0] * nums2[0] = 2 * 3 = 6
- nums1[0] * nums2[1] = 2 * 4 = 8
The 2nd smallest product is 8.
Example 2:

Input: nums1 = [-4,-2,0,3], nums2 = [2,4], k = 6
Output: 0
Explanation: The 6 smallest products are:
- nums1[0] * nums2[1] = (-4) * 4 = -16
- nums1[0] * nums2[0] = (-4) * 2 = -8
- nums1[1] * nums2[1] = (-2) * 4 = -8
- nums1[1] * nums2[0] = (-2) * 2 = -4
- nums1[2] * nums2[0] = 0 * 2 = 0
- nums1[2] * nums2[1] = 0 * 4 = 0
The 6th smallest product is 0.
Example 3:

Input: nums1 = [-2,-1,0,1,2], nums2 = [-3,-1,2,4,5], k = 3
Output: -6
Explanation: The 3 smallest products are:
- nums1[0] * nums2[4] = (-2) * 5 = -10
- nums1[0] * nums2[3] = (-2) * 4 = -8
- nums1[4] * nums2[0] = 2 * (-3) = -6
The 3rd smallest product is -6.


Constraints:

1 <= nums1.length, nums2.length <= 5 * 104
-105 <= nums1[i], nums2[j] <= 105
1 <= k <= nums1.length * nums2.length
nums1 and nums2 are sorted.
"""
from typing import List


class Solution:
    """
    Jun 26, 2025 14:03
    Time Complexity: O((n+m)logv) v = max_val - min_val
    Space Complexity: O(1)
    """

    def kthSmallestProduct(self, nums1: List[int], nums2: List[int], k: int) -> int:
        index1 = len(nums1)
        for i in range(len(nums1)):
            if nums1[i] >= 0:
                index1 = i
                break
        index2 = len(nums2)
        for i in range(len(nums2)):
            if nums2[i] >= 0:
                index2 = i
                break

        min_val = min(nums1[0] * nums2[0], nums1[0] * nums2[-1], nums1[-1] * nums2[0], nums1[-1] * nums2[-1]) - 1
        max_val = max(nums1[0] * nums2[0], nums1[0] * nums2[-1], nums1[-1] * nums2[0], nums1[-1] * nums2[-1])

        while min_val + 1 < max_val:
            mid = (min_val + max_val) // 2
            if self.check_less_than_target(nums1, index1, nums2, index2, k, mid):
                max_val = mid
            else:
                min_val = mid

        return max_val

    def check_less_than_target(self, nums1: List[int], index1: int, nums2: List[int], index2: int, k: int, target: int):
        count = 0
        if target < 0:
            i = 0
            j = index2
            while i < index1 and j < len(nums2):
                if nums1[i] * nums2[j] <= target:
                    count += len(nums2) - j
                    if count >= k:
                        return True
                    i += 1
                else:
                    j += 1

            i = index1
            j = 0
            while i < len(nums1) and j < index2:
                if nums2[j] * nums1[i] <= target:
                    count += len(nums1) - i
                    if count >= k:
                        return True
                    j += 1
                else:
                    i += 1
        else:
            count += index1 * (len(nums2) - index2)
            count += index2 * (len(nums1) - index1)
            if count >= k:
                return True

            i = index1 - 1
            j = 0
            while i >= 0 and j < index2:
                if nums1[i] * nums2[j] <= target:
                    count += index2 - j
                    if count >= k:
                        return True
                    i -= 1
                else:
                    j += 1

            i = index1
            j = len(nums2) - 1
            while i < len(nums1) and j >= index2:
                if nums1[i] * nums2[j] <= target:
                    count += j + 1 - index2
                    if count >= k:
                        return True
                    i += 1
                else:
                    j -= 1
        return False


if __name__ == '__main__':
    sol = Solution()

    nums1 = [-9, -8, -8, -6, -4, -1, 2, 3]

    nums2 = [-1, -1, 0, 0, 3, 8]
    k = 48
    print(sol.kthSmallestProduct(nums1, nums2, k) == 24)

    nums1 = [7, 10]
    nums2 = [-8, -6, -4, -3, 1, 4, 4, 5]
    k = 8
    print(sol.kthSmallestProduct(nums1, nums2, k) == -21)

    nums1 = [-9, 6, 10]
    nums2 = [-7, -1, 1, 2, 3, 4, 4, 6, 9, 10]
    k = 15
    print(sol.kthSmallestProduct(nums1, nums2, k) == 10)

    nums1 = [-4, -2, 0, 3]
    nums2 = [2, 4]
    k = 6
    print(sol.kthSmallestProduct(nums1, nums2, k) == 0)

    nums1 = [2, 5]
    nums2 = [3, 4]
    k = 2
    print(sol.kthSmallestProduct(nums1, nums2, k) == 8)
