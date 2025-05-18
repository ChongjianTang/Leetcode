from typing import List


class Solution:
    """
    May 14, 2025 18:41
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def getLongestSubsequence(self, words: List[str], groups: List[int]) -> List[str]:
        result = [words[0]]
        flag = groups[0]

        for i in range(1, len(words)):
            if groups[i] != flag:
                result.append(words[i])
                flag = groups[i]

        return result
