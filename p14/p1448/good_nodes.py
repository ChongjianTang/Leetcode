# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    """
    DFS recursive
    Dec 27, 2024 01:28
    Time Complexity: O(n)
    Space Complexity: O(H)
    """

    def goodNodes(self, root: TreeNode) -> int:
        return self.dfs(root, root.val)

    def dfs(self, root: TreeNode, max_val: int) -> int:
        count = 0
        if root.val >= max_val:
            count += 1
            max_val = root.val
        if root.left:
            count += self.dfs(root.left, max_val)
        if root.right:
            count += self.dfs(root.right, max_val)

        return count


class Solution2:
    """
    DFS iterative
    Dec 29, 2024 00:30
    Time Complexity: O(n)
    Space Complexity: O(H)
    """

    def goodNodes(self, root: TreeNode) -> int:
        stack = [(root, root.val)]
        count = 0
        while stack:
            node, max_val = stack.pop()
            if node.val >= max_val:
                count += 1
                max_val = node.val

            if node.right:
                stack.append((node.right, max_val))

            if node.left:
                stack.append((node.left, max_val))

        return count
