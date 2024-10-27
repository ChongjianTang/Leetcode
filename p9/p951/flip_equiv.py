from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    """
    Oct 24, 2024 16:40
    Time Complexity: O(min(n1,n2)
    Space Complexity: O(min(h1,h2)
    """
    def flipEquiv(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        if root1 is None and root2 is None:
            return True
        elif root1 is not None and root2 is not None:
            return root1.val == root2.val and (
                    self.flipEquiv(root1.left, root2.right) and self.flipEquiv(root1.right, root2.left)) or (
                    self.flipEquiv(root1.left, root2.left) and self.flipEquiv(root1.right, root2.right))
        else:
            return False


if __name__ == '__main__':
    s = Solution()

    root1 = TreeNode(0, TreeNode(4), TreeNode(1, None, TreeNode(2, None, TreeNode(3))))
    root2 = TreeNode(0, TreeNode(1), TreeNode(4, TreeNode(2, None, TreeNode(3))))
    print(s.flipEquiv(root1, root2) == False)
