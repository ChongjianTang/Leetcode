# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    """
    BST
    Jan 02, 2025 15:51
    Time Complexity: O(logn)/O(H)
    Space Complexity: O(logn)/O(H)
    """

    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if not root:
            return None

        if key < root.val:
            root.left = self.deleteNode(root.left, key)
        elif key > root.val:
            root.right = self.deleteNode(root.right, key)
        else:
            if not root.left and not root.right:
                return None

            if not root.left:
                return root.right
            if not root.right:
                return root.left

            next_node = root.right
            while next_node.left:
                next_node = next_node.left
            root.val = next_node.val

            root.right = self.deleteNode(root.right, next_node.val)

        return root
