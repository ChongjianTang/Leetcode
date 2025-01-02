# Definition for a binary tree node.
from collections import deque
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    """
    BFS
    Jan 02, 2025 14:34
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        queue = deque()

        level = 1
        level_sum = root.val
        max_level_sum = level_sum
        max_level_sum_level = 1

        queue.append(root)
        while queue:
            next_queue = deque()
            while queue:
                node = queue.popleft()
                level_sum += node.val

                if node.left:
                    next_queue.append(node.left)

                if node.right:
                    next_queue.append(node.right)

            if level_sum > max_level_sum:
                max_level_sum_level = level
                max_level_sum = level_sum
            level_sum = 0
            level += 1

            queue = next_queue

        return max_level_sum_level
