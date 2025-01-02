# Definition for a binary tree node.
from encodings.rot_13 import rot13
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    """
    Jan 02, 2025 14:50
    Time Complexity: O(logn)/O(H)
    Space Complexity: O(H)
    """

    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if root.val == val:
            return root
        elif root.val < val:
            if root.right:
                return self.searchBST(root.right, val)
            else:
                return None
        else:
            if root.left:
                return self.searchBST(root.left, val)
            else:
                return None
