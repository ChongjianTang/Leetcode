from typing import List


class Solution:
    """
    Feb 15, 2025 00:53
    Time Complexity: O(n*4^n)
    Space Complexity: O(1)
    """

    def letterCombinations(self, digits: str) -> List[str]:
        digits_dict = {
            '2': ['a', 'b', 'c'],
            '3': ['d', 'e', 'f'],
            '4': ['g', 'h', 'i'],
            '5': ['j', 'k', 'l'],
            '6': ['m', 'n', 'o'],
            '7': ['p', 'q', 'r', 's'],
            '8': ['t', 'u', 'v'],
            '9': ['w', 'x', 'y', 'z']
        }

        result = []
        for digit in digits:
            if not result:
                result = digits_dict[digit].copy()
            else:
                result = [letters + char for letters in result for char in digits_dict[digit]]

        return result
