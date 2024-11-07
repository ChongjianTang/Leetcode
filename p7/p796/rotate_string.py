class Solution:
    """
    Nov 02, 2024 18:13
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    def rotateString(self, s: str, goal: str) -> bool:
        if len(s) != len(goal):
            return False
        else:
            return goal in (s + s)
