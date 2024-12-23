from collections import Counter
from typing import List


class Solution:
    """
    Two Pointer
    Dec 22, 2024 16:44
    Time Complexity: O(nlogn)
    Space Complexity: O(1)
    """

    def maxOperations(self, nums: List[int], k: int) -> int:
        nums.sort()
        left, right = 0, len(nums) - 1
        result = 0
        while left < right:
            if nums[left] + nums[right] == k:
                result += 1
                left += 1
                right -= 1
            elif nums[left] + nums[right] < k:
                left += 1
            else:
                right -= 1

        return result

    """
    Dec 22, 2024 16:44
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def maxOperations1(self, nums: List[int], k: int) -> int:
        count = Counter(nums)

        result = 0

        seen = set()

        for num in count:
            if num not in seen:
                if 2 * num == k:
                    result += count[num] // 2
                else:
                    result += min(count[num], count[k - num])
                    seen.add(num)
                    seen.add(k - num)

        return result
