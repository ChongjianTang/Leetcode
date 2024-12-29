"""
# Definition for a Node.
class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None
"""


class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None


class Solution:
    """
    To find the intersection of two linked list
    Dec 29, 2024 03:39
    Time Complexity: O(logn) (O(x+y) x and y is the length of the parent so they are logn)
    Space Complexity: O(1)
    """

    def lowestCommonAncestor(self, p: 'Node', q: 'Node') -> 'Node':
        start_p = p
        start_q = q
        while p != q:
            if not p:
                p = start_q
            else:
                p = p.parent
            if not q:
                q = start_p
            else:
                q = q.parent

        return p
