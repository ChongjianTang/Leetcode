"""
Given the root of a binary tree, find the largest subtree, which is also a Binary Search Tree (BST), where the largest means subtree has the largest number of nodes.

A Binary Search Tree (BST) is a tree in which all the nodes follow the below-mentioned properties:

The left subtree values are less than the value of their parent (root) node's value.
The right subtree values are greater than the value of their parent (root) node's value.
Note: A subtree must include all of its descendants.



Example 1:



Input: root = [10,5,15,1,8,null,7]
Output: 3
Explanation: The Largest BST Subtree in this case is the highlighted one. The return value is the subtree's size, which is 3.
Example 2:

Input: root = [4,2,7,2,3,5,null,2,null,null,null,null,null,1]
Output: 2


Constraints:

The number of nodes in the tree is in the range [0, 104].
-104 <= Node.val <= 104


Follow up: Can you figure out ways to solve it with O(n) time complexity?
"""

# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    """
    Jul 01, 2025 15:47
    Time Complexity: O(n)
    Space Complexity: O(H) = O(logn)
    """

    def largestBSTSubtree(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        _, _, _, _, max_count = self.helper(root)
        return max_count

    def helper(self, root: TreeNode) -> [bool, int, int, int, int]:
        is_bst = True
        if root.left:
            left_is_bst, left_min_val, left_max_val, left_count, left_max_count = self.helper(root.left)
            if not left_is_bst:
                is_bst = False
        else:
            left_min_val = root.val
            left_max_val = root.val - 1
            left_count = 0
            left_max_count = 0

        if root.right:
            right_is_bst, right_min_val, right_max_val, right_count, right_max_count = self.helper(root.right)
            if not right_is_bst:
                is_bst = False

        else:
            right_min_val = root.val + 1
            right_max_val = root.val
            right_count = 0
            right_max_count = 0
        if not is_bst:
            return [False, -1, -1, -1, max(left_max_count, right_max_count)]

        if left_max_val < root.val < right_min_val:
            return [True, left_min_val, right_max_val, left_count + right_count + 1, left_count + right_count + 1]
        else:
            return [False, -1, -1, -1, max(left_max_count, right_max_count)]


if __name__ == '__main__':
    obj = Solution()
    root = TreeNode(10)
    root.left = TreeNode(5)
    root.left.left = TreeNode(1)
    root.left.right = TreeNode(8)
    root.right = TreeNode(15)
    root.right.right = TreeNode(7)

    print(obj.largestBSTSubtree(root))
