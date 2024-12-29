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
    Dec 29, 2024 01:27
    Time Complexity: O(n)
    Space Complexity: O(H)
    """
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if not root:
            return []

        stack = [(root, targetSum, [])]

        result = []

        while stack:
            node, target_sum, node_path = stack.pop()
            if not node.left and not node.right:
                if node.val == target_sum:
                    result.append(node_path + [node.val])
            if node.left:
                stack.append((node.left, target_sum - node.val, node_path + [node.val]))
            if node.right:
                stack.append((node.right, target_sum - node.val, node_path + [node.val]))

        return result
