from collections import Counter
from typing import List


class Solution:
    """
    Dec 23, 2024 10:59
    Time Complexity:
    """
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        count = Counter(arr)
        frequencies = set()
        for num, freq in count.items():
            if freq not in frequencies:
                frequencies.add(freq)
            else:
                return False

        return True
