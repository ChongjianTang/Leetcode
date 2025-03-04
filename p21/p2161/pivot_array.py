from typing import List


class Solution:
    """
    Mar 02, 2025 17:46
    Time Complexity: O(n)
    Space Complexity: O(n)
    """
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        ans = [pivot] * len(nums)

        i = 0
        for num in nums:
            if num < pivot:
                ans[i] = num
                i += 1

        j = len(nums) - 1
        for num in reversed(nums):
            if num > pivot:
                ans[j] = num
                j -= 1

        return ans