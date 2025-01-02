# Definition for a binary tree node.
from collections import deque
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    """
    BFS
    Jan 02, 2025 14:00
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        queue = deque()
        queue.append(root)

        result = []

        while queue:
            result.append(queue[-1].val)
            next_queue = deque()
            while queue:
                node = queue.popleft()
                if node.left:
                    next_queue.append(node.left)

                if node.right:
                    next_queue.append(node.right)

            queue = next_queue

        return result
