from collections import Counter


class Solution:
    """
    Dec 23, 2024 13:50
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def closeStrings(self, word1: str, word2: str) -> bool:
        count1 = Counter(word1)
        count2 = Counter(word2)

        set1 = count1.keys()
        set2 = count2.keys()

        if set1 != set2:
            return False

        freq1 = Counter(count1.values())
        freq2 = Counter(count2.values())
        if freq1 != freq2:
            return False

        return True
