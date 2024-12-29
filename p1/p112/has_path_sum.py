# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    """
    DFS recursive
    Dec 29, 2024 00:44
    Time Complexity: O(n)
    Space Complexity: O(H)
    """

    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if not root:
            return False

        if not root.left and not root.right:
            return targetSum == root.val

        if (root.left and self.hasPathSum(root.left, targetSum - root.val)) or (
                root.right and self.hasPathSum(root.right, targetSum - root.val)):
            return True
        else:
            return False


class Solution2:
    """
    DFS iterative
    Dec 29, 2024 00:53
    Time Complexity: O(n)
    Space Complexity: O(H)
    """

    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if not root:
            return False

        stack = [(root, targetSum)]
        while stack:
            node, target_sum = stack.pop()
            if not node.left and not node.right:
                if node.val == target_sum:
                    return True

            if node.left:
                stack.append((node.left, target_sum - node.val))
            if node.right:
                stack.append((node.right, target_sum - node.val))

        return False


if __name__ == '__main__':
    sol = Solution()
    root = TreeNode(5)
    root.left = TreeNode(4)
    root.right = TreeNode(8)
    root.left.left = TreeNode(11)
    root.right.left = TreeNode(13)
    root.right.right = TreeNode(4)
    root.left.left.left = TreeNode(7)
    root.left.left.right = TreeNode(2)
    root.right.right.right = TreeNode(1)

    print(sol.hasPathSum(root, 22))
