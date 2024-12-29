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
    Dec 29, 2024 02:00
    Time Complexity: O(n)
    Space Complexity: O((H)
    """

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        if not root:
            return 0

        stack = [(root, [])]
        count = 0
        while stack:
            node, parent_val = stack.pop()
            sum = node.val
            if sum == targetSum:
                count += 1
            for val in reversed(parent_val):
                sum += val
                if sum == targetSum:
                    count += 1

            if node.right:
                stack.append((node.right, parent_val + [node.val]))
            if node.left:
                stack.append((node.left, parent_val + [node.val]))

        return count


if __name__ == '__main__':
    sol = Solution()
    root = TreeNode(10)
    root.left = TreeNode(5)
    root.right = TreeNode(-3)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(2)
    root.right.right = TreeNode(11)
    root.left.left.left = TreeNode(3)
    root.left.left.right = TreeNode(-2)
    root.left.right.right = TreeNode(1)

    print(sol.pathSum(root, 8))
