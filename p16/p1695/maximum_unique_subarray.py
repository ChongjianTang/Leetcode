"""
You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you
get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).



Example 1:

Input: nums = [4,2,4,5,6]
Output: 17
Explanation: The optimal subarray here is [2,4,5,6].
Example 2:

Input: nums = [5,2,1,2,5,2,1,2,5]
Output: 8
Explanation: The optimal subarray here is [5,2,1] or [1,2,5].


Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104
"""
from typing import List


class Solution:
    """
    Jul 21, 2025 18:06
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        left = 0
        right = 1
        total = nums[0]
        result = total
        num_set = set()
        num_set.add(nums[0])
        while right < len(nums):
            while nums[right] in num_set:
                total -= nums[left]
                num_set.remove(nums[left])
                left += 1

            num_set.add(nums[right])
            total += nums[right]
            right += 1
            result = max(result, total)

        return result


if __name__ == '__main__':
    obj = Solution()
    nums = [5, 2, 1, 2, 5, 2, 1, 2, 5]
    print(obj.maximumUniqueSubarray(nums))

    nums = [4, 2, 4, 5, 6]
    print(obj.maximumUniqueSubarray(nums))
