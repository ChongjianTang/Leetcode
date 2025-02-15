from typing import List


class Solution:
    """
    Feb 04, 2025 01:12
    Time Complexity: O((n+m)logn)
    Space Complexity: O(logn)
    """

    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()
        left = 0
        right = len(potions) - 1
        result = []
        for spell in spells:
            if potions[left] * spell >= success:
                result.append(len(potions))
            elif potions[right] * spell < success:
                result.append(0)
            else:
                index = self.binary_search(potions, left, right, success / spell)
                result.append(len(potions) - index)

        return result

    def binary_search(self, arr, start, end, target):
        if start == end - 1:
            return end
        mid = (start + end) // 2
        if arr[mid] < target:
            return self.binary_search(arr, mid, end, target)
        else:
            return self.binary_search(arr, start, mid, target)
