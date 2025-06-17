from typing import List


class Solution:
    """
    Jun 10, 2025 16:47
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def verifyPreorder(self, preorder: List[int]) -> bool:
        stack = []
        min_val = -1
        for num in preorder:
            if num < min_val:
                return False
            while stack and stack[-1] < num:
                min_val = stack.pop()

            stack.append(num)

        return True
