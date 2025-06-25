class Solution:
    """
    Jun 24, 2025 12:01
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def lengthOfLastWord(self, s: str) -> int:
        return len(s.strip().split(" ")[-1])
