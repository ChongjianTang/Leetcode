from collections import deque


class Solution:
    """
    Dec 23, 2024 15:16
    Time Complexity: O(n)
    Space Complexity: O(n)
    """
    def removeStars(self, s: str) -> str:
        stack = deque()
        for c in s:
            if c == '*':
                stack.pop()
            else:
                stack.append(c)

        return "".join(stack)