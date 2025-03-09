from typing import List


class Solution:
    def numberOfAlternatingGroups(self, colors: List[int], k: int) -> int:
        left = right = 0
        n = len(colors)
        count = 0
        while left != n - 1:
            next_index = (right + 1) % n
            if colors[right] + colors[next_index] == 1:
                right = next_index
                if (right - left + n + 1) % n == k:
                    count += 1
                elif (right - left + n + 1) % n > k:
                    left += 1
            else:

