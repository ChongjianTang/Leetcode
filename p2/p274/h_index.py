from typing import List


class Solution:
    """
    Jun 02, 2025 14:42
    Time Complexity: O(nlogn)
    Space Complexity: O(n)
    """

    def hIndex(self, citations: List[int]) -> int:
        sorted_citations = sorted(citations, reverse=True)
        result = 0
        for i in range(len(sorted_citations)):
            if sorted_citations[i] >= i + 1:
                result = max(result, i + 1)

        return result
