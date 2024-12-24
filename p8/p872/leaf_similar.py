# Definition for a binary tree node.
from typing import Optional
from unittest.mock import right


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    """
    DFS
    Dec 24, 2024 15:18
    Time Complexity O(n)
    Space Complexity: O(H)
    """
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        return self.get_leaf_sequence_iterative(root1) == self.get_leaf_sequence_iterative(root2)

    def get_leaf_sequence_iterative(self, root: Optional[TreeNode]):
        leaf_seq = []
        stack = []

        if root:
            stack.append(root)

        while stack:
            node = stack.pop()

            if node.right:
                stack.append(node.right)

            if node.left:
                stack.append(node.left)

            if not node.right and not node.left:
                leaf_seq.append(node.val)

        return leaf_seq
