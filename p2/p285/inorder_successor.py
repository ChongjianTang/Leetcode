"""
Given the root of a binary search tree and a node p in it, return the in-order successor of that node in the BST. If the given node has no in-order successor in the tree, return null.

The successor of a node p is the node with the smallest key greater than p.val.



Example 1:


Input: root = [2,1,3], p = 1
Output: 2
Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.
Example 2:


Input: root = [5,3,6,2,4,null,null,1], p = 6
Output: null
Explanation: There is no in-order successor of the current node, so the answer is null.


Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
All Nodes will have unique values.
"""
# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    """
    Jul 09, 2025 15:30
    Time Complexity: O(logn)
    Space Complexity: O(1)
    """

    def inorderSuccessor(self, root: TreeNode, p: TreeNode) -> Optional[TreeNode]:
        parent = None

        curr = root
        while curr:
            if curr.val > p.val:
                parent = curr
                curr = curr.left
            else:
                curr = curr.right
        return parent


class Solution1:
    """
    Jul 09, 2025 15:19
    Time Complexity: O(logn)
    Space Complexity: O(1)
    """

    def inorderSuccessor(self, root: TreeNode, p: TreeNode) -> Optional[TreeNode]:
        if p.right:
            result = p.right
            while result.left:
                result = result.left
            return result

        curr = root
        parent = None
        while curr != p:
            if curr.val > p.val:
                if curr.left:
                    parent = curr
                    curr = curr.left
                else:
                    return None
            else:
                if curr.right:
                    curr = curr.right
                else:
                    return None

        return parent


if __name__ == '__main__':
    obj = Solution()
    root = TreeNode(2)
    root.right = TreeNode(3)
    p = root
    print(obj.inorderSuccessor(root,p).val)


    root = TreeNode(5)
    root.left = TreeNode(3)
    root.right = TreeNode(6)
    root.left.left = TreeNode(1)
    root.left.right = TreeNode(4)
    root.left.left.right = TreeNode(2)
    p = root.left.right
    print(obj.inorderSuccessor(root, p).val)

    root = TreeNode(2)
    root.left = TreeNode(1)
    p = root.left
    print(obj.inorderSuccessor(root, p).val)
