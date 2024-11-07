class Solution:
    """
    Nov 03, 2024 21:48
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    def reverseWords(self, s: str) -> str:
        words = s.split()
        result = reversed(words)

        return " ".join(result)
