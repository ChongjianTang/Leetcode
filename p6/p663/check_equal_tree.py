# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    """
    Jun 15, 2025 18:12
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def checkEqualTree(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return False

        tree_vals = {}
        self.helper(root, tree_vals)

        return self.check_equal(tree_vals[root], root, tree_vals)

    def helper(self, root: TreeNode, tree_vals) -> int:
        if not root.left and not root.right:
            tree_vals[root] = root.val
            return root.val

        val = 0
        if root.left:
            val += self.helper(root.left, tree_vals)

        if root.right:
            val += self.helper(root.right, tree_vals)

        tree_vals[root] = val + root.val
        return val + root.val

    def check_equal(self, total_val, root: TreeNode, tree_vals):
        if root.left:
            if total_val - tree_vals[root.left] == tree_vals[root.left]:
                return True

            if self.check_equal(total_val, root.left, tree_vals):
                return True

        if root.right:
            if total_val - tree_vals[root.right] == tree_vals[root.right]:
                return True

            if self.check_equal(total_val, root.right, tree_vals):
                return True

        return False
