# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    """
    DFS iterative
    Dec 29, 2024 02:21
    Time Complexity: O(n)
    Space Complexity: O(H)
    """
    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        stack = [(root, 0, 0)]

        max_length = 0
        while stack:
            node, left, right = stack.pop()
            max_length = max(max_length, left, right)

            if node.right:
                stack.append((node.right, right + 1, 0))
            if node.left:
                stack.append((node.left, 0, left + 1))

        return max_length
