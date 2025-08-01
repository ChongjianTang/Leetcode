"""
Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.

You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.



Example 1:



Input: root = [4,2,5,1,3]


Output: [1,2,3,4,5]

Explanation: The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.

Example 2:

Input: root = [2,1,3]
Output: [1,2,3]


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
All the values of the tree are unique.
"""


# Definition for a Node.
class Node:
    """
    Jun 30, 2025 11:28
    Time Complexity: O(n)
    Space Complexity: O(logn)
    """

    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def treeToDoublyList(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return root

        head, tail = self.helper(root)
        tail.right = head
        head.left = tail
        return head

    def helper(self, root: 'Node'):
        if root.left:
            left_head, left_tail = self.helper(root.left)
            root.left = left_tail
            left_tail.right = root
        else:
            left_head = root

        if root.right:
            right_head, right_tail = self.helper(root.right)
            root.right = right_head
            right_head.left = root
        else:
            right_tail = root

        return left_head, right_tail


if __name__ == '__main__':
    sol = Solution()
    root = Node(4)
    root.left = Node(2)
    root.left.left = Node(1)
    root.left.right = Node(3)
    root.right = Node(5)

    sol.treeToDoublyList(root)
