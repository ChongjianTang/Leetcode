# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    """
    DFS iterative
    Dec 29, 2024 03:29
    Time Complexity: O(n)
    Space Complexity: O(H)
    """

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.dfs(root, p, q)[1]

    def dfs(self, root: TreeNode, p: TreeNode, q: TreeNode) -> (int, TreeNode):
        current = 0
        if root == p or root == q:
            current = 1

        left_count = 0
        if root.left:
            left_count, ancestor = self.dfs(root.left, p, q)
            if ancestor:
                return -1, ancestor

        right_count = 0
        if root.right:
            right_count, ancestor = self.dfs(root.right, p, q)
            if ancestor:
                return -1, ancestor

        if current + left_count + right_count == 2:
            return -1, root

        return current + right_count + left_count, None

class Solution1:
    """
    DFS iterative
    Dec 29, 2024 03:29
    Time Complexity: O(n)
    Space Complexity: O(H)
    """

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.dfs(root, p, q)[1]

    def dfs(self, root: TreeNode, p: TreeNode, q: TreeNode) -> (int, TreeNode):
        current = 0
        if root == p or root == q:
            current = 1

        left_count = 0
        if root.left:
            left_count, ancestor = self.dfs(root.left, p, q)
            if ancestor:
                return -1, ancestor

        right_count = 0
        if root.right:
            right_count, ancestor = self.dfs(root.right, p, q)
            if ancestor:
                return -1, ancestor

        if current + left_count + right_count == 2:
            return -1, root

        return current + right_count + left_count, None
