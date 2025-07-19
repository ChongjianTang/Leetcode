"""
You are given a 0-indexed integer array nums consisting of 3 * n elements.

You are allowed to remove any subsequence of elements of size exactly n from nums. The remaining 2 * n elements will be divided into two equal parts:

The first n elements belonging to the first part and their sum is sumfirst.
The next n elements belonging to the second part and their sum is sumsecond.
The difference in sums of the two parts is denoted as sumfirst - sumsecond.

For example, if sumfirst = 3 and sumsecond = 2, their difference is 1.
Similarly, if sumfirst = 2 and sumsecond = 3, their difference is -1.
Return the minimum difference possible between the sums of the two parts after the removal of n elements.



Example 1:

Input: nums = [3,1,2]
Output: -1
Explanation: Here, nums has 3 elements, so n = 1.
Thus we have to remove 1 element from nums and divide the array into two equal parts.
- If we remove nums[0] = 3, the array will be [1,2]. The difference in sums of the two parts will be 1 - 2 = -1.
- If we remove nums[1] = 1, the array will be [3,2]. The difference in sums of the two parts will be 3 - 2 = 1.
- If we remove nums[2] = 2, the array will be [3,1]. The difference in sums of the two parts will be 3 - 1 = 2.
The minimum difference between sums of the two parts is min(-1,1,2) = -1.
Example 2:

Input: nums = [7,9,5,8,1,3]
Output: 1
Explanation: Here n = 2. So we must remove 2 elements and divide the remaining array into two parts containing two elements each.
If we remove nums[2] = 5 and nums[3] = 8, the resultant array will be [7,9,1,3]. The difference in sums will be (7+9) - (1+3) = 12.
To obtain the minimum difference, we should remove nums[1] = 9 and nums[4] = 1. The resultant array becomes [7,5,8,3]. The difference in sums of the two parts is (7+5) - (8+3) = 1.
It can be shown that it is not possible to obtain a difference smaller than 1.


Constraints:

nums.length == 3 * n
1 <= n <= 10^5
1 <= nums[i] <= 10^5
"""
import heapq
from typing import List


class Solution:
    """
    Jul 18, 2025 13:53
    Time Complexity: O(nlogn)
    Space Complexity: O(n)
    """

    def minimumDifference(self, nums: List[int]) -> int:
        n = len(nums) // 3
        max_heap = [-x for x in nums[:n]]
        total = sum(max_heap)
        heapq.heapify(max_heap)
        sum_firsts = [0] * (n + 1)
        sum_firsts[0] = total
        for i in range(n, 2 * n):
            heapq.heappush(max_heap, -nums[i])
            total += -nums[i]
            total -= heapq.heappop(max_heap)
            sum_firsts[i - n + 1] = total

        min_heap = nums[2 * n:]
        total = sum(min_heap)
        heapq.heapify(min_heap)
        sum_seconds = [0] * (n + 1)
        sum_seconds[-1] = total
        for i in range(2 * n - 1, n - 1, -1):
            heapq.heappush(min_heap, nums[i])
            total += nums[i]
            total -= heapq.heappop(min_heap)
            sum_seconds[i - n] = total

        result = [-sum_firsts[i] - sum_seconds[i] for i in range(len(sum_firsts))]
        return min(result)


if __name__ == '__main__':
    obj = Solution()
    nums = [7, 9, 5, 8, 1, 3]
    print(obj.minimumDifference(nums))

    nums = [3, 1, 2]
    print(obj.minimumDifference(nums))
