# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    """
    DFS stack Iteration
    Dec 24, 2024 15:04
    Time Complexity: O(n)
    Space Complexity: O(H)
    """

    def maxDepth(self, root: Optional[TreeNode]) -> int:
        stack = []
        if root:
            stack.append((root, 1))

        max_depth = 0
        while stack:
            node = stack.pop()
            max_depth = max(max_depth, node[1])
            if node[0].right:
                stack.append((node[0].right, node[1] + 1))
            if node[0].left:
                stack.append((node[0].left, node[1] + 1))

        return max_depth
